
package Controller;

import View.Calendar;
import View.DrawMouseEventPrevNext;
import View.Drawable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * MouseListener when mouse moves over the previous & next month buttons (arrows).
 * @author Qi
 */
public class MouseListenerPrevNext extends MouseMotionAdapter {
    
    private int a;
    
    public void getxpoint(float x,float y){
if((0<x)&&(x<45)&&(86<y)&&(y<351)){
    a=1;}
if((440<x)&&(x<495)&&(86<y)&&(y<351)){
    a=2;}
  Calendar.MovedPrevNext.clear();
 addDrawableMovedPrevNext(new DrawMouseEventPrevNext(a));
}
  
     
 public void addDrawableMovedPrevNext(Drawable d){
	    Calendar.MovedPrevNext.add(d);
      }    
    public void mouseMoved(MouseEvent e) {

             float x=e.getX();
             float y=e.getY();
             getxpoint( x, y);
                
                 }
    }
     
               
