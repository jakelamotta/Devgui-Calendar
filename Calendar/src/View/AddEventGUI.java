package View;

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

import Controller.AddNewEventCommand;
import Model.EventTable;

/**
 * The GUI that appears when the Add task button is pressed.
 * @author Deha
 *
 */

public class AddEventGUI extends JFrame
{
	private static final long serialVersionUID = -6918601926489258608L;

	
	/**
	 * The constructor that is run when the "Add task button" is pressed.
	 * It sets up a JPanel with JTextField to get data about a new task.
	 * When "OK" is pressed the data in the text fields are fetched and used
	 * to create a new task, and add it to the JTable/xml in the TaskPanel.
	 */
	public AddEventGUI(){
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
		
		JPanel editPanel = new JPanel();
		
		editPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//natural height, maximum width
		c.fill = GridBagConstraints.HORIZONTAL;
	
		c.gridx = 0;
		c.gridy = 0;
		JLabel name = new JLabel("Event Name");
		name.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(name,c);
		c.gridx = 1;
		editPanel.add(taskField, c);
		
		c.gridx = 0;
		c.gridy = 2;
		JLabel date = new JLabel("Due Date");
		date.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(date,c);
		c.gridx = 1;
		editPanel.add(dateField, c);
	
		c.gridx = 0;
		c.gridy = 3;
		JLabel cate = new JLabel("Category");
		cate.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(cate,c);
		c.gridx = 1;
		editPanel.add(categoryField, c);
		
		c.gridx = 0;
		c.gridy = 4;
		JLabel prio = new JLabel("Priority");
		prio.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(prio,c);
		c.gridx = 1;
		editPanel.add(priority, c);
		
		String[] options = {"OK","Cancel"};
		
		int result = JOptionPane.showOptionDialog(null, editPanel, "Add Event",
		 								JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		
		//A new task is added to the Table of Tasks in TaskPanel
		if (result == JOptionPane.OK_OPTION) {
				//check if the task name is provided
				 if (taskField.getText().equals(""))
					{
						 //JOptionPane.showMessageDialog(
					               //Main.getView().getTaskPanel().table, TaskomaticResourceBundle.getLanguageResourceBundle().getString("WarningMessage"),
					                //"Warning",
					                //JOptionPane.WARNING_MESSAGE);
						 new AddEventGUI();
					}
				 else
				 {
				//adds the event to the table 
				 EventTable t = new EventTable(new Boolean(false) ,new Boolean(false),taskField.getText(),
						 					dateField.getText(),categoryField.getText(),  
											priority.getValue(),  "Edit", "Delete");
				
				 AddNewEventCommand addNewEventCommand = new AddNewEventCommand(t);
				Frame.getInvoker().executeCommand(addNewEventCommand );
				 } 
		
		}
	}
	

}
