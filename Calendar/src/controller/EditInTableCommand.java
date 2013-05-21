package controller;

import application.CalendarApp;
import model.TableModel;

/**
 * The concrete command that handles addition of a new event
 * @author Deha
 *
 */
public class EditInTableCommand implements Command {
		
	private TableModel tm;
	private Object[] et;
	private int modelRow;
	
	private String name,dueDate,category;
	private int priority;
	
	/**
	 * Constructor
	 * @param n the new event that will be added
	 */
	public EditInTableCommand(String a0, String b1, String c2, int d3, int row) {
		modelRow = row;
		tm = CalendarApp.getFrame().getEventPanel().getModel();
		et = new Object[6];
		et[0] = tm.getValueAt(modelRow, 0);
		et[1] = tm.getValueAt(modelRow, 1);
		et[2] = tm.getValueAt(modelRow, 2);
		et[3] = tm.getValueAt(modelRow, 3);
		et[4] = tm.getValueAt(modelRow, 4);
		et[5] = tm.getValueAt(modelRow, 5);
		
		name = a0;
		dueDate = b1;
		category = c2;
		priority = d3;
	}

	/**
	 * Adds the new event to the table
	 */
	@Override
	public void execute() {
		tm.setValueAt(name, modelRow, 0);
		tm.setValueAt(dueDate, modelRow, 1);
		tm.setValueAt(category, modelRow, 2);
		tm.setValueAt(priority, modelRow, 3);
	}

	/**
	 * Removes the added event from the table
	 */
	@Override
	public void unexecute() {
		tm.setValueAt(et[0], modelRow, 0);
		tm.setValueAt(et[1], modelRow, 1);
		tm.setValueAt(et[2], modelRow, 2);
		tm.setValueAt(et[3], modelRow, 3);
	}

	/**
	 * Adds the removed event back to the table
	 */
	@Override
	public void reexecute() {
		execute();
	}
}