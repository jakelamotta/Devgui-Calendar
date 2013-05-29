package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Kristian
 */
public class WeatherMouseListener extends MouseAdapter{

    private AnimationEngine animationengine;
    
    public WeatherMouseListener(AnimationEngine engine){
        super();
        this.animationengine = engine;
    }
    
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
