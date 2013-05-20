package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.AddEventAction;


/**
 * The GUI that appears when the Add event button is pressed.
 * @author Deha
 *
 */

public class AddEventGUI extends JFrame
{
	private static final long serialVersionUID = -6918601926489258608L;
	
	private JTextField eventField;
	private JTextField dateField;
	private JTextField categoryField;
	private JSlider priority;
	private JPanel mainPanel;
	private JPanel editPanel;
	private JPanel buttonPanel;
	private JButton addEventButton;
	
	
	/**
	 * The constructor that is run when the "Add event button" is pressed.
	 * It sets up a JPanel with JTextField to get data about a new task.
	 * When "OK" is pressed the data in the text fields are fetched and used
	 * to create a new task, and add it to the JTable/xml in the EventPanel.
	 */
	public AddEventGUI(){
            
		eventField = new JTextField(20);
		dateField = new JTextField(20);
		categoryField = new JTextField(10);
		
		priority = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
                priority.setBackground(Color.darkGray);
		priority.setMinorTickSpacing(25);
		priority.setPaintTicks(true);
		priority.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				source.setBackground(new Color(source.getValue()*2+25, 255-source.getValue()*2, 0));
			}
		});
		
		editPanel = new JPanel();
		
		editPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//natural height, maximum width
		c.fill = GridBagConstraints.HORIZONTAL;
	
		c.gridx = 0;
		c.gridy = 0;
		JLabel name = new JLabel("Event Name");
                name.setForeground(Color.lightGray);
		name.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(name,c);
		c.gridx = 1;
		editPanel.add(eventField, c);
		
		c.gridx = 0;
		c.gridy = 2;
		JLabel date = new JLabel("Due Date");
                date.setForeground(Color.lightGray);
		date.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(date,c);
		c.gridx = 1;
		editPanel.add(dateField, c);
	
		c.gridx = 0;
		c.gridy = 3;
		JLabel cate = new JLabel("Category");
                cate.setForeground(Color.lightGray);
		cate.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(cate,c);
		c.gridx = 1;
		editPanel.add(categoryField, c);
		
		c.gridx = 0;
		c.gridy = 4;
		JLabel prio = new JLabel("Priority");
                prio.setForeground(Color.lightGray);
		prio.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(prio,c);
		c.gridx = 1;
		editPanel.add(priority, c);

		buttonPanel = new JPanel(new GridBagLayout());
		Action addEvent = new AddEventAction("Add Event", this);
		addEventButton = new JButton(addEvent);
		c.fill = (GridBagConstraints.HORIZONTAL);
		c.gridx = 1;
		c.gridy = 0;
		buttonPanel.add(addEventButton,c);
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(editPanel,BorderLayout.CENTER);
		mainPanel.add(buttonPanel,BorderLayout.SOUTH);
                buttonPanel.setBackground(Color.darkGray);
                editPanel.setBackground(Color.darkGray);
	
		setSize(350,200);
		setResizable(false);
		setContentPane(mainPanel);
		setVisible(true);
	}

	public JTextField getEventField() {
		return eventField;
	}

	public JTextField getDateField() {
		return dateField;
	}

	public JTextField getCategoryField() {
		return categoryField;
	}

	public JSlider getPriority() {
		return priority;
	}	

}
