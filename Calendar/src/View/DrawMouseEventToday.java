
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Draw for mouse moving over "Today" buttons.
 * @author Qi
 */
public class DrawMouseEventToday implements Drawable {
    
    
     public void drawString(Graphics g){
     Graphics2D g2 = (Graphics2D) g.create();  
     
    g2.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        g2.fillRoundRect(336, 15, 60, 30,10,10);
        
        Font Dbutton=new Font("Century Gothic",Font.PLAIN,12);
        g.setColor(Color.lightGray); 
        g.setFont(Dbutton);
        g.drawString("Today",350, 35);
}
}