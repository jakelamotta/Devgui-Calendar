package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.CalculateDate;
import java.util.Calendar;
/**
 * Draw the texts of year.
 * @author Guo 
 * @author Qi
 */

public class DrawYear implements Drawable {
	
    private SimpleDateFormat year = new SimpleDateFormat("yyyy"); 
    private Date date = new Date();
    public static String Year; 
    private SimpleDateFormat month= new SimpleDateFormat("MM");
    private  Calendar today = Calendar.getInstance();
    public DrawYear()
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
        // Set font and color of the texts.
        Font Ayear=new Font("Century Gothic",Font.PLAIN,50);
    	 g.setColor(Color.gray); 
         g.setFont(Ayear);
    	 g.drawString(year.format(today.getTime()), 5, 45);
         Year=year.format(today.getTime());
      
    }

   
}
