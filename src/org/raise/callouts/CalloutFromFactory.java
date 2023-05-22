package org.raise.callouts;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;
import org.compiere.util.CLogger;

public class CalloutFromFactory implements IColumnCallout{
	
	CLogger log = CLogger.getCLogger(CalloutFromFactory.class);

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		
//		set logger in console
		log.warning("Column Name	: " + mField.getColumnName());
		log.warning("Old Value 		: " + oldValue.toString());
		log.warning("New Value     	: " + value.toString());
		
//		Setting the value in the description to validate that the callout has executed.
		mTab.setValue(MProduct.COLUMNNAME_Description, value.toString());
		return null;
	}

}
