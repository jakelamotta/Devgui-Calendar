package Controller;

import Model.EventTable;
import View.Frame;

/**
 * The concrete command that implements Command interface
 * @author Deha
 *
 */
public class AddNewEventCommand implements Command {
	
	private EventTable newEvent;
	
	/**
	 * Constructor
	 * @param n
	 */
	public AddNewEventCommand(EventTable n) {
		newEvent = n;
	}

//Command interface's methods are overridden to enable undo/redo functionality
	@Override
	public void execute() {
		 Frame.getEventPanel().addEventToTable(newEvent);
	}

	@Override
	public void unexecute() {
		Frame.getEventPanel().getModel().removeRow(Frame.getEventPanel().getModel().getRowCount()-1);
	}

	@Override
	public void reexecute() {
		execute();
	}

}
