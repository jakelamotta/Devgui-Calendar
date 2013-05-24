package controller;

import model.TableModel;
import application.CalendarApp;

/**
 * The concrete command that handles deletion of an event
 * @author Deha
 *
 */
public class DeleteInTableCommand implements Command {
	
	private TableModel tm;
	private Object[] et;
	private int modelRow;
	
	/**
	 * Constructor - keeps the values before deletion
	 * @param row the row that will be deleted
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
	 * Removes the row
	 */
	@Override
	public void execute() {
		tm.removeRow(modelRow);
	}

	/**
	 * Adds the deleted row back
	 */
	@Override
	public void unexecute() {
		
		tm.addRow(modelRow, et);
	}

	/**
	 * Removes the added row back
	 */
	@Override
	public void reexecute() {
		execute();
	}
}
