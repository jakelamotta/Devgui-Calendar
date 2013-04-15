/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrawDay implements Drawable {
    private int d;
    private int week;    
    private SimpleDateFormat day = new SimpleDateFormat("d");
    private Date date = new Date();
    CalculateDate calculatedate=new CalculateDate();
    public DrawDay(int d,int week){
            this.d=d;
            this.week=week;
     calculatedate.setCalendar();
    }
	 
    public void setDate(Date date) {
	    this.date = date;
    }
    
    //@Override
    public void drawString(Graphics g) {
    	
        if(day.format(calculatedate.gettime()).equals(day.format(date))){
         g.setColor(Color.red);
          g.drawString(day.format(calculatedate.gettime()), d * 30 + 46 + 4,
         week * 29 + 81 + 20);
         calculatedate.upgradeCalendar();
        }
        else{
        g.setColor(Color.white);
        g.drawString(day.format(calculatedate.gettime()), d * 30 + 46 + 4,
            week * 29 + 81 + 20);
        
        calculatedate.upgradeCalendar();
    }
}
}
