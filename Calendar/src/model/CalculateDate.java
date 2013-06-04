package model;

import java.util.Calendar;
import java.util.Date;
/**
 * Calculate the date for each day
 * @author Guo
 * @author Kristian
 */

public class CalculateDate {
	private Date date = new Date();
       
	private static Calendar cal = Calendar.getInstance();
        private static Calendar cal2 = Calendar.getInstance();
        public static int dayaccount =0;
	public static int relativeMonthCount = 0;
        
	
        public void setCalendar2()
	{   
           
            cal2.setTime(date);
            cal2.set(Calendar.DATE, 1);
            cal2.add(Calendar.MONTH, relativeMonthCount*1);
            cal2.add(Calendar.DATE, -cal2.get(Calendar.DAY_OF_WEEK) + 1);
           
        }
        
        public void setCalendar()
	{   
           
            cal.setTime(date);
            cal.set(Calendar.DATE, 1);
            cal.add(Calendar.MONTH, dayaccount*1);
            cal.add(Calendar.DATE, -cal.get(Calendar.DAY_OF_WEEK) + 1);
           
        }
        
        public Date gettime2()
        {
            return cal2.getTime();
        }
        public void upgradeCalendar2()
        {
            cal2.add(Calendar.DATE, +1);
        }
        
        public Date gettime()
        {
            return cal.getTime();
        }
        public void upgradeCalendar()
        {
            cal.add(Calendar.DATE, +1);
        }        
        
}
