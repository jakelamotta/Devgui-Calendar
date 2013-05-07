package Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


/**
 * This class defines the table model 
 * @author Deha
 *
 */

public class TableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1585636867604774966L;
	
    private String[] columnNames = {"DoneStatus",
    								"CheckMark",
    								"Event",
    								"Description",
    								"DueDate",
    								"Category",
    								"Priority",
    								"Edit",
    								"Delete"};
    private ArrayList<EventTable> data;
    
	
	/**
	*  Initiate XML handler and load data from XML 
	*  into an arraylist. If the file is empty or do  
	*  not exist it initiates the arraylist. 
	*/
    public TableModel() {
		
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
	    
		fireTableDataChanged();
	}

	/**
	*  Remove row from the table and updates xml
	*  @param row the row being queried
	*/
			 
	 public void removeRow(int row){
	    data.remove(row);
	    
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
	 
}
