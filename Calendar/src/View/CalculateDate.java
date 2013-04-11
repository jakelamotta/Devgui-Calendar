/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Calendar;
import java.util.Date;


public class CalculateDate {
	 static Date date = new Date();
	 
	public void setDate(Date date) {
		    this.date = date;
		  }
	public static Date setCalendar()
	{
		Calendar today = Calendar.getInstance();
    today.setTime(date);
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DATE, 1);
    cal.add(Calendar.DATE, -cal.get(Calendar.DAY_OF_WEEK) + 1);
    return date;

	}
}
