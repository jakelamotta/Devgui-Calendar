package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import view.DayCard;
import java.util.ArrayList;
import java.util.List;
import view.Animation;

/**
 * Animation engine class, each instance of the engine defines a animation. 
 * @author Kristian
 */
public class AnimationEngine implements Runnable{
    
    private List<Animation> animations = new ArrayList();
    private JPanel panel;
    private int sleepTime = 100;
    private boolean pauseAnimation = false;
    
    public AnimationEngine(JPanel comp){
        this.panel = comp;
    }
    
    /**
     * Function that starts a new thread for the input animationengine
     * @param engine 
     */
    public void startEngine(){
        Thread thread = new Thread(this);
        thread.start();            
        
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
    
    /**********************************************************
     ********* Getters and setters ****************************
     **********************************************************/
    
    public void setSleeptime(int newTime){
        this.sleepTime = newTime;
    }   
   
    public void setPauseAnimation(boolean run){
        this.pauseAnimation = run; 
    }
    
    public boolean getPauseAnimation(){
        return this.pauseAnimation;
    }
    
    public Animation getAnimationAtIndex(int i){
        return this.animations.get(i);
    }

    public void addAnimation(Animation animation) {
        this.animations.add(animation);
    }
}