/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import View.Calendar;
import java.awt.Color;
import java.awt.event.MouseAdapter;
/**
 *
 * @author bigbigguoguo
 */
public class Listener  {
   
    private int d;
    private int week;
    private static Color color;
    public Listener(int d,int week)
    {this.d=d;
    this.week=week;
    }
     /**
     *
     */
    //public class mouselistener implements MouseAdapter
     //{
     //
    public void mouseClicked(MouseEvent e) {
      	    if (e.getButton() == MouseEvent.BUTTON1) {
      	     if (e.getClickCount() == 2) {
               int X=e.getX();
               int Y=e.getY();
               int Xmin=(d-1)*30+46+4;
               int Xmax=(d+1)*30+46+4;
               int Ymin=(week-1)*29+81+20;
               int Ymax=(week+1)*29+81+20;
            //week * 29 + 81 + 20
      	    	 if((33<X)&&(35>X)&&(35<Y)&&(37>Y))
                 {
                 //Calendar.Calendars.remove(0);
	   //Calendar.Calendars.add(0,new(DrawMonth(color.getColor(gray))));
                 }
            }
}
}
}
