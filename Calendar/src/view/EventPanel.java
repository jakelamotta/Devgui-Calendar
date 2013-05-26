package view;

import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import model.Event;
import model.TableModel;

import controller.ButtonColumn;
import controller.DeleteInTableAction;
import controller.EditInTableAction;
import controller.ProgRenderer;

/**
* The event panel of the view. 
* Contains the table with all the events and action components 
* like edit, delete, change to done/pending state
* @author Deha
* 
*/
public class EventPanel extends JPanel {
	
	private static final long serialVersionUID = 1411392940572978940L;
	private TableModel model; 
	private final JTable table;
	
	
	Action del = new DeleteInTableAction();
	Action edit = new EditInTableAction();
	
	
	/**
	* Initiate the task panel and all of its components.
	*/
	public EventPanel() {
		this.setLayout(new BorderLayout());
		model = new TableModel();
                
                table = new JTable(model);
                table.setAutoCreateRowSorter(true);
                table.setRowHeight(40);
			
		new ButtonColumn(table, edit, 4);
		
		new ButtonColumn(table, del, 5);
			
		TableColumn column = table.getColumnModel().getColumn(3);
		column.setCellRenderer(new ProgRenderer());
					
		DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();
		defaultRenderer.setHorizontalAlignment( JLabel.CENTER );
			
		table.getColumnModel().getColumn(0).setCellRenderer( defaultRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( defaultRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( defaultRenderer );
			
	    table.setFillsViewportHeight(true);  
		   
	    TableColumn editcell = table.getTableHeader().getColumnModel().getColumn(4);
	    editcell.setPreferredWidth(38);
	    editcell.setMaxWidth(38);
	    editcell.setMinWidth(38);
	      
	    TableColumn delcell = table.getTableHeader().getColumnModel().getColumn(5);
	    delcell.setPreferredWidth(38);
	    delcell.setMaxWidth(38);
	    delcell.setMinWidth(38);
	    this.add( new JScrollPane(table), BorderLayout.CENTER);
	}

	public TableModel getEvents() {
		return this.model;
	}
	
	/**
	 * Adds the new event to the table
	 * @param t
	 */
	public void addEventToTable(Event t) {
		this.model.addRow(new Object[]
		{t.getEventName(), t.getEventDueDate(), 
                t.getEventCategory(), t.getEventPriority(),  
		"Edit", "Delete"});
	}

	/**
	 * Getter method for the model of the table
	 * @return model the model of the table
	 */
	public TableModel getModel() {
		return model;
	}
		
}

