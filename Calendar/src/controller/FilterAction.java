package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import application.CalendarApp;

/**
 * 
 * @author Deha
 *
 */
public class FilterAction extends AbstractAction {
	
	public FilterAction(String name) {
		putValue(Action.NAME, name);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		CalendarApp.getFrame().getEventPanel().getModel().showUnfilteredTable();
		
		//CalendarApp.getFrame().getEventPanel().getModel().dateFilterTable("2013-5-31");
		
		//CalendarApp.getFrame().getEventPanel().getModel().priorityFilterTable(100);
	}

}
