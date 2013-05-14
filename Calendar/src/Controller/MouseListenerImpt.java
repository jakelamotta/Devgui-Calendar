
package Controller;

import View.Calendar;
import View.DrawMouseEventImpt;
import View.Drawable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * MouseListener when mouse moves over "Important" button.
 * @author Qi
 */

public class MouseListenerImpt extends MouseMotionAdapter{
    
    public void getxpoint(float x,float y){
if((401<x)&&(x<481)&&(15<y)&&(y<45))
addDrawableMovedImpt (new DrawMouseEventImpt());
 else 
    Calendar.MovedImportant.clear();

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
