package Controller;

import Model.EventTable;
import View.Frame;

public class AddNewEventCommand implements Command {
	
	private EventTable newEvent;
	
	
	public AddNewEventCommand(EventTable n) {
		newEvent = n;
	}

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
