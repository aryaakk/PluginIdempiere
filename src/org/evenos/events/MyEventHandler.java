package org.evenos.events;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.compiere.model.MOrder;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.osgi.service.event.Event;

public class MyEventHandler extends AbstractEventHandler{
	
	CLogger log = CLogger.getCLogger(MyEventHandler.class);

	@Override
	protected void doHandleEvent(Event event) {
		// TODO Auto-generated method stub
		
		PO po = getPO(event);
		
		if(po instanceof MOrder) {
			MOrder order = (MOrder)po;
			
			log.warning("DocNo : " + order.getDocumentNo() + " - " + "Topic Handler : " + event.getTopic());
		}
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MOrder.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MOrder.Table_Name);
		
	}

}
