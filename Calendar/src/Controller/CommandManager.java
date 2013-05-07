package Controller;

import java.util.ArrayList;

import Application.CalendarApp;

/**
 * The invoker class that controls the Command methods
 * @author Deha
 *
 */
public class CommandManager {

	private ArrayList<Command> commandList;
	private int index;
	
	public CommandManager() {
		commandList = new ArrayList<Command>();
		index=-1;
	}
	
	/**
	 * This method adds the new Command to the commandList
	 * and sets the menu items for undo and redo correctly
	 * @param c the new command
	 */
	public void executeCommand(Command c) {
		if(index<(commandList.size()-1)){
			for(int i=commandList.size()-1-index; i>0; i--){
				commandList.remove(commandList.size()-1);
			}
		}
		index++;
		commandList.add(index, c);
		c.execute();
		CalendarApp.getFrame().setUndo(true);
		CalendarApp.getFrame().setRedo(false);
	}
	
	/**
	 * This method checks if undo can be done
	 * if index is not smaller than 0,
	 * which means that if the List is not empty,
	 * then it means there is a Command that can be unexecuted
	 * @return true or false depending on availability
	 */
	public boolean isUndoAvailable() {
		return !(index<0);	
	}

	/**
	 * This method undo the previously executed command
	 * and enables the redo menu item
	 */
	public void unexecuteCommand() {
		CalendarApp.getFrame().setRedo(true);
		commandList.get(index).unexecute();
		index--;		
		if(isUndoAvailable()){
			CalendarApp.getFrame().setUndo(true);			
		}
		else{
			CalendarApp.getFrame().setUndo(false);
		}		
	}

	/**
	 * This method checks if redo can be done,
	 * if index position is smaller than the size of the List,
	 * then redo is possible
	 * @return true or false depending on availability
	 */
	public boolean isRedoAvailable() {
		return index<(commandList.size()-1);
	}

	/**
	 * This method redo the undone event
	 */
	public void reexecuteCommand() {		
		CalendarApp.getFrame().setUndo(true);
		index++;
		commandList.get(index).reexecute();
		
		if(isRedoAvailable()){
			CalendarApp.getFrame().setRedo(true);
		}
		else{
			CalendarApp.getFrame().setRedo(false);
		}
	}
}
