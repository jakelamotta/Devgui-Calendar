package controller;

/**
 * Command interface that includes methods to enables undo/redo functionality
 * @author Deha
 *
 */
public interface Command {
	/**
	 * This method executes the operation of the class
	 * that implements this interface
	 */
	public void execute();
	
	/**
	 * This method unexecutes the operation of the class
	 * that implements this interface
	 */
	public void unexecute();
	
	/**
	 * This method reexecutes the operation of the class
	 * that implements this interface
	 */
	public void reexecute();
}
