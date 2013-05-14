
package View;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseAdapter;
import Controller.DayMouseListener;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Draw for mouse moving over a certain date.
 * @author Guo
 * @author Qi
 */

public class DrawDayforselected2 implements Drawable {
   private Date date = new Date();
        
	private void setDate(Date date) {
            this.date = date;
        }
	
        
     
    private int d;
    private int week;    
    private SimpleDateFormat day = new SimpleDateFormat("d");
  
   
    
    public DrawDayforselected2(int d,int week){
            this.d=d;
            this.week=week;
            
    }

    public void drawString(Graphics g) {
    
      Graphics2D g2 = (Graphics2D) g.create();  
      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.10f));
      g2.setColor(Color.WHITE);
      g2.fillRoundRect((d-1) * 45 + 86, (week-1)* 45 + 86, 40, 40,10,10);
      
       //for (int i = 1; i < week; i++) {
        //for (int j = 1; j < d; j++) {
        	//upgradeCalendar();
                //Listener L=new Listener(d,week);
        }     
       
       }
       
        
       
    