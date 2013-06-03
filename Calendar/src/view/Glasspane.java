/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author bigbigguoguo
 */
public class Glasspane extends JComponent implements Runnable {
 Thread thread = new Thread(this);
      static int  i=0;    
       private ArrayList<BufferedImage> imgarrow =new ArrayList();
    public Glasspane() throws IOException
{ this.imgarrow.add(ImageIO.read(this.getClass().getResource("arrow.png")));
  this.imgarrow.add(ImageIO.read(this.getClass().getResource("arrow.png")));
 
    thread.start(); 

}
    @Override
    public void paintComponent(Graphics g) {
    
        Graphics2D g2 = (Graphics2D) g.create();
      //g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.30f));
      //g2.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
      //g2.fillRect(0,0,1200 ,840);
      if(i==0)
      {g2.drawImage(this.imgarrow.get(0),243,323,30,30,null);
       g2.drawImage(this.imgarrow.get(0),780,0,30,30,null);}
      else
      {g2.drawImage(this.imgarrow.get(1),243,343,30,30,null);
       g2.drawImage(this.imgarrow.get(1),780,20,30,30,null);}
    }
    public void run() {
        while(true){
            if(i==0){
            i=1;
            }
            else{
            i=0;
            }
            this.repaint();
            
            
            
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
