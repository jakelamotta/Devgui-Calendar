package Controller;

import Application.CalendarApp;
import Model.EventTable;

/**
 * The concrete command that handles addition of a new event
 * @author Deha
 *
 */
public class AddNewEventCommand implements Command {
	
	private EventTable newEvent;
	
	/**
	 * Constructor
	 * @param n the new event that will be added
	 */
	public AddNewEventCommand(EventTable n) {
		newEvent = n;
	}

	/**
	 * Adds the new event to the table
	 */
	@Override
	public void execute() {
		CalendarApp.getFrame().getEventPanel().addEventToTable(newEvent);
	}

	/**
	 * Removes the added event from the table
	 */
	@Override
	public void unexecute() {
		CalendarApp.getFrame().getEventPanel().getModel().removeRow(CalendarApp.getFrame().getEventPanel().getModel().getRowCount()-1);
	}

	/**
	 * Adds the removed event back to the table
	 */
	@Override
	public void reexecute() {
		execute();
	}

}
