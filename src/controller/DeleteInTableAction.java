package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import application.CalendarApp;

import model.TableModel;


/**
 * The Action that perform deletion of specific row in the table
 * @author Rafal from UIP I course
 * @author Deha
 */
public class DeleteInTableAction extends AbstractAction{
	
	private static final long serialVersionUID = 7991764614636653578L;
	
	Action delete;
	
	public DeleteInTableAction(){
	   
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 JTable table = (JTable)e.getSource();
	        int modelRow = Integer.valueOf( e.getActionCommand() );
	        int n = JOptionPane.showConfirmDialog(
	                table, "Are you sure you want to delete this task?","Delete task",
	                JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION);
	        if (n == JOptionPane.YES_OPTION) {
	        	 //((TableModel)table.getModel()).removeRow(modelRow);
	        	 
	        		//implement Command Pattern
	        	 	DeleteInTableCommand deleteInTableCommand = new DeleteInTableCommand(modelRow);
	 				CalendarApp.getInvoker().executeCommand(deleteInTableCommand);
	 			
	        } else if (n == JOptionPane.NO_OPTION) {
	          //closing the window
	        }
	}
}



