package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrawMonth implements Drawable {
	SimpleDateFormat month = new SimpleDateFormat("MMMM");
	  Date date = new Date();
	
	  public void setDate(Date date) {
	    this.date = date;
	  }

    public void drawString(Graphics g) {
    	 g.setColor(Color.red);
    	    g.drawString(month.format(date), 34, 36);
    }
	
}