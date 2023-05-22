package org.raise.model.asset_assignment;

import java.sql.ResultSet;
import java.util.Properties;

public class MAssetAssignmentLine extends X_RED_Asset_Assignment_Line{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2744514397038400717L;

	public MAssetAssignmentLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAssetAssignmentLine(Properties ctx, int RED_Asset_Assignment_Line_ID, String trxName) {
		super(ctx, RED_Asset_Assignment_Line_ID, trxName);
		// TODO Auto-generated constructor stub
	}


}
