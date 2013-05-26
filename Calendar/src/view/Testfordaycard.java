package view;

import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Testfordaycard implements Drawable {
    private SimpleDateFormat day = new SimpleDateFormat("d");
    private Date date = new Date();
	
    public void setDate(Date date) {
        this.date = date;
    }

    public void drawString(Graphics g) {
    	 g.setColor(Color.red);
    	    g.drawString(day.format(date), 34, 36);
    }

  
	
}