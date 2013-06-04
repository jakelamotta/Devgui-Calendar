
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Draw two buttons for prev and next month.
 * Show "Today" button.
 * Show "High priority" button.
 * @author Qi
 */

public class DrawButtons implements Drawable {
	
       private static String btnText = "Show important!";
    private Image image;
    
       public void drawString(Graphics g) {
    	   Graphics2D g2 = (Graphics2D) g.create();   
           
           // Two buttons for prev and next month (arrows)
                    
           Font Cbutton=new Font("Century Gothic",Font.PLAIN,20);
        g.setColor(Color.lightGray); 
        g.setFont(Cbutton);
           g.drawString("<",15, 220);
           g.drawString(">",455,220);
                        
           
           //"Today" button
           
            g2.setColor(Color.black);
        g2.drawRoundRect(460, 50, 61, 31,10,10);
        g2.setColor(Color.darkGray);
        g2.fillRoundRect(460, 50, 60, 30,10,10);
        
           Font Dbutton=new Font("Century Gothic",Font.PLAIN,12);
        g.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5)); 
        g.setFont(Dbutton);
           g.drawString("Today",475, 70);
           
           
        //"High priority" button
        g2.setColor(Color.black);
        g2.drawRoundRect(400, 15, 121, 31,10,10);
        g2.setColor(Color.darkGray);
        g2.fillRoundRect(400, 15, 120, 30,10,10);
        
        g.setColor(Color.lightGray);
        g.setFont(Dbutton);
        g.drawString(btnText,411, 35);
           
        // Help button
       //  final JButton help = new JButton("?");
         //   help.setIcon(new ImageIcon(this.getClass().getResource("bullet_info.jpg")));
    }
       
       
     public static void setBtnTextShow(){
         btnText = "Show important!";
     }
     
     public static void setBtnTextHide(){
         btnText = "Hide important!";
     }

    
	
}