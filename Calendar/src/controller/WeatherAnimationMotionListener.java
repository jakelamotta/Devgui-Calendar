/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

/**
 * Class that adds motionlistener for the weather animation, used for adding
 * tool tip to the animation
 * @author Kristian
 */
public class WeatherAnimationMotionListener extends MouseMotionAdapter {
    
    private JPanel panel;
    
    public WeatherAnimationMotionListener(JPanel p){
        panel=p;
    }
    
    /**
     * Function that returns true if the click is in the area of the button,
     * false if not
     * @param x x-coordinate of the click
     * @param y y-coordinate of the click
     * @return 
     */
    public boolean getXY(int x, int y){
        if(249<x && x<401 && 19<y && y<171){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e){
        panel.setToolTipText(null);
        if(getXY(e.getX(),e.getY())){
           panel.setToolTipText("Click on the weather animation to toggle it on and off");
        }
        
        
    }
}
