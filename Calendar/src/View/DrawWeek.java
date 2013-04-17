/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author bigbigguoguo
 */
//test the git
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrawWeek implements Drawable {
    
    public void drawString(Graphics g) {
    	 Font Bday=new Font("Century Gothic",Font.PLAIN,11);    
            g.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
            g.setFont(Bday);
    	    g.drawString("Sun", 50,65 );
            g.drawString("Mon", 95,65); 
            g.drawString("Tue", 140,65); 
            g.drawString("Wed", 185,65); 
            g.drawString("Thu", 230,65);
            g.drawString("Fri", 275,65); 
            g.drawString("Sat", 320,65); 
    }
	
}