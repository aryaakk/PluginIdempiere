package org.raise.processorder;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAsset;
import org.compiere.model.MOrder;
import org.compiere.model.X_C_Order;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

public class MyProcessOrder extends SvrProcess{
	
	private int c_order_id;
	private String description;
	private Timestamp date;

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
		ProcessInfoParameter[] para = getParameter();
		
		for(int i = 0; i < para.length; i++) {
			String paraName = para[i].getParameterName();
			
			if(para[i].getParameter() == null) {
				;
			}else if(paraName.equalsIgnoreCase("C_Order_ID")) {
				c_order_id = para[i].getParameterAsInt();
			}else if(paraName.equalsIgnoreCase("ChangeDescription")) {
				description = para[i].getParameterAsString();
			}else if(paraName.equalsIgnoreCase("Date")) {
				date = para[i].getParameterAsTimestamp();
			}else {
				log.severe("Unknown Parameter : " + paraName);
			}
		}
		
		log.warning("Prepare process with : " + "SalesOrder : " + c_order_id + "Description : " + description + "DateTime : " + date);
		
	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub
		
		if(description == null) {
			throw new AdempiereException("Tidak dapat mengganti description karna field description is empty");
		}
		
		MOrder order = new MOrder(null, c_order_id, null);
		
		addLog("Change Descriptions!");
		addLog(getProcessInfo().getAD_Process_ID(), 
				date, 
				new BigDecimal(getProcessInfo().getAD_User_ID()), 
				"Sales Order : " + c_order_id, MOrder.Table_ID, c_order_id);
		addLog(getProcessInfo().getAD_Process_ID(), 
				date, 
				new BigDecimal(getProcessInfo().getAD_User_ID()), 
				"Old Description : " + order.get_ValueAsString("description"));
		addLog(getProcessInfo().getAD_Process_ID(), 
				date, 
				new BigDecimal(getProcessInfo().getAD_User_ID()),
				"New Description : " + description);
		
		try {			
			X_C_Order order_ = new X_C_Order(null, c_order_id, null);
			order_.setDescription(description);
			order_.saveEx();
		} catch (Exception e) {
			// TODO: handle exception
			throw new AdempiereException(e);
		}
		return "Process Change Description Sales Order";
		
	}

}
