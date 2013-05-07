package Controller;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import Application.CalendarApp;
import Model.EventTable;
import View.AddEventGUI;

/**
 * The Action that handles entry of a new event
 * @author Deha
 *
 */
public class AddEventAction extends AbstractAction {
	
	private static final long serialVersionUID = 8432852662784652822L;
	private AddEventGUI addEventGUI;

	public AddEventAction(String name, AddEventGUI gui) {
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
			EventTable t = new EventTable(new Boolean(false),
					 					  new Boolean(false),
					 					  addEventGUI.getEventField().getText(),
					 					  addEventGUI.getDateField().getText(),
					 					  addEventGUI.getCategoryField().getText(),
					 					  addEventGUI.getPriority().getValue(),  
					 					  "Edit", 
					 					  "Delete");
			
			AddNewEventCommand addNewEventCommand = new AddNewEventCommand(t);
			CalendarApp.getInvoker().executeCommand(addNewEventCommand );
			
			addEventGUI.setVisible(false);
		}		
	}
}
