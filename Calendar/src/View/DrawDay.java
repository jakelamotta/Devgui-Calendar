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
	int d;
	int week;
	  SimpleDateFormat day = new SimpleDateFormat("d");
	  Date date = new Date();
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