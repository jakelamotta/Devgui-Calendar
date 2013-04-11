/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DrawDay implements Drawable {
    private int d;
    private int week;    
    private SimpleDateFormat day = new SimpleDateFormat("d");
    private Date date = new Date();
    
    public DrawDay(int d,int week)
    {
            this.d=d;
            this.week=week;
    }
	  public void setDate(Date date) {
	    this.date = date;
	  }

    public void drawString(Graphics g) {
    	Color col = Color.red;
        g.drawString(day.format(CalculateDate.setCalendar()), d * 30 + 46 + 4,
            week * 29 + 81 + 20);
      
    }
}