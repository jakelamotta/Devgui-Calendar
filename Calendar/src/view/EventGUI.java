package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import model.Event;


/**
 * The Event class creates a JPanel to be added to the 
 * list of events in the EventPanel class.
 * @author Deha
 *
 */
public class EventGUI extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -81886355557044626L;
	JTextField nameTF;
	JTextField dateTF;
	JTextField cateTF;
	JProgressBar prioBar;
        

	/**
	 * The constructor that calls createPanel. 
	 * @param task The Event is to be added to the JList of Tasks
	 */
	public EventGUI(Event event) {
		createPanel(event);
	}
	
	/**
	 * Sets up five JTextFields to show the data acquired in the constructor
	 * and organizes them using the GridBagLayout
	 */
	public void createPanel(Event task) {
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setLayout(new GridBagLayout());
		nameTF = new JTextField(task.getEventName());
		dateTF = new JTextField(task.getEventDueDate());
		cateTF = new JTextField(task.getEventCategory());		
		prioBar = new JProgressBar(0, 5);
		prioBar.setValue(task.getEventPriority());
		
		nameTF.setHorizontalAlignment(JTextField.CENTER);
		dateTF.setHorizontalAlignment(JTextField.CENTER);
		cateTF.setHorizontalAlignment(JTextField.CENTER);
		       
		nameTF.setFont(new Font("sansserif", Font.PLAIN, 25));
		dateTF.setFont(new Font("sansserif", Font.PLAIN, 15));
		cateTF.setFont(new Font("sansserif", Font.ITALIC, 15));
                
		nameTF.setPreferredSize(new Dimension(30, 50));
		dateTF.setPreferredSize(new Dimension(15, 50));
		cateTF.setPreferredSize(new Dimension(15, 50));		
		prioBar.setPreferredSize(new Dimension(15, 50));
		
		GridBagConstraints nameTFConstraints = new GridBagConstraints();
		GridBagConstraints dateTFConstraints = new GridBagConstraints();
		GridBagConstraints cateTFConstraints = new GridBagConstraints();
		GridBagConstraints prioTFConstraints = new GridBagConstraints();
		
		nameTFConstraints.gridx = 0;
		nameTFConstraints.gridy = 0;
		nameTFConstraints.weightx = 1.0;
		nameTFConstraints.weighty = 1.0;
		nameTFConstraints.fill = GridBagConstraints.BOTH;
		
		dateTFConstraints.gridx = 2;
		dateTFConstraints.gridy = 0;
		dateTFConstraints.weightx = 0.5;
		dateTFConstraints.weighty = 1.0;
		dateTFConstraints.fill = GridBagConstraints.BOTH;
		
		cateTFConstraints.gridx = 3;
		cateTFConstraints.gridy = 0;
		cateTFConstraints.weightx = 0.5;
		cateTFConstraints.weighty = 1.0;
		cateTFConstraints.fill = GridBagConstraints.BOTH;
		
		prioTFConstraints.gridx = 4;
		prioTFConstraints.gridy = 0;
		prioTFConstraints.weightx = 0.5;
		prioTFConstraints.weighty = 1.0;
		prioTFConstraints.fill = GridBagConstraints.BOTH;
		
		this.add(nameTF, nameTFConstraints);
		this.add(dateTF, dateTFConstraints);
		this.add(cateTF, cateTFConstraints);
		this.add(prioBar, prioTFConstraints);
	}
	
	/**
	 * Used to set the background color of the panel
	 * by setting the background color of each JTextField
	 * of the panel.
	 * @param c The background color to change to
	 */
	public void setPanelColor(Color c) {
		nameTF.setBackground(c);
		dateTF.setBackground(c);
		cateTF.setBackground(c);
		prioBar.setBackground(c);
	}


}
