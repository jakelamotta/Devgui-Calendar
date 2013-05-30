package model;

import java.util.Calendar;
import java.util.Date;


public class CalculateDate {
	private Date date = new Date();
        private  Calendar today = Calendar.getInstance();
	private static Calendar cal = Calendar.getInstance();
        private static Calendar cal2 = Calendar.getInstance();
        public static int dayaccount =0;
	public static int relativeMonthCount = 0;
        
        private void setDate(Date date) {
            this.date = date;
        }
	
        public void setCalendar2()
	{   
            today.setTime(date);
            cal2.setTime(date);
            cal2.set(Calendar.DATE, 1);
            cal2.add(Calendar.MONTH, relativeMonthCount*1);
            cal2.add(Calendar.DATE, -cal2.get(Calendar.DAY_OF_WEEK) + 1);
            //cal.add(Calendar.DATE, +dayaccount);dayaccount++; 
            //return cal.getTime();
        }
        
        public void setCalendar()
	{   
            today.setTime(date);
            cal.setTime(date);
            cal.set(Calendar.DATE, 1);
            cal.add(Calendar.MONTH, dayaccount*1);
            cal.add(Calendar.DATE, -cal.get(Calendar.DAY_OF_WEEK) + 1);
            //cal.add(Calendar.DATE, +dayaccount);dayaccount++; 
            //return cal.getTime();
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
