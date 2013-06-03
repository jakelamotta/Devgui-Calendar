package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

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
    private ArrayList<Event> data;

	private ArrayList<Event> tempData;
    private boolean filtered;
    
	
	/**
	*  Initiate XML handler and load data from XML 
	*  into an ArrayList. If the file is empty or do  
	*  not exist it initiates the ArrayList. 
	*/
    public TableModel() {
    	xmlh = new XMLHandler();
		xmlh.readXML(this, XMLHandler.XML_ITEMS);
		tempData = new ArrayList<Event>();
		if (data == null) {
			data = new ArrayList<Event>();
		}
		else{
			for(int i=0; i<getRowCount(); i++){
	    		
	    		Event t = new Event(data.get(i).getEventName(),
	    					data.get(i).getEventDueDate(),
	    					data.get(i).getEventCategory(),
	    					data.get(i).getEventPriority(),  
	 					    "Edit", 
	 					    "Delete");
	    			
	    		tempData.add(t);
	    	}
		}
		filtered = false;
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
	 
	 public void showUnfilteredTable(){
		 if(filtered){
				for(int i=getRowCount()-1; i>=0; i--){
		    		data.remove(i);
		    	}
				xmlh.readXML(this, XMLHandler.XML_ITEMS);
				fireTableDataChanged();
				filtered = false;
			}		 
	 }
	 
	public void dateFilterTable(String date){
		
		if(filtered){
			for(int i=getRowCount()-1; i>=0; i--){
	    		data.remove(i);
	    	}
			xmlh.readXML(this, XMLHandler.XML_ITEMS);
		}
		
		ArrayList<Event> filteredData = new ArrayList<Event>();
	
    	for(int i=0; i<getRowCount(); i++){
    		
    		if(((String) getValueAt(i, 1)).equalsIgnoreCase(date)){
    			
    			Event t = new Event(data.get(i).getEventName(),
    					data.get(i).getEventDueDate(),
    					data.get(i).getEventCategory(),
    					data.get(i).getEventPriority(),  
 					    "Edit", 
 					    "Delete");
    			
    			filteredData.add(t);    
    		}
    	}
    	
    	for(int i=getRowCount()-1; i>=0; i--){
    		data.remove(i);
    	}
    	
    	for(int i=0; i<filteredData.size(); i++){
    		data.add(filteredData.get(i));
    	}
    	
    	fireTableDataChanged();
    	filtered = true;
	} 
	
	public void priorityFilterTable(int priority){
		
		if(filtered){
			for(int i=getRowCount()-1; i>=0; i--){
	    		data.remove(i);
	    	}
			xmlh.readXML(this, XMLHandler.XML_ITEMS);
		}
		
		ArrayList<Event> filteredData = new ArrayList<Event>();
		
    	for(int i=0; i<getRowCount(); i++){
    		
    		if((Integer) getValueAt(i, 3) == priority){
    			
    			Event t = new Event(data.get(i).getEventName(),
    					data.get(i).getEventDueDate(),
    					data.get(i).getEventCategory(),
    					data.get(i).getEventPriority(),  
 					    "Edit", 
 					    "Delete");
    			
    			filteredData.add(t);	    
    		}
    	}
    	
    	for(int i=getRowCount()-1; i>=0; i--){
    		data.remove(i);
    	}
    	
    	for(int i=0; i<filteredData.size(); i++){
    		data.add(filteredData.get(i));
    	}
    	
    	fireTableDataChanged();
    	filtered = true;
	}

	/**
	* Adds row into the table and updates XML
	* @param values contain values that should be added into the row
	*/	
    public void addRow(Object[] values){
    	Event t = new Event();
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
     * Adds row into the table according to row number and updates XML	
     * @param row defines where the new row will be added
     * @param values contain values that should be added into the row
     */
    public void addRow(int row, Object[] values){
    	Event t = new Event();
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
	*  Remove row from the table and updates XML
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

	public boolean isFiltered() {
		return filtered;
	}
	
	public Event getRow(int index){
		return data.get(index);
	}
	
	@SuppressWarnings("deprecation")
	public boolean hasEvent(Date d) {
		boolean hasEvent = false;
		for(int i=0; i<tempData.size(); i++){
			GregorianCalendar gre = InputUtilities.convertStringToDate(tempData.get(i).getEventDueDate());
			//System.out.println(d + " : " + gre.get(GregorianCalendar.DAY_OF_MONTH) + "-" + gre.get(GregorianCalendar.MONTH) + "-" + gre.get(GregorianCalendar.YEAR) );
    		if(gre.getTime().getDate() == d.getDate() &&
    				gre.getTime().getMonth() == d.getMonth() &&
    						gre.getTime().getYear() == d.getYear()){

    			hasEvent = true;
    		}
    	}
		return hasEvent;
	}
}
