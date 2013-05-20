package Model;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The Event class where the attributes of an Event can be saved to an XML file by using XMLHandler.java
 * (will be developed more...)
 * @author Deha
 * 
 */
public class Event {

	private String eventName;
	private String eventDueDate;
	private String eventCategory;
	private int eventPriority;
	
	//Zero-argument constructor for XML-management
	public Event() {
		super();
	}
        
        public Date getEventDate(){
            GregorianCalendar date = new GregorianCalendar(2013,5,18);
            return date.getTime();
        }
	
	/**
	 * 
	 * @param eventName the name of Event
	 * @param eventDueDate the due date of Event
	 * @param eventCategory the category of Event
	 * @param eventPriority the priority of Event
	 */
	public Event(String eventName,String eventDueDate, String eventCategory, int eventPriority) {
		this.eventName = eventName;
		this.eventDueDate = eventDueDate;
		this.eventCategory = eventCategory;
		this.eventPriority = eventPriority;
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
	 * @param EventCategory the category of Event
	 */
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	/**
	 * Getter method for Event priority
	 * @return eventPriority the priority of Event
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
}
