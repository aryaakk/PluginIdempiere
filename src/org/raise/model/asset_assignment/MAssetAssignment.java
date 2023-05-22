package org.raise.model.asset_assignment;

import java.sql.ResultSet;
import java.util.Properties;

public class MAssetAssignment extends X_RED_Asset_Assignment{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1979232908179486791L;

	public MAssetAssignment(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	 
	public MAssetAssignment(Properties ctx, int RED_Asset_Assignment_ID, String trxName) {
		super(ctx, RED_Asset_Assignment_ID, trxName);
		// TODO Auto-generated constructor stub
	}


}
