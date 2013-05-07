package Controller;

/**
 * Command interface that includes methods to enables undo/redo functionality
 * @author Deha
 *
 */
public interface Command {
	public void execute();
	public void unexecute();
	public void reexecute();
}
