/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.raise.model.asset_assignment;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for RED_Asset_Assignment_Line
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="RED_Asset_Assignment_Line")
public class X_RED_Asset_Assignment_Line extends PO implements I_RED_Asset_Assignment_Line, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230522L;

    /** Standard Constructor */
    public X_RED_Asset_Assignment_Line (Properties ctx, int RED_Asset_Assignment_Line_ID, String trxName)
    {
      super (ctx, RED_Asset_Assignment_Line_ID, trxName);
      /** if (RED_Asset_Assignment_Line_ID == 0)
        {
			setA_Asset_ID (0);
			setAD_User_ID (0);
			setRED_Asset_Assignment_ID (0);
			setRED_Asset_Assignment_Line_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RED_Asset_Assignment_Line (Properties ctx, int RED_Asset_Assignment_Line_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, RED_Asset_Assignment_Line_ID, trxName, virtualColumns);
      /** if (RED_Asset_Assignment_Line_ID == 0)
        {
			setA_Asset_ID (0);
			setAD_User_ID (0);
			setRED_Asset_Assignment_ID (0);
			setRED_Asset_Assignment_Line_ID (0);
        } */
    }

    /** Load Constructor */
    public X_RED_Asset_Assignment_Line (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_RED_Asset_Assignment_Line[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_A_Asset getA_Asset() throws RuntimeException
	{
		return (org.compiere.model.I_A_Asset)MTable.get(getCtx(), org.compiere.model.I_A_Asset.Table_ID)
			.getPO(getA_Asset_ID(), get_TrxName());
	}

	/** Set Asset.
		@param A_Asset_ID Asset used internally or by customers
	*/
	public void setA_Asset_ID (int A_Asset_ID)
	{
		if (A_Asset_ID < 1)
			set_ValueNoCheck (COLUMNNAME_A_Asset_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_A_Asset_ID, Integer.valueOf(A_Asset_ID));
	}

	/** Get Asset.
		@return Asset used internally or by customers
	  */
	public int getA_Asset_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Asset_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getAD_User_ID(), get_TrxName());
	}

	/** Set User/Contact.
		@param AD_User_ID User within the system - Internal or Business Partner Contact
	*/
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1)
			set_Value (COLUMNNAME_AD_User_ID, null);
		else
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException
	{
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_ID)
			.getPO(getC_Activity_ID(), get_TrxName());
	}

	/** Set Activity.
		@param C_Activity_ID Business Activity
	*/
	public void setC_Activity_ID (int C_Activity_ID)
	{
		if (C_Activity_ID < 1)
			set_Value (COLUMNNAME_C_Activity_ID, null);
		else
			set_Value (COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
	}

	/** Get Activity.
		@return Business Activity
	  */
	public int getC_Activity_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Activity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_Location getC_Location() throws RuntimeException
	{
		return (I_C_Location)MTable.get(getCtx(), I_C_Location.Table_ID)
			.getPO(getC_Location_ID(), get_TrxName());
	}

	/** Set Address.
		@param C_Location_ID Location or Address
	*/
	public void setC_Location_ID (int C_Location_ID)
	{
		if (C_Location_ID < 1)
			set_Value (COLUMNNAME_C_Location_ID, null);
		else
			set_Value (COLUMNNAME_C_Location_ID, Integer.valueOf(C_Location_ID));
	}

	/** Get Address.
		@return Location or Address
	  */
	public int getC_Location_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_RED_Asset_Assignment getRED_Asset_Assignment() throws RuntimeException
	{
		return (I_RED_Asset_Assignment)MTable.get(getCtx(), I_RED_Asset_Assignment.Table_ID)
			.getPO(getRED_Asset_Assignment_ID(), get_TrxName());
	}

	/** Set Asset Assignment.
		@param RED_Asset_Assignment_ID Asset Assignment
	*/
	public void setRED_Asset_Assignment_ID (int RED_Asset_Assignment_ID)
	{
		if (RED_Asset_Assignment_ID < 1)
			set_ValueNoCheck (COLUMNNAME_RED_Asset_Assignment_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_RED_Asset_Assignment_ID, Integer.valueOf(RED_Asset_Assignment_ID));
	}

	/** Get Asset Assignment.
		@return Asset Assignment	  */
	public int getRED_Asset_Assignment_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RED_Asset_Assignment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Asset Assignment Line.
		@param RED_Asset_Assignment_Line_ID Asset Assignment Line
	*/
	public void setRED_Asset_Assignment_Line_ID (int RED_Asset_Assignment_Line_ID)
	{
		if (RED_Asset_Assignment_Line_ID < 1)
			set_ValueNoCheck (COLUMNNAME_RED_Asset_Assignment_Line_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_RED_Asset_Assignment_Line_ID, Integer.valueOf(RED_Asset_Assignment_Line_ID));
	}

	/** Get Asset Assignment Line.
		@return Asset Assignment Line	  */
	public int getRED_Asset_Assignment_Line_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RED_Asset_Assignment_Line_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set RED_Asset_Assignment_Line_UU.
		@param RED_Asset_Assignment_Line_UU RED_Asset_Assignment_Line_UU
	*/
	public void setRED_Asset_Assignment_Line_UU (String RED_Asset_Assignment_Line_UU)
	{
		set_Value (COLUMNNAME_RED_Asset_Assignment_Line_UU, RED_Asset_Assignment_Line_UU);
	}

	/** Get RED_Asset_Assignment_Line_UU.
		@return RED_Asset_Assignment_Line_UU	  */
	public String getRED_Asset_Assignment_Line_UU()
	{
		return (String)get_Value(COLUMNNAME_RED_Asset_Assignment_Line_UU);
	}
}