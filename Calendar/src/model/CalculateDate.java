package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalculateDate {
	private Date date = new Date();
        private  Calendar today = Calendar.getInstance();
	private static Calendar cal = Calendar.getInstance();
        //private static int dayaccount =0;
	
        private void setDate(Date date) {
            this.date = date;
        }
	
        
        public void setCalendar()
	{   
            today.setTime(date);
            cal.setTime(date);
            cal.set(Calendar.DATE, 1);
            cal.add(Calendar.DATE, -cal.get(Calendar.DAY_OF_WEEK) + 1);
            //cal.add(Calendar.DATE, +dayaccount);dayaccount++; 
            //return cal.getTime();
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
