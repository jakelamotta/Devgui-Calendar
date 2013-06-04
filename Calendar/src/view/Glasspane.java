package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
 * The glasspane used to show a guideline of some main functions.
 * @author bigbigguoguo
 * @author Qi
 */
public class Glasspane extends JComponent implements Runnable {
 Thread thread = new Thread(this);
      static int  i=0;    
       private ArrayList<BufferedImage> imgarrow1 =new ArrayList();
       private ArrayList<BufferedImage> imgarrow2 =new ArrayList();
       private ArrayList<BufferedImage> imgarrow3 =new ArrayList();
    public Glasspane() throws IOException
{ this.imgarrow1.add(ImageIO.read(this.getClass().getResource("arrow1.png")));//add event
  this.imgarrow2.add(ImageIO.read(this.getClass().getResource("arrow2.png")));//weather
  this.imgarrow3.add(ImageIO.read(this.getClass().getResource("arrow3.png")));//show important
 
    thread.start(); 

}
    @Override
    public void paintComponent(Graphics g) {
    
        Graphics2D g2 = (Graphics2D) g.create();
      
      //background of help texts  
      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.80f));
      g2.setColor(Color.getHSBColor((float)0.8,(float) 0.8,(float) 0.5));
      g2.fillRoundRect(100,290,350,40,20,20);//add event
      g2.fillRoundRect(730,200,320,40,20,20);//weather
      g2.fillRoundRect(560,35,300,30,20,20); //show important
      
      //"help" texts
      g2.setColor(Color.lightGray);
      Font Help = new Font("Lucida Handwriting",Font.PLAIN,18);
      g2.setFont(Help);            
      g2.drawString("Click here to add a new event",120,315);
      g2.drawString("Click to stop the animation",750,230);
      Font HHelp = new Font("Lucida Handwriting",Font.PLAIN,14);
      g2.setFont(HHelp);
      g2.drawString("To see all events of high priority",580,55);
      
      //arrows
      if(i==0)
      {g2.drawImage(this.imgarrow1.get(0),243,323,30,30,null);
       g2.drawImage(this.imgarrow2.get(0),820,170,30,30,null);
       g2.drawImage(this.imgarrow3.get(0),530,30,30,30,null);
      }
      else
      {g2.drawImage(this.imgarrow1.get(0),243,343,30,30,null);
       g2.drawImage(this.imgarrow2.get(0),820,150,30,30,null);
       g2.drawImage(this.imgarrow3.get(0),510,30,30,30,null);
      }
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
