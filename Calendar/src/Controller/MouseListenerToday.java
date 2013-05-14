
package Controller;

import View.Calendar;
import View.DrawMouseEventToday;
import View.Drawable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * MouseListener when mouse moves over "Today" button.
 * @author Qi
 */
public class MouseListenerToday extends MouseMotionAdapter{
    
    public void getxpoint(float x,float y){
if((336<x)&&(x<396)&&(15<y)&&(y<45))
  Calendar.MovedToday.clear();
 addDrawableMovedToday (new DrawMouseEventToday());
    
    }
  
     
 public void addDrawableMovedToday(Drawable d){
	    Calendar.MovedToday.add(d);
      }    
    public void mouseMoved(MouseEvent e) {

             float x=e.getX();
             float y=e.getY();
             getxpoint( x, y);
                
                 }
}
