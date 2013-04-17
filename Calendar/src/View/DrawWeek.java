/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author bigbigguoguo
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrawWeek implements Drawable {
    
    public void drawString(Graphics g) {
    	    g.setColor(Color.gray);
    	    g.drawString("Sun", 50,80 );
            g.drawString("Mon", 80,80); 
            g.drawString("Tue", 110,80); 
            g.drawString("Wed", 140,80); 
            g.drawString("Thu", 170,80);
            g.drawString("Fri", 200,80); 
            g.drawString("Sat", 230,80); 
    }
	
}