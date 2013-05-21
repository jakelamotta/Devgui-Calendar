package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import controller.XMLHandler;



/**
 * This class defines the table model 
 * @author Deha
 *
 */
@Root
public class TableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1585636867604774966L;
	private XMLHandler xmlh;
    private String[] columnNames = {"Event",
    								"DueDate",
    								"Category",
    								"Priority",
    								"Edit",
    								"Delete"};
    @ElementList
    private ArrayList<EventTable> data;
    
	
	/**
	*  Initiate XML handler and load data from XML 
	*  into an arraylist. If the file is empty or do  
	*  not exist it initiates the arraylist. 
	*/
    public TableModel() {
    	xmlh = new XMLHandler();
		xmlh.readXML(this, XMLHandler.XML_ITEMS);
		if (data == null) {
			data = new ArrayList<EventTable>();
		}
    }
    
    /**
	 * Decides which columns are possible to edit
	 * @param row the row being queried
	 * @param col the column being queried
	 * @return true if the specified column is editable, otherwise false.
	 */	 
	 public boolean isCellEditable(int row, int col) {
		 if (col >= 4) {
              return true;
          } else {
              return false;
          }
	    }

	/**
	* Adds row into the table and updates xml
	* @param values contain values that should be added into the row
	*/	
    public void addRow(Object[] values){
    	EventTable t = new EventTable();
    	t.setEventName((String) values[0]);
    	t.setEventDueDate((String) values[1]);
    	t.setEventCategory((String) values[2]);
    	t.setEventPriority((Integer) values[3]);
    	t.setbutton1((String) values[4]);
    	t.setbutton2((String) values[5]);
    	data.add(t);
    	xmlh.writeXML(this, XMLHandler.XML_ITEMS);
        fireTableDataChanged();
	}
    
    /**
     * 	
     * @param row
     * @param values
     */
    public void addRow(int row, Object[] values){
    	EventTable t = new EventTable();
    	t.setEventName((String) values[0]);
    	t.setEventDueDate((String) values[1]);
    	t.setEventCategory((String) values[2]);
    	t.setEventPriority((Integer) values[3]);
    	t.setbutton1((String) values[4]);
    	t.setbutton2((String) values[5]);
    	data.add(row, t);
    	xmlh.writeXML(this, XMLHandler.XML_ITEMS);
        fireTableDataChanged();
	}

	/**
	*  Remove row from the table and updates xml
	*  @param row the row being queried
	*/			 
	 public void removeRow(int row){
	    data.remove(row);
	    xmlh.writeXML(this, XMLHandler.XML_ITEMS);
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
		    case 0: return data.get(row).getEventName();
		    case 1: return data.get(row).getEventDueDate();
		    case 2: return data.get(row).getEventCategory();
		    case 3: return data.get(row).getEventPriority();
		    case 4: return data.get(row).getbutton1();
		    case 5: return data.get(row).getbutton2();
		    default: return null;
		  }
	    }
	 
	 
	 /**
		 * Sets value for specific cell in the table. Updates the xml file
		 * and if DEBUG param is set to true prints out log of the changes made.
		 * DEBUG param is default set to true.
		 * @param value new alue for the cell
		 * @param row the row being queried
		 * @param col the column being queried
		 */		
		public void setValueAt(Object value, int row, int col){
		
			 switch (col) {
			    case 0:  data.get(row).setEventName((String) value);
			    		break;
			    case 1:  data.get(row).setEventDueDate((String) value);
			    		break;
			    case 2:  data.get(row).setEventCategory((String) value);
			    		break;
			    case 3:  data.get(row).setEventPriority((Integer) value);
			    		break;
			    case 4:  data.get(row).setbutton1((String) value);
			    		break;
			    case 5:  data.get(row).setbutton2((String) value);
			    		break;
			    default: System.err.println("Error setting new value");
			    
			  }
			
	    	 xmlh.writeXML(this, XMLHandler.XML_ITEMS);
			 fireTableCellUpdated(row,col);

		 }
}
