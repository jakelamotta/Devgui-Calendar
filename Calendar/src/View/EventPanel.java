package View;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import Model.EventTable;
import Model.TableModel;

/**
* The event panel of the view. 
* Contains the table with all the events and action components 
* like edit, delete, change to done/pending state
* 
* 
* Current State: edit and delete will be added
* @author Deha
* 
*/

public class EventPanel extends JPanel {
	
	private static final long serialVersionUID = 1411392940572978940L;
	private TableModel model; 
	
	/*
	Action del = new DeleteInTableAction();
	Action edit = new EditInTableAction();
	Action done = new DoneAction();
	*/
	
	/**
	* Initiate the task panel and all of its components.
	*/
	public EventPanel() {
		this.setLayout(new BorderLayout());
		model = new TableModel();
		
	    final JTable table = new JTable(model);
	    table.setAutoCreateRowSorter(true);
	    table.setRowHeight(40);
			
		//new ButtonColumn(table, done, 0);
		//new ButtonColumn(table, edit, 7);
		//new ButtonColumn(table, del, 8);
			
		//TableColumn column = table.getColumnModel().getColumn(5);
		//column.setCellRenderer(new ProgRenderer());
			
		//TableColumn dateCol = table.getColumnModel().getColumn(3);
		//dateCol.setCellRenderer(new DateCellRenderer());
			
		DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();
		defaultRenderer.setHorizontalAlignment( JLabel.CENTER );
			
		table.getColumnModel().getColumn(2).setCellRenderer( defaultRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( defaultRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( defaultRenderer );
			
	    table.setFillsViewportHeight(true);  
		         
	    TableColumn donecell = table.getTableHeader().getColumnModel().getColumn(0);
	    donecell.setPreferredWidth(40);
	    donecell.setMaxWidth(40);
	    donecell.setMinWidth(40);
		   
	    TableColumn editcell = table.getTableHeader().getColumnModel().getColumn(6);
	    editcell.setPreferredWidth(38);
	    editcell.setMaxWidth(38);
	    editcell.setMinWidth(38);
	        
	    TableColumn checkCell = table.getTableHeader().getColumnModel().getColumn(1);
	    checkCell.setPreferredWidth(38);
	    checkCell.setMaxWidth(38);
	    checkCell.setMinWidth(38);
	      
	    TableColumn delcell = table.getTableHeader().getColumnModel().getColumn(7);
	    delcell.setPreferredWidth(38);
	    delcell.setMaxWidth(38);
	    delcell.setMinWidth(38);
	    this.add( new JScrollPane(table), BorderLayout.CENTER);
	}

	public TableModel getEvents() {
		return this.model;
	}
	
	public void addEventToTable(EventTable t) {
		this.model.addRow(new Object[]{new Boolean(false), new Boolean(false),
						  t.getEventName(), t.getEventDueDate(), 
						  t.getEventCategory(), t.getEventPriority(),  
						  "Edit", "Delete"});
	}

	public TableModel getModel() {
		return model;
	}
		
}

