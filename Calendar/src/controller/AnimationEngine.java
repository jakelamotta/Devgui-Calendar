package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import view.DayCard;
import view.Drawable;

import enums.Weather;
import java.util.ArrayList;
import java.util.List;
import view.Animation;
import view.CalendarAnimation;

/**
 * Animation engine class, each instance of the engine defines a animation. 
 * @author Kristian
 */
public class AnimationEngine implements Runnable{
    
    private List<Animation> animations = new ArrayList();
    private JPanel panel;
    private int sleepTime = 100;    

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
    
    public Animation getAnimationAtIndex(int i){
        return this.animations.get(i);
    }

    public void addAnimation(Animation animation) {
        this.animations.add(animation);
    }
}