package application;
import view.Frame;
import controller.CommandManager;

/**
 * The application is run from this class
 * @author Deha
 *
 */
public class CalendarApp {
	
	private static Frame frame;
    private static CommandManager invoker;
    
    /**
     * Constructor
     */
    public CalendarApp(){
		frame = new Frame();
    	invoker = new CommandManager();
    }
    
    /**
     * getter method for Frame
     * @return frame the frame of the application
     */
    public static Frame getFrame() {
		return frame;
	}

    /**
     * getter method for the invoker
     * @return invoker the invoker in Command Pattern
     */
	public static CommandManager getInvoker(){
   		return invoker;
   	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		CalendarApp theApplication = new CalendarApp();
	}

}
