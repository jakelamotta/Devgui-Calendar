package controller;

import application.CalendarApp;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.CalendarAnimation;
import view.DrawButtons;
import view.DrawMouseEventImpt;

/**
 * @author Kristian
 */
public class ImportantMouseListener extends MouseAdapter{

    private AnimationEngine engine;
    private boolean enabled;
    
    public ImportantMouseListener(AnimationEngine eng) {
        this.engine = eng;
        enabled = false;
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
            if(!enabled){
                CalendarApp.getFrame().getEventPanel().getModel().priorityFilterTable(100);
                CalendarAnimation.fadein = true;
                DrawButtons.setBtnTextHide();
                DrawMouseEventImpt.setBtnTextHide();
                enabled = true;
            }
            else{
                CalendarApp.getFrame().getEventPanel().getModel().priorityFilterTable(100);
                CalendarAnimation.fadein = false;
                DrawButtons.setBtnTextShow();
                DrawMouseEventImpt.setBtnTextShow();
                enabled = false;                
            }
        }
    }
}
