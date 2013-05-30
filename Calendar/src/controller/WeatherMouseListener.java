package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Mouselistener for the weahter animation, you can toggle the animation on
 * and off by clicking on it
 * @author Kristian
 */
public class WeatherMouseListener extends MouseAdapter{

    private AnimationEngine animationengine;
    
    public WeatherMouseListener(AnimationEngine engine){
        super();
        this.animationengine = engine;
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
    public void mouseClicked(MouseEvent e){
        
        if(e.getButton() == MouseEvent.BUTTON1 && getXY(e.getX(),e.getY())){
            this.animationengine.setShowAnimation();
        }
    }
}
