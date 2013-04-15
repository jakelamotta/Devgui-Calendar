package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * @author Kristian
 */
public class DayCard extends JPanel implements Runnable{
    
    private int x = 280;
    private int y = 10;
    
    public DayCard(){
        setPreferredSize(new Dimension(300,280));
        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        Thread thread = new Thread(this);
        thread.start();
        
    }
    
    @Override
    public void paintComponent(Graphics g){        
        Graphics temp = g.create();
        temp.fillRect(0, 0, 300, 280);
        temp.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        temp.fillOval(x, y, 4, 7);
        
        GregorianCalendar cal = new GregorianCalendar();
        Drawable d = new Testfordaycard();
        temp.setColor(Color.white);
        d.drawString(temp);
        temp.dispose();
    }
    
    @Override
    public void run() {
        while(true){
            
            this.repaint();
            
            if(y == 50){
                y = 0;
            }
            
            y += 10;
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
