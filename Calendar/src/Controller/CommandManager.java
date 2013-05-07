package Controller;

import java.util.ArrayList;

import View.Frame;

public class CommandManager {

	private ArrayList<Command> commandList;
	private int index;
	
	public CommandManager() {
		commandList = new ArrayList<Command>();
		index=-1;
	}
	 
	public void executeCommand(Command c) {
		if(index<(commandList.size()-1)){
			for(int i=commandList.size()-1-index; i>0; i--){
				commandList.remove(commandList.size()-1);
			}
		}
		index++;
		commandList.add(index, c);
		c.execute();
		Frame.setUndo(true);
		Frame.setRedo(false);
	}
	
	public boolean isUndoAvailable() {
		return !(index<0);	
	}

	public void unexecuteCommand() {
		Frame.setRedo(true);
		commandList.get(index).unexecute();
		index--;		
		if(isUndoAvailable()){
			Frame.setUndo(true);			
		}
		else{
			Frame.setUndo(false);
		}		
	}

	public boolean isRedoAvailable() {
		return index<(commandList.size()-1);
	}

	public void reexecuteCommand() {		
		Frame.setUndo(true);
		index++;
		commandList.get(index).reexecute();
		
		if(isRedoAvailable()){
			Frame.setRedo(true);
		}
		else{
			Frame.setRedo(false);
		}
	}
}
