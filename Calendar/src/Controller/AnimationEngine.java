package Controller;

import View.DayCard;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Animation engine class, each instance of the engine defines a animation. 
 * @author Kristian
 */
public class AnimationEngine implements Runnable{
    
    private JPanel panel;
    private final int sleepTime = 100;

    public AnimationEngine(JPanel comp){
        this.panel = comp;
    }
    

    @Override
    public void run() {
        while(true){
            
            this.panel.repaint();
            
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}