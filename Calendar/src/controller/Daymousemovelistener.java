/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import view.Calendar;
import view.DrawDayforselected2;
import view.Drawable;

/**
 *
 * @author bigbigguoguo
 */
public class Daymousemovelistener extends MouseMotionAdapter {
    
    private int d;
    private int week;
    public void getxpoint(float x,float y){
if((108.5-22.5<x)&&(x<108.5+22.5)){
                 d=1;
                 getypoint(y);}
if((153.5-22.5<x)&&(x<153.5+22.5)){
                 d=2;
                 getypoint(y);}
if((198.5-22.5<x)&&(x<198.5+22.5)){
                 d=3;
                 getypoint(y);}
if((243.5-22.5<x)&&(x<243.5+22.5)){
                 d=4;
                 getypoint(y);}
if((288.5-22.5<x)&&(x<288.5+22.5)){
                 d=5;
                 getypoint(y);}
if((333.5-22.5<x)&&(x<333.5+22.5)){
                 d=6; 
                 getypoint(y);}
if((378.5-22.5<x)&&(x<378.5+22.5)){
                 d=7;
                 getypoint(y);}
}
     public void getypoint(float y){
if((98.5-22.5<y)&&(y<98.5+22.5)){
                 week=1;Calendar.Selected2.clear();
 addDrawableForselected2(new DrawDayforselected2(d,week));
}
if((143.5-22.5<y)&&(y<143.5+22.5)){
                 week=2;Calendar.Selected2.clear(); 
 addDrawableForselected2(new DrawDayforselected2(d,week));
}
if((188.5-22.5<y)&&(y<188.5+22.5)){
                 week=3;
                 Calendar.Selected2.clear();
 addDrawableForselected2(new DrawDayforselected2(d,week));
}
if((233.5-22.5<y)&&(y<233.5+22.5)){
                 week=4;
                 Calendar.Selected2.clear();
 addDrawableForselected2(new DrawDayforselected2(d,week));
}
if((278.5-22.5<y)&&(y<278.5+22.5)){
                 week=5;
                 Calendar.Selected2.clear();
 addDrawableForselected2(new DrawDayforselected2(d,week));
}
if((323.5-22.5<y)&&(y<323.5+22.5)){
                 week=6;
                 Calendar.Selected2.clear();
 addDrawableForselected2(new DrawDayforselected2(d,week));}


    }
      public void addDrawableForselected2(Drawable d){
	    Calendar.Selected2.add(d);
      }    
    public void mouseMoved(MouseEvent e) {

             float x=e.getX();
             float y=e.getY();
             getxpoint( x, y);
                
                 }
            }
