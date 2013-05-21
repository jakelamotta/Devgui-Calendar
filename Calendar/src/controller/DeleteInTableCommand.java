package controller;

import model.TableModel;
import application.CalendarApp;

/**
 * The concrete command that handles addition of a new event
 * @author Deha
 *
 */
public class DeleteInTableCommand implements Command {
	
	private TableModel tm;
	private Object[] et;
	private int modelRow;
	
	/**
	 * Constructor
	 * @param n the new event that will be added
	 * @param modelRow 
	 */
	public DeleteInTableCommand(int row) {
		modelRow = row;
		tm = CalendarApp.getFrame().getEventPanel().getModel();
		et = new Object[6];
		et[0] = tm.getValueAt(modelRow, 0);
		et[1] = tm.getValueAt(modelRow, 1);
		et[2] = tm.getValueAt(modelRow, 2);
		et[3] = tm.getValueAt(modelRow, 3);
		et[4] = tm.getValueAt(modelRow, 4);
		et[5] = tm.getValueAt(modelRow, 5);
	}

	/**
	 * Adds the new event to the table
	 */
	@Override
	public void execute() {
		tm.removeRow(modelRow);
	}

	/**
	 * Removes the added event from the table
	 */
	@Override
	public void unexecute() {
		
		tm.addRow(modelRow, et);
	}

	/**
	 * Adds the removed event back to the table
	 */
	@Override
	public void reexecute() {
		execute();
	}
}
