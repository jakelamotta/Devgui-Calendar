package Controller;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

import View.AddEventGUI;

/**
 * The Action that instantiates the AddTaskGUI
 * @author Deha
 *
 */
public class AddEventAction extends AbstractAction {
	
	private static final long serialVersionUID = 8432852662784652822L;

	public AddEventAction(String name) {
		putValue(Action.NAME, name);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new AddEventGUI();
		
	}
}
