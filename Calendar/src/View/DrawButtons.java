
package View;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Draw two buttons for prev and next month.
 * Show "Today" button.
 * Show "High priority" button.
 * @author Qi
 */

public class DrawButtons implements Drawable {
	
       public void drawString(Graphics g) {
    	   Graphics2D g2 = (Graphics2D) g.create();   
           
           // Two buttons for prev and next month (arrows)
                    
           Font Cbutton=new Font("Century Gothic",Font.PLAIN,20);
        g.setColor(Color.lightGray); 
        g.setFont(Cbutton);
           g.drawString("<",15, 220);
           g.drawString(">",455,220);
                        
           
           //"Today" button
           
            g2.setColor(Color.black);
        g2.drawRoundRect(336, 15, 61, 31,10,10);
        g2.setColor(Color.darkGray);
        g2.fillRoundRect(336, 15, 60, 30,10,10);
        
           Font Dbutton=new Font("Century Gothic",Font.PLAIN,12);
        g.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5)); 
        g.setFont(Dbutton);
           g.drawString("Today",350, 35);
           
           
           //"High priority" button
           
             g2.setColor(Color.black);
        g2.drawRoundRect(401, 15, 81, 31,10,10);
        g2.setColor(Color.darkGray);
        g2.fillRoundRect(401, 15, 80, 30,10,10);
        
        g.setColor(Color.lightGray);
        g.setFont(Dbutton);
           g.drawString("Important!",411, 35);
           
    }

    
	
}