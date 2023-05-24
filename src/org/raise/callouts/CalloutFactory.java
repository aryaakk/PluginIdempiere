package org.raise.callouts;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.MProduct;

public class CalloutFactory implements IColumnCalloutFactory {

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
		// TODO Auto-generated method stub

		// Initializing an empty list.
		List<IColumnCallout> list = new ArrayList<IColumnCallout>();

		if (tableName.equals(MProduct.Table_Name) && columnName.equals(MProduct.COLUMNNAME_DocumentNote)) {
			list.add(new CalloutFromFactory());
		}
		if (tableName.equalsIgnoreCase(MProduct.Table_Name) && columnName.equalsIgnoreCase(MProduct.COLUMNNAME_Help)) {
			list.add(new CalloutFromFactory());
		}

		return list != null ? list.toArray(new IColumnCallout[0]) : new IColumnCallout[0];
	}

}
