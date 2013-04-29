package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrawYear implements Drawable {
	
    private SimpleDateFormat year = new SimpleDateFormat("yyyy"); 
    private Date date = new Date();

    public void setDate(Date date) {
        this.date = date;
    }

    public void drawString(Graphics g) {
        Font Ayear=new Font("Century Gothic",Font.PLAIN,50);
    	 g.setColor(Color.gray); 
         //String YEAR= year.format(date);
         g.setFont(Ayear);
    	    g.drawString(year.format(date), 5, 45);
           
    }

   
}
