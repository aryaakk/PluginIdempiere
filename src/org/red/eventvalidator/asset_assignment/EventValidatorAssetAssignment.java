package org.red.eventvalidator.asset_assignment;

import java.sql.ResultSet;
import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAsset;
import org.compiere.model.MOrder;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.CallableResult;
import org.compiere.util.DB;
import org.osgi.service.event.Event;
import org.red.model.asset_assignment.MAssetAssignment;

public class EventValidatorAssetAssignment extends AbstractEventHandler{
	
	CLogger log = CLogger.getCLogger(EventValidatorAssetAssignment.class);
	private String query = "SELECT * FROM RED_Asset_Assignment_Line WHERE RED_Asset_Assignment_ID=";

	@Override
	protected void doHandleEvent(Event event) {
		// TODO Auto-generated method stub	
		if(event.getTopic().equals(IEventTopics.DOC_BEFORE_COMPLETE)) {
			PO po = getPO(event);
			String sql = query + po.get_ID();
			try {
				CPreparedStatement pstmt = DB.prepareStatement(sql, null);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {					
					while(rs.next()) {
						MAsset Asset = new MAsset(null, rs.getInt("A_Asset_ID"), null);
						if(Asset.get_ValueAsString("isAssigned") == "Y") {
							addErrorMessage(event, "Asset " + Asset.getName() + " already assigned");
							log.warning("Asset " + Asset.getName() + " already assigned");
						}
					}
				}else {
					addErrorMessage(event, "Asset Assignment don't have any line!!");
				}

				rs.close();
				pstmt.close();
				log.warning("~~~Topic : " + event.getTopic() + " ~~~PO : " + po + " ~~~PO getID : " + po.get_ID());
			} catch (Exception e) {
				// TODO: handle exception
				throw new AdempiereException(e);
			}
		} else if(event.getTopic().equals(IEventTopics.DOC_AFTER_COMPLETE)) {
			PO po = getPO(event);
			String sql = query + po.get_ID();
			try {
				CPreparedStatement pstmt = DB.prepareStatement(sql, null);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					MAsset Asset = new MAsset(null, rs.getInt("A_Asset_ID"), null);
					Asset.setAD_User_ID(rs.getInt("AD_User_ID"));
					Asset.set_ValueOfColumn("isAssigned", true);
					Asset.saveEx();
				}
				
				po.set_ValueOfColumn("isAssigned", true);
				po.saveEx();
				
				rs.close();
				pstmt.close();
				log.warning("~~~Topic : " + event.getTopic() + " ~~~PO : " + po + " ~~~PO getID : " + po.get_ID());
			} catch (Exception e) {
				// TODO: handle exception
				throw new AdempiereException(e);
			}
		}
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		registerTableEvent(IEventTopics.DOC_BEFORE_COMPLETE, MAssetAssignment.Table_Name);
		registerTableEvent(IEventTopics.DOC_AFTER_COMPLETE, MAssetAssignment.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MAssetAssignment.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MAssetAssignment.Table_Name);
	}

}
