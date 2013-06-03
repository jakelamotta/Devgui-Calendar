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
 * @author Deha
 */
public class DrawMouseEventImpt implements Drawable {
    
    private static String btnText = "Show important!";
    
    public void drawString(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();  
        g2.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        g2.fillRoundRect(400, 15, 120, 30,10,10);
        Font Dbutton=new Font("Century Gothic",Font.PLAIN,12);
        g.setColor(Color.lightGray);
        g.setFont(Dbutton);
        g.drawString(btnText,411, 35);
    }
    
     public static void setBtnTextShow(){
         btnText = "Show important!";
     }
     
     public static void setBtnTextHide(){
         btnText = "Hide important!";
     }
     
}
