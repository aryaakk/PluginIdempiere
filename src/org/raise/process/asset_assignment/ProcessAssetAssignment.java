package org.raise.process.asset_assignment;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAsset;
import org.compiere.model.MUser;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.raise.model.asset_assignment.MAssetAssignment;
import org.raise.model.asset_assignment.MAssetAssignmentLine;

public class ProcessAssetAssignment extends SvrProcess{
	
	private int A_Asset_ID;
	private int AD_User_ID;
	private int C_Activity_ID;
	private int C_Location_ID;

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] params = getParameter();
		for(ProcessInfoParameter param : params) {
			String paramName = param.getParameterName();
			
			if (paramName.equalsIgnoreCase("AD_User_ID")) {
				AD_User_ID = param.getParameterAsInt();
			} else if(paramName.equalsIgnoreCase("A_Asset_ID")) {
				A_Asset_ID = param.getParameterAsInt();
			} else if(paramName.equalsIgnoreCase("C_Activity_ID")) {
				C_Activity_ID = param.getParameterAsInt();
			} else if(paramName.equalsIgnoreCase("C_Location_ID")) {
				C_Location_ID = param.getParameterAsInt();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " +  paramName);				
			}
			
		}
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		MAsset asset = new MAsset(null, A_Asset_ID, null);
		MUser user = new MUser(null, AD_User_ID, null);
		MAssetAssignment Assignment = new MAssetAssignment(Env.getCtx(), 0, null);
		MAssetAssignmentLine AssignmentLine = new MAssetAssignmentLine(Env.getCtx(), 0, null);
		
		try {
			Assignment.setC_DocType_ID(1000000);
			Assignment.setC_DocTypeTarget_ID(1000000);
			Assignment.setRED_Assignment_Date(new Timestamp(System.currentTimeMillis()));
			Assignment.setDocAction(MAssetAssignment.DOCACTION_Complete);
			Assignment.setDocStatus(MAssetAssignment.DOCSTATUS_Drafted);
			Assignment.setIsActive(true);
			Assignment.saveEx();
			
			AssignmentLine.setRED_Asset_Assignment_ID(Assignment.getRED_Asset_Assignment_ID());
			AssignmentLine.setAD_User_ID(AD_User_ID);
			AssignmentLine.setC_Location_ID(C_Location_ID);
			AssignmentLine.setA_Asset_ID(A_Asset_ID);
			AssignmentLine.setC_Activity_ID(C_Activity_ID);
			AssignmentLine.setIsActive(true);
			AssignmentLine.saveEx();
			
			if(asset.get_ValueAsBoolean("isAssigned") == false) {
				asset.setAD_User_ID(AD_User_ID);
				asset.set_ValueOfColumn("isAssigned", true);
				asset.saveEx();
			}
			
			Assignment.setDocAction(MAssetAssignment.DOCACTION_Close);
			Assignment.setDocStatus(MAssetAssignment.DOCSTATUS_Completed);
			Assignment.setisAssigned(true);
			Assignment.setProcessed(true);
			Assignment.saveEx();
			
			addLog(getProcessInfo().getAD_Process_ID(), new Timestamp(System.currentTimeMillis()), new BigDecimal(asset.getA_Asset_ID()), "Asset Name : " + asset.getName());
			addLog(getProcessInfo().getAD_Process_ID(), new Timestamp(System.currentTimeMillis()), new BigDecimal(user.getAD_User_ID()), "Assign To : " + user.getName());
			
		} catch (Exception e) {
			
			throw new AdempiereException(e);
			
		}
			
		
		return "Success Assign";
	}

}
