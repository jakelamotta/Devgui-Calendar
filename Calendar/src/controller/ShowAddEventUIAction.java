package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import view.AddEventGUI;


public class ShowAddEventUIAction extends AbstractAction {
	
	public ShowAddEventUIAction(String name) {
		putValue(Action.NAME, name);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new AddEventGUI();
	}

}
