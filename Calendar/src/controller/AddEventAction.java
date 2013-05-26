package controller;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import view.EventGUI;

import model.Event;

import application.CalendarApp;

/**
 * The Action that handles entry of a new event
 * @author Deha
 *
 */
public class AddEventAction extends AbstractAction {
	
	private static final long serialVersionUID = 8432852662784652822L;
	private EventGUI addEventGUI;

	/**
	 * Constructor
	 * @param name the mnemonic of Action event
	 * @param gui the interface to add a new event
	 */
	public AddEventAction(String name, EventGUI gui) {
		putValue(Action.NAME, name);
		addEventGUI = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
				
		//A new event will be added to the Table of Events in EventPanel
		
		//check if the event name is provided
		if (addEventGUI.getEventField().getText().equals("")) {
			 JOptionPane.showMessageDialog(addEventGUI, "Enter an event name!");
		}
		else {
			//adds the event to the table 
			Event t = new Event(addEventGUI.getEventField().getText(),
					 			addEventGUI.getDate(),
		 					    addEventGUI.getCategoryField().getText(),
		 					    addEventGUI.getPriority().getValue(),  
		 					    "Edit", 
		 					    "Delete");
			
			//implement Command Pattern
			AddEventCommand addNewEventCommand = new AddEventCommand(t);
			CalendarApp.getInvoker().executeCommand(addNewEventCommand );
			
			addEventGUI.setVisible(false);
		}		
	}
}
