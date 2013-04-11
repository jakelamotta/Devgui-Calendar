/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrawYear implements Drawable {
	
	SimpleDateFormat year = new SimpleDateFormat("yyyy"); 
	  Date date = new Date();

	  public void setDate(Date date) {
	    this.date = date;
	  }

    public void drawString(Graphics g) {
    	 g.setColor(Color.white);
    	    g.drawString(year.format(date), 235, 36);
    }
	
}
