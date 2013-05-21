package controller;

import application.CalendarApp;
import model.TableModel;

/**
 * The concrete command that handles edit action of a row
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
	 * Constructor - keeps the values before edit
	 * @param a - Name of the Event
	 * @param b - Due date of the Event
	 * @param c - Category of the Event
	 * @param d - Priority of the Event
	 * @param row - the row that is edited
	 */
	public EditInTableCommand(String a, String b, String c, int d, int row) {
		modelRow = row;
		tm = CalendarApp.getFrame().getEventPanel().getModel();
		et = new Object[6];
		et[0] = tm.getValueAt(modelRow, 0);
		et[1] = tm.getValueAt(modelRow, 1);
		et[2] = tm.getValueAt(modelRow, 2);
		et[3] = tm.getValueAt(modelRow, 3);
		et[4] = tm.getValueAt(modelRow, 4);
		et[5] = tm.getValueAt(modelRow, 5);
		
		name = a;
		dueDate = b;
		category = c;
		priority = d;
	}

	/**
	 * Set the new values after edit action
	 */
	@Override
	public void execute() {
		tm.setValueAt(name, modelRow, 0);
		tm.setValueAt(dueDate, modelRow, 1);
		tm.setValueAt(category, modelRow, 2);
		tm.setValueAt(priority, modelRow, 3);
	}

	/**
	 * Set values to before edit action
	 */
	@Override
	public void unexecute() {
		tm.setValueAt(et[0], modelRow, 0);
		tm.setValueAt(et[1], modelRow, 1);
		tm.setValueAt(et[2], modelRow, 2);
		tm.setValueAt(et[3], modelRow, 3);
	}

	/**
	 * Sets the values to after edit action
	 */
	@Override
	public void reexecute() {
		execute();
	}
}