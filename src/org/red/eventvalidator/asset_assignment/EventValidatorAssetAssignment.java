package org.red.eventvalidator.asset_assignment;

import java.sql.ResultSet;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;
import org.osgi.service.event.Event;
import org.red.model.asset_assignment.MAssetAssignment;
import org.red.model.asset_assignment.MAssetAssignmentLine;

public class EventValidatorAssetAssignment extends AbstractEventHandler{
	
	CLogger log = CLogger.getCLogger(EventValidatorAssetAssignment.class);

	@Override
	protected void doHandleEvent(Event event) {
		// TODO Auto-generated method stub	
		if(event.getTopic().equals(IEventTopics.DOC_BEFORE_COMPLETE)) {
			PO po = getPO(event);
			String sql = "SELECT * FROM RED_Asset_Assignment_Line WHERE RED_Asset_Assignment_ID = " + po.get_ID();
			
			try {
				CPreparedStatement pstmt = DB.prepareStatement(sql, null);
				ResultSet rs = pstmt.executeQuery();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		registerTableEvent(IEventTopics.DOC_BEFORE_COMPLETE, MAssetAssignment.Table_Name);
		registerTableEvent(IEventTopics.DOC_AFTER_COMPLETE, MAssetAssignment.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MAssetAssignmentLine.Table_Name);
	}
	
	private static Object getAssignmentLine(int RED_Asset_Assignment_Line) {
		String sql = "";
		
		CPreparedStatement stmt = DB.prepareStatement(sql, null);
		return null;
	}

}
