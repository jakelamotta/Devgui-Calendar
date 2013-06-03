package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.AddEventAction;
import controller.EditEventAction;


/**
 * The GUI that appears when the Add event button is pressed.
 * @author Deha
 *
 */
public class EventGUI extends JFrame
{
	private static final long serialVersionUID = -6918601926489258608L;
	
	private JTextField eventField;
    
	private JComboBox month;
    private JComboBox day;
    private JComboBox year;
	private JTextField categoryField;
	private JSlider priority;
	private JPanel mainPanel;
	private JPanel editPanel;
	private JPanel buttonPanel;
	private JButton addEventButton;
	
	
	// required for edit in table action
	private int tableRow = -1;
	
	
	/**
	 * The constructor that is run when the "Add event button" is pressed.
	 * It sets up a JPanel with JTextField to get data about a new task.
	 * When "OK" is pressed the data in the text fields are fetched and used
	 * to create a new task, and add it to the JTable/xml in the EventPanel.
	 */
	public EventGUI(){
            
		init(new AddEventAction("Add Event", this));
	}
	
	public EventGUI(String name, String dueDate, String category, int prio, int modelRow){
        
		init(new EditEventAction("Edit Event", this)); 
		eventField.setText(name);
		
		String[] dateParts = dueDate.split("-");
		year.setSelectedItem(dateParts[0]);
		month.setSelectedItem(dateParts[1]);
		day.removeAllItems();
		getDays(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]));
		day.setSelectedItem(dateParts[2]);
		categoryField.setText(category);
		priority.setValue(prio);
		tableRow = modelRow;
	}
	
	private void init(Action eventAction){
		eventField = new JTextField(20);

		GregorianCalendar today = new GregorianCalendar();
		day = new JComboBox(new DefaultComboBoxModel());
		year = new JComboBox(getYears());
		year.setSelectedItem(today.get(GregorianCalendar.YEAR));
		year.addItemListener(new ItemListener() {
					
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					day.removeAllItems();
					getDays(Integer.parseInt((String) year.getSelectedItem()), Integer.parseInt((String) month.getSelectedItem()));
				}
			}
		});
        month = new JComboBox(getMonths());
        month.setSelectedItem("" + (today.get(GregorianCalendar.MONTH)+1));
        month.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					day.removeAllItems();
					getDays(Integer.parseInt((String) year.getSelectedItem()), Integer.parseInt((String) month.getSelectedItem()));
				}
			}
		});
        getDays(today.get(GregorianCalendar.YEAR), today.get(GregorianCalendar.MONTH)+1);
        day.setSelectedItem("" + today.get(GregorianCalendar.DAY_OF_MONTH));
		
		categoryField = new JTextField(10);
		
		priority = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
                priority.setBackground(Color.darkGray);
		priority.setMinorTickSpacing(20);
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
	
		Insets inset = new Insets(2,2,5,2);
		c.insets = inset;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		JLabel name = new JLabel("Event Name");
                name.setForeground(Color.lightGray);
		name.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(name,c);
		c.gridx = 1;
		c.gridwidth = 4;
		editPanel.add(eventField, c);
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		JLabel date = new JLabel("Due Date");
                date.setForeground(Color.lightGray);
		date.setHorizontalAlignment(JLabel.RIGHT);
		c.gridwidth = 1;
		editPanel.add(date,c);
		c.gridx = 1;
		editPanel.add(year, c);
		c.gridx = 2;
		editPanel.add(month, c);
		c.gridx = 3;
		editPanel.add(day, c);
	
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		JLabel cate = new JLabel("Category");
                cate.setForeground(Color.lightGray);
		cate.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(cate,c);
		c.gridx = 1;
		c.gridwidth = 4;
		editPanel.add(categoryField, c);
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		JLabel prio = new JLabel("Priority");
                prio.setForeground(Color.lightGray);
		prio.setHorizontalAlignment(JLabel.RIGHT);
		editPanel.add(prio,c);
		c.gridx = 1;
		c.gridwidth = 4;
		editPanel.add(priority, c);

		buttonPanel = new JPanel(new GridBagLayout());
		addEventButton = new JButton(eventAction);
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
		setAlwaysOnTop(true);
	}

	public JTextField getEventField() {
		return eventField;
	}

	public JTextField getCategoryField() {
		return categoryField;
	}

	public JSlider getPriority() {
		return priority;
	}
	
	public int getTableRow() {
		return tableRow;
	}

	/**
     * Get 10 years starting from this year
     * It will be used in the UI.
     * @return listOfYears list of years
     */
    public String[] getYears(){
        GregorianCalendar today = new GregorianCalendar();
        int thisYear = today.get(GregorianCalendar.YEAR);
        String years [] = new String[10];
        for(int i=0; i<10; i++){
            years[i] = "" + (thisYear + i);
        }
        return years;
    }
    
    /**
     * Get months of the year
     * It will be used in the UI.
     * @return listOfMonths list of months
     */
    public String[] getMonths(){
    	String months [] = new String[12];
        for(int i=0; i<12; i++){
        	months[i] = "" + (1 + i);
        }
        return months;
    }

    /**
     * Get days of the month
     * It will be used in the UI.
     * @param selectedMonth the month that we are looking at
     * @param selectedYear  the year that we are looking at
     */
    public void getDays(int selectedYear, int selectedMonth){
        int count = 0;

        if(selectedMonth == 1 || selectedMonth == 3 ||
           selectedMonth == 5 || selectedMonth == 7 ||
           selectedMonth == 8 || selectedMonth == 10 ||
                                 selectedMonth == 12){

            count = 31;
        }
        else if(selectedMonth == 4 || selectedMonth == 6 ||
                selectedMonth == 9 || selectedMonth == 11){

            count = 30;
        }
        else{
            int remainder = selectedYear % 4;
            int remainder1 = selectedYear % 100;
            int remainder2 = selectedYear % 400;
            if((remainder2 == 0) || (remainder1 != 0 && remainder == 0)){
                    count = 29;
            }
            else{
                    count = 28;
            }
        }

        for(int i=1; i<=count; i++){
            day.addItem("" + i);
        }
    }

	public String getDate() {
		return "" + year.getSelectedItem() +  "-" + month.getSelectedItem() + "-"+ day.getSelectedItem();
	}
}
