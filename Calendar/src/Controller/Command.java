package Controller;

public interface Command {
	public void execute();
	public void unexecute();
	public void reexecute();
}
