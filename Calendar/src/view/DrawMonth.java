package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.CalculateDate;
import view.Drawable;

public class DrawMonth implements Drawable {
    private SimpleDateFormat month = new SimpleDateFormat("MMMM");
    private Date date = new Date();
    private SimpleDateFormat present= new SimpleDateFormat("MM")	;
    public static String Month;
    private  Calendar today = Calendar.getInstance();
    public DrawMonth()
    {
    setCalendar();
    }
    public void setDate(Date date) {
        this.date = date;
       
    }
     public void setCalendar()
	{   
            today.setTime(date);
            
            today.add(Calendar.MONTH, CalculateDate.dayaccount*1);
            
            
        }
    public void drawString(Graphics g) {
        Font Amonth=new Font("Century Gothic",Font.PLAIN,45);
    	 g.setColor(Color.gray); 
         g.setFont(Amonth);
    	    g.drawString(month.format(today.getTime()), 150, 45);
            Month=present.format(today.getTime());
         
    }

    
	
}