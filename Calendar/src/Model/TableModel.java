package Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

//import org.simpleframework.xml.ElementList;
//import org.simpleframework.xml.Root;
//import taskomatic.XMLHandler;

/**
 * This class defines the table model 
 * @author Deha
 *
 */

public class TableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1585636867604774966L;
	//private XMLHandler xmlh;
    private String[] columnNames = {"DoneStatus",
    								"MarkColumn",
    								"TaskColumn",
    								"DescriptionColumn",
    								"DueDateColumn",
    								"CategoryColumn",
    								"PriorityColumn",
    								"EditColumn",
    								"DeleteColumn"};
    private ArrayList<EventTable> data;
    
	
	/**
	*  Initiate XML handler and load data from XML 
	*  into an arraylist. If the file is empty or do  
	*  not exist it initiates the arraylist. 
	*/
    public TableModel() {
		//xmlh = new XMLHandler();
		//xmlh.readXML(this, XMLHandler.XML_ITEMS);
		if (data == null) {
			data = new ArrayList<EventTable>();
		}
    }

	/**
	* Adds row into the table and updates xml
	* @param values contain values that should be added into the row
	*/
	
    public void addRow(Object[] values){
    	EventTable t = new EventTable();
    	t.setDone((boolean)values[0]);
    	t.setCheck((boolean)values[1]);
    	t.setEventName((String) values[2]);
    	t.setEventDueDate((String) values[3]);
	  	t.setEventCategory((String) values[4]);
	   	t.setEventPriority((int) values[5]);
	   	t.setbutton1((String) values[6]);
	    t.setbutton2((String) values[7]);
	    data.add(t);
	    //xmlh.writeXML(this, XMLHandler.XML_ITEMS);
		fireTableDataChanged();
	}

	/**
	*  Remove row from the table and updates xml
	*  @param row the row being queried
	*/
			 
	 public void removeRow(int row){
	    data.remove(row);
	    //xmlh.writeXML(this, XMLHandler.XML_ITEMS);
	    fireTableDataChanged();
   }

	/**
	* Returns number of columns.  
	* @return columnnNames.length number of columns
	*/
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	* Returns number of rows  
	* @return data.size number of rows
	*/
 
	public int getRowCount() {
		
		 return data.size();
	}

	/**
	* Returns specific column name	
	* @param col the column being queried
	* @return columnNames[col] name of the column
	*/
 
	 public String getColumnName(int col){
		 return columnNames[col];
	 }

	 /**
	 * Return value for specific cell in the table
	 * @param row the row being queried
	 * @param col the column being queried
	 * @return The value of the cell at row row and column col in the table.
	 */
	 
	 public Object getValueAt(int row, int col)
	    {
		 switch (col) {
		    case 0: return data.get(row).getDone();
		    case 1: return data.get(row).getCheck();
		    case 2: return data.get(row).getEventName();
		    case 4: return data.get(row).getEventDueDate();
		    case 5: return data.get(row).getEventCategory();
		    case 6: return data.get(row).getEventPriority();
		    case 7: return data.get(row).getbutton1();
		    case 8: return data.get(row).getbutton2();
		    default: return null;
		  }
	    }
	 
	 /**
	 * Gets collects the relevant properties of a task from a row in the table,
	 * creates a Task object with the collected properties and returns it.
	 * @param row the row being queried
	 * @return The Task of the specified row.
	 */
	 
	 public Event getTaskFromRow(int row) {
		 EventTable et = data.get(row);
		 Event event = new Event(et.getEventName(), et.getEventDueDate(), et.getEventCategory(), et.getEventPriority());
		 return event;
	 }
	
	/**
	 * Returns Object class depends on the index
	 * @param c column index
	 * @return The class of every item in the specified column
	 */
	 
	 public Class<?> getColumnClass(int c)
	    {
		 switch (c) {
		 	case 0: return Boolean.class;
		    case 1: return Boolean.class;
		    case 2: return String.class;
		    case 3: return String.class;
		    case 4: return String.class;
		    case 5: return String.class;
		    case 6: return Integer.class;
		    case 7: return String.class;
		    case 8: return String.class;
		    default: return null;
		  }
	    }
      
	 /**
	 * Decides which columns are possible to edit
	 * @param row the row being queried
	 * @param col the column being queried
	 * @return true if the specified column is editable, otherwise false.
	 */
	 
	 public boolean isCellEditable(int row, int col) {
		 if (col <= 3 || col >= 7 || col == 5) {
              return true;
          } else {
              return false;
          }
	    }
	 
}
