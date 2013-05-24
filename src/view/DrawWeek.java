package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Draw the texts of week: "Sun", "Mon", "Tue", etc.
 * @author Guo
 * @author Qi
 */

public class DrawWeek implements Drawable {
    
    public void drawString(Graphics g) {
    	 Font Bday=new Font("Century Gothic",Font.PLAIN,11);    
            g.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
            g.setFont(Bday);
    	    g.drawString("Sun", 95,75 );
            g.drawString("Mon", 140,75); 
            g.drawString("Tue", 185,75); 
            g.drawString("Wed", 230,75); 
            g.drawString("Thu", 275,75);
            g.drawString("Fri", 320,75); 
            g.drawString("Sat", 365,75); 
    }

    
}