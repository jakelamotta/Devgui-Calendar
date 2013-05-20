package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Draw for mouse moving over the previous & next month buttons (arrows).
 * @author Qi
 */

public class DrawMouseEventPrevNext implements Drawable{
    
    private int a;
    public DrawMouseEventPrevNext(int a){
            this.a=a;
                }
    
    public void drawString(Graphics g){
         Graphics2D g2 = (Graphics2D) g.create(); 
      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.10f));
            g2.setColor(Color.gray);
        g2.fillRect((a-1)*440, 86, 45, 265);
}
}
