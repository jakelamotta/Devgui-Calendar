package model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * The Event class where the attributes of an Event can be saved to an XML file.
 * @author Deha
 * 
 */
@Root
public class Event {
	@Element
	private String eventName;
	@Element
	private String eventDueDate;
	@Element
	private String eventCategory;
	@Element
	private int eventPriority;
	@Element
	private String button1;
	@Element
	private String button2;
	
	//Zero-argument constructor for XML-management
	public Event() {
		super();
	}
	
	/**
	 * Initiate the Event
	 * @param eventName the name of Event
	 * @param eventDueDate the due date of Event
	 * @param eventCategory the category of Event
	 * @param eventPriority the priority of Event
	 * @param button1 edit button
	 * @param button2 delete button
	 */
	public Event(String eventName, String eventDueDate, 
						String eventCategory, int eventPriority, String button1, String button2) {
		super();
		this.eventName = eventName;
		this.eventDueDate = eventDueDate;
		this.eventCategory = eventCategory;
		this.eventPriority = eventPriority;
		this.button1 = button1;
		this.button2 = button2;
	}

	/**
	 * Getter method for Event name
	 * @return eventName the name of the event
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Setter method for Event name
	 * @param eventName the name of the event
	 */
	public void setEventName(String eventName) {
		if (eventName.equals(""))  {
			eventName = " ";
		}
		this.eventName = eventName;
	}

	/**
	 * Getter method for Event due date
	 * @return eventDueDate the due date of Event
	 */
	public String getEventDueDate() {
		return eventDueDate;
	}

	/**
	 * Setter method for Event due date
	 * @param eventDueDate the due date of Event
	 */
	public void setEventDueDate(String eventDueDate) {
		this.eventDueDate = eventDueDate;
	}

	/**
	 * Getter method for Event Category
	 * @return eventCategory the category of Event
	 */
	public String getEventCategory() {
		return eventCategory;
	}

	/**
	 * Setter method for Event category
	 * @param eventCategory the category of Event
	 */
	public void setEventCategory(String eventCategory) {
		if (eventCategory.equals(""))  {
			eventCategory = " ";
		}
		this.eventCategory = eventCategory;
	}

	/**
	 * Getter method for Event priority
	 * @return taskPriority the priority of Event
	 */
	public int getEventPriority() {
		return eventPriority;
	}

	/**
	 * Setter method for Event priority
	 * @param eventPriority the priority of Event
	 */
	public void setEventPriority(int eventPriority) {
		this.eventPriority = eventPriority;
	}
	
	/**
	 * Getter method for edit button
	 * @param button1 the edit button
	 */
	public String getbutton1() {
		return button1;
	}

	/**
	 * Setter method for edit button
	 * @param button1 the edit button
	 */	
	public void setbutton1(String button1) {
		this.button1 = button1;
	}
	
	/**
	 * Getter method for delete button
	 * @param button1 the delete button
	 */
	public String getbutton2() {
		return button2;
	}

	/**
	 * Setter method for delete button
	 * @param button1 the delete button
	 */
	public void setbutton2(String button2) {
		this.button2 = button2;
	}	
}
