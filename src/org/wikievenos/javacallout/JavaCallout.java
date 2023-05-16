package org.wikievenos.javacallout;

import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MProduct;

public class JavaCallout extends CalloutEngine{
	
	public String JavaCalloutMethod(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
			
		System.out.println(WindowNo + " - " + mTab + " - " + mField + " - " + value);
			
		mTab.setValue(MProduct.COLUMNNAME_Description, "Test java callout success");
		
		return null;
	}
}
