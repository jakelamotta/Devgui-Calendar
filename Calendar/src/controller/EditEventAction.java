package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import application.CalendarApp;

import view.EventGUI;

public class EditEventAction extends AbstractAction {
	
	/**
	 * @author Deha
	 */
	private static final long serialVersionUID = 7045343146380830821L;
	private EventGUI editEventGUI;

	/**
	 * Constructor
	 * @param name the mnemonic of Action event
	 * @param gui the interface to add a new event
	 */
	public EditEventAction(String name, EventGUI gui) {
		putValue(Action.NAME, name);
		editEventGUI = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
				
		//A new event will be added to the Table of Events in EventPanel
		
		//check if the event name is provided
		if (editEventGUI.getEventField().getText().equals("")) {
			 JOptionPane.showMessageDialog(editEventGUI, "Enter an event name!");
		}
		else {
			//Implement Command Pattern
			EditInTableCommand editInTableCommand = new EditInTableCommand(editEventGUI.getEventField().getText(),
																			editEventGUI.getDate(), 
																			editEventGUI.getCategoryField().getText(),
																			editEventGUI.getPriority().getValue(),
																			editEventGUI.getTableRow());

			CalendarApp.getInvoker().executeCommand(editInTableCommand);
			
			editEventGUI.setVisible(false);
		}		
	}
}
