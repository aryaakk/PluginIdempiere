package org.red.process.asset_assignment;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

public class ProcessFactoryAssetAssignment implements IProcessFactory{

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		
		if(className.equals("org.red.process.asset_assignment.ProcessAssetAssignment")) {
			return new ProcessAssetAssignment();
		}
		
		return null;
	}

}
