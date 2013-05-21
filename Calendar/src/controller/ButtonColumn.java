package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 *  The ButtonColumn class that sets a button into the cell in Jtable
 *  
 *  ButtonColumn is based on: http://tips4java.wordpress.com/2009/07/12/table-button-column/
 *	@author Rafal from UIP I course
 * 	@author Deha
 */
public class ButtonColumn extends AbstractCellEditor
	implements TableCellEditor, ActionListener, MouseListener, TableCellRenderer
{
	private static final long serialVersionUID = -3149144186039090674L;
	private JTable table;
	private Action action;
	private Border focusBorder;
	
	private JButton editButton;
	private Object editorValue;
	private boolean isButtonColumnEditor;
	
	private final Icon delico = new ImageIcon(getClass().getResource("delete.png"));
	private final Icon edit = new ImageIcon(getClass().getResource("edit.png"));
	
	/**
	 *  Create the ButtonColumn to be used as a renderer and editor. The
	 *  renderer and editor will automatically be installed on the TableColumn
	 *  of the specified column.
	 *
	 *  @param table the table containing the button renderer/editor
	 *  @param action the Action to be invoked when the button is invoked
	 *  @param column the column to which the button renderer/editor is added
	 */
	public ButtonColumn(JTable table, Action action, int column)
	{
		this.table = table;
		this.action = action;

		editButton = new JButton();
		editButton.setFocusPainted( false );
		editButton.addActionListener( this );
		setFocusBorder( new LineBorder(Color.BLUE) );

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(column).setCellRenderer( this );
		columnModel.getColumn(column).setCellEditor( this );
		table.addMouseListener( this );
	}


	/**
	 *  Get foreground color of the button when the cell has focus
	 *
	 *  @return the foreground color
	 */
	public Border getFocusBorder()
	{
		return focusBorder;
	}

	/**
	* Get button value
	* @return editButton edit button
	*/
	public JButton getButton()
	{
		return editButton;
	}
	
	/**
	 *  The foreground color of the button when the cell has focus
	 *
	 *  @param focusBorder the foreground color
	 */
	public void setFocusBorder(Border focusBorder)
	{
		this.focusBorder = focusBorder;
		editButton.setBorder( focusBorder );
	}

	/**
	* Editor for the buttons in the cell for the table
	* @param the table
	* @param value value for the button
	* @param isSelected value for check if cell is selected
	* @param row row that is queried
	* @param column column that is queried
	* @return editButton the button with specific icon
	*/
	@Override
	public Component getTableCellEditorComponent(
		JTable table, Object value, boolean isSelected, int row, int column)
	{
		if (value.equals("Delete"))
		{		
			editButton.setText( "" );
			editButton.setIcon(delico );
		}
		else if (value.equals("Edit"))
		{
			editButton.setText( "" );
			editButton.setIcon( edit );
		}
		
	this.editorValue = value;
	return editButton;
	}

	/**
	* Returns value of the cellEditor
	* @return editorValue 
	*/
	@Override
	public Object getCellEditorValue()
	{
		return editorValue;
	}

	/*
	 *	The button has been pressed. Stop editing and invoke the custom Action
	 */
	public void actionPerformed(ActionEvent e)
	{
		int row = table.convertRowIndexToModel( table.getEditingRow() );
		fireEditingStopped();

		//  Invoke the Action

		ActionEvent event = new ActionEvent(
			table,
			ActionEvent.ACTION_PERFORMED,
			"" + row);
		action.actionPerformed(event);
	}

//
//  Implement MouseListener interface
//
	/**
	 *  Defines actions when mouse button is pressed and released 
	 */
    public void mousePressed(MouseEvent e)
    {
    	if (table.isEditing()
		&&  table.getCellEditor() == this)
			isButtonColumnEditor = true;
    }

    public void mouseReleased(MouseEvent e)
    {
    	if (isButtonColumnEditor
    	&&  table.isEditing())
    		table.getCellEditor().stopCellEditing();

		isButtonColumnEditor = false;
    }
	
	
    public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}


    /**
     * Set Edit and Delete button icons in the table
     */
	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1,
			boolean arg2, boolean arg3, int arg4, int arg5) {
		if (arg1.equals("Delete"))
		{		
			editButton.setText( "" );
			editButton.setIcon(delico );
		}
		else if (arg1.equals("Edit"))
		{
			editButton.setText( "" );
			editButton.setIcon( edit );
		}
		
	return editButton;
	}
}
