
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import view.Calendar;
import view.DrawMouseEventToday;
import view.Drawable;

/**
 * MouseListener when mouse moves over "Today" button.
 * @author Qi
 */
public class MouseListenerToday extends MouseMotionAdapter{
    
    public void getxpoint(float x,float y){
if((460<x)&&(x<520)&&(50<y)&&(y<80))

 addDrawableMovedToday (new DrawMouseEventToday());
else   
    Calendar.MovedToday.clear();
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
