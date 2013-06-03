package controller;

import application.CalendarApp;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.CalendarAnimation;
import view.DrawButtons;
import view.DrawMouseEventImpt;

/**
 * Mouse adapater for the "show important"-button, defines actions for clicking
 * on that.
 * @author Kristian
 */
public class ImportantMouseListener extends MouseAdapter{

    private boolean enabled;
    
    public ImportantMouseListener() {
        super();
        enabled = false;
    }

    /**
     * Function that returns true if the click is in the area of the button,
     * false if not
     * @param x x-coordinate of the click
     * @param y y-coordinate of the click
     * @return 
     */
    private boolean getXY(int x, int y){
        
        if(399<x && x<521 && 14<y && y<46 ){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        
        //If the correct mouse button and the correct place has been clicked
        //the following code executes
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
