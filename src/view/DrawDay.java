/*
 * Draw the texts and rectangles of every date.
 */
package view;

/**
 *
 * @author Guo
 */

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.CalculateDate;

public class DrawDay implements Drawable {
    private String present;
    private int d;
    private int week;    
    private SimpleDateFormat day = new SimpleDateFormat("d");
    private Date date = new Date();
    public static String[][] dateposition= new String[8][9];
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
    
    	Graphics2D g2 = (Graphics2D) g.create();
        
    	
 
        //if(day.format(calculatedate.gettime()).equals(day.format(date))){
            //g2.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
            //g2.fillRoundRect((d-1) * 45 + 41, (week-1) * 45 + 76, 40, 40,10,10);
            //g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.75f));
         //
        //}
        //else{
        
        g2.setColor(Color.darkGray);
        g2.fillRoundRect((d-1) * 45 + 86, (week-1) * 45 + 86, 40, 40,10,10);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN,0.05f));
        
        //calculatedate.upgradeCalendar();
    //}
          Font Bday=new Font("Century Gothic",Font.PLAIN,12);
        g.setColor(Color.white); 
        g.setFont(Bday);
        present=day.format(calculatedate.gettime());
        dateposition[d][week] =present;
        g.drawString(present, (d-1) * 45 + 91 + 4, (week-1) * 45 + 91 + 20);
        
        calculatedate.upgradeCalendar();
    }
}
