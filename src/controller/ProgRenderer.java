package controller;

import java.awt.Component;
import javax.swing.JProgressBar;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
* Renderer for the progress bar
* @author Bjorn from UIP I course
* @author Deha
*/

public class ProgRenderer extends JProgressBar implements TableCellRenderer {
	
	private static final long serialVersionUID = 6171144383058481465L;

	/**
	* Table cell renderer for the progress bar
	* @param table table
	* @param value value used for priority bar
	* @param isSelected value if cell is selected
	* @param hasFocus value if cell has focus
	* @param row the row that is queried
	* @param column the column that is queried
	* @return this priority bar with the value
	*/
	public Component getTableCellRendererComponent(JTable table, Object value, 
													boolean isSelected, boolean hasFocus, 
													int row, int column) 
	{
		this.setValue((Integer)value);
	    return this;
	}
}
