package controller;

import model.Event;
import application.CalendarApp;

/**
 * The concrete command that handles addition of a new event
 * @author Deha
 *
 */
public class AddEventCommand implements Command {
	
	private Event newEvent;
	
	/**
	 * Constructor
	 * @param n the new event that will be added
	 */
	public AddEventCommand(Event n) {
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
