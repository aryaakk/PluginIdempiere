package org.evenos.callouts;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MOrder;
import org.compiere.util.CLogger;

public class MyCallout implements IColumnCallout{
	
	CLogger log = CLogger.getCLogger(MyCallout.class); 

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		
		log.warning("Column Name : " + mField.getColumnName());
		log.warning("New Value : " + value.toString());
		log.warning("Old Value : " + oldValue.toString());
		
		mTab.setValue(MOrder.COLUMNNAME_DocumentNo, "Testt Callout Succes");
		
		return null;
	}

}
