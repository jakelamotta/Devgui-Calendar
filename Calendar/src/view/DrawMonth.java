package view;

import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Draw the text of months.
 * @author Guo
 * @author Qi
 */

public class DrawMonth implements Drawable {
    private SimpleDateFormat month = new SimpleDateFormat("MMMM");
    private Date date = new Date();
	
    public void setDate(Date date) {
        this.date = date;
    }

    public void drawString(Graphics g) {
    	    g.drawString(month.format(date), 150, 45);
           
    }

    
	
}