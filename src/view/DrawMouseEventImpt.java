/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Draw for mouse moving over "Important" buttons.
 * @author Qi
 */
public class DrawMouseEventImpt implements Drawable {
    
     public void drawString(Graphics g){
     Graphics2D g2 = (Graphics2D) g.create();  
     
    g2.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        g2.fillRoundRect(401, 15, 80, 30,10,10);
      
         Font Dbutton=new Font("Century Gothic",Font.PLAIN,12);
        g.setColor(Color.lightGray);
        g.setFont(Dbutton);
           g.drawString("Important!",411, 35);
}
    
}
