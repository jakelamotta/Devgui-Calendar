package Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import Model.TableModel;
import View.EditPanel;

/**
 * The Action that perform edition of specific row in the table
 * @author Rafal from UIP I course
 * @author Deha
 * 
 */
public class EditInTableAction extends AbstractAction{
	
	private static final long serialVersionUID = 241403663318566147L;

			public void actionPerformed(ActionEvent e)
	         {
	             JTable table = (JTable)e.getSource();
				 
				 //temporarily saves data for specific row 
	             int modelRow = Integer.valueOf( e.getActionCommand() );
	             String a =  (String) ((TableModel)table.getModel()).getValueAt(modelRow,0);
	             String b =  (String) ((TableModel)table.getModel()).getValueAt(modelRow,1);
	             String c =  (String) ((TableModel)table.getModel()).getValueAt(modelRow,2);
	             int d =  (int) ((TableModel)table.getModel()).getValueAt(modelRow,3);
				 //sends data to EditPanel
	             new EditPanel(a,b,c,d,modelRow);
	         }			
	}

