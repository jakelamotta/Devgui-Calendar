
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import view.Calendar;
import view.DrawMouseEventImpt;
import view.Drawable;

/**
 * MouseListener when mouse moves over "Important" button.
 * @author Qi
 */

public class MouseListenerImpt extends MouseMotionAdapter{
    
    public void getxpoint(float x,float y){
        if((399<x)&&(x<521)&&(14<y)&&(y<46)){
            addDrawableMovedImpt (new DrawMouseEventImpt());
        }
        else{ 
            Calendar.MovedImportant.clear();
        }
}
    
     
 public void addDrawableMovedImpt(Drawable d){
	    Calendar.MovedImportant.add(d);
      }    

    public void mouseMoved(MouseEvent e) {

             float x=e.getX();
             float y=e.getY();
             getxpoint( x, y);
                
                 }
    
}
