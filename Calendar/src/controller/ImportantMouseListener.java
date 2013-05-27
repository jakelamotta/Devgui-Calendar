package controller;

import application.CalendarApp;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Kristian
 */
public class ImportantMouseListener extends MouseAdapter{

    private AnimationEngine engine;
    
    public ImportantMouseListener(AnimationEngine eng) {
        this.engine = eng;
    }

    private boolean getXY(int x, int y){
        
        if(400<x && x<482 && 14<y && y<46 ){
            return true;
        }
        else{
            return false;
        }
        
    }
    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1 && getXY(e.getX(),e.getY())){
            CalendarApp.getFrame().getEventPanel().getModel().priorityFilterTable(100);
            engine.setPauseAnimation(false);
        }
    }
}
