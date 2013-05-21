package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import application.CalendarApp;
import controller.EditInTableCommand;


/**
* The GUI that appears when the Add task button is pressed.
* @author Deha 
*/

public class EditPanel extends JFrame{
	
	private static final long serialVersionUID = 2492997705671130626L;
	
	/**
	 * The constructor that is run when the edit task button is pressed.
	 * It sets up a JPanel with JTextField to edit the data  for specific row.
	 * When "OK" is pressed the data in the text fields are fetched and used
	 * to create edit chosen task and saves it to the JTable/xml in the TaskPanel.
	 * @param a event field value
	 * @param b due date field value 
	 * @param c category field value
	 * @param d priority value
	 * @param modelRow number of the row in which changes should be performed
	 */
	
	public EditPanel(String a, String b, String c, int d, int modelRow) {
		
		JTextField taskField = new JTextField(20);
		JTextField dateField = new JTextField(20);
		JTextField categoryField = new JTextField(10);
		
		JSlider priority = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		
		priority.setBackground(new Color(0, 255, 0));
		priority.setMinorTickSpacing(25);
		priority.setPaintTicks(true);
		priority.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				source.setBackground(new Color(source.getValue()*2+25, 255-source.getValue()*2, 0));
			}
		});
		
		//sets the value in textfields
		taskField.setText(a);
		dateField.setText(b);
		categoryField.setText(c);
		priority.setValue(d);
		
		
		JPanel editPanel = new JPanel();
		editPanel.setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
				cons.fill = GridBagConstraints.HORIZONTAL;
			
				cons.gridx = 0;
				cons.gridy = 0;
				JLabel name = new JLabel("Event Name");
				name.setHorizontalAlignment(JLabel.RIGHT);
				editPanel.add(name,cons);
				cons.gridx = 1;
				editPanel.add(taskField, cons);
				
				cons.gridx = 0;
				cons.gridy = 2;
				JLabel date = new JLabel("Due Date");
				date.setHorizontalAlignment(JLabel.RIGHT);
				editPanel.add(date,cons);
				cons.gridx = 1;
				editPanel.add(dateField, cons);
			
				cons.gridx = 0;
				cons.gridy = 3;
				JLabel cate = new JLabel("Category");
				cate.setHorizontalAlignment(JLabel.RIGHT);
				editPanel.add(cate,cons);
				cons.gridx = 1;
				editPanel.add(categoryField, cons);
				
				cons.gridx = 0;
				cons.gridy = 4;
				JLabel prio = new JLabel("Priority");
				prio.setHorizontalAlignment(JLabel.RIGHT);
				editPanel.add(prio,cons);
				cons.gridx = 1;
				editPanel.add(priority, cons);
				
				String[] options = {"OK","Cancel"};
				
				int result = JOptionPane.showOptionDialog(null, editPanel, "Edit Event",
	
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		if (result == JOptionPane.OK_OPTION) {
			EditInTableCommand editInTableCommand = new EditInTableCommand(taskField.getText(),
																		   dateField.getText(), 
																		   categoryField.getText(),
																		   priority.getValue(),
																		   modelRow);
            //Implement Command Pattern
			CalendarApp.getInvoker().executeCommand(editInTableCommand);
		}
	}
}
