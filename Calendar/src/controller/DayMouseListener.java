/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import model.CalculateDate;

import view.Calendar;
import view.DrawDayforselected;
import view.Drawable;

/**
 *
 * @author bigbigguoguo
 */
public class DayMouseListener extends MouseAdapter {
    
    private int d;
    private int week;
    public static int i=0;
    
    public void getxpoint(float x,float y){

        if((108.5-22.5<x)&&(x<108.5+22.5)){
            d=1;
            getypoint(y);
        }
        if((153.5-22.5<x)&&(x<153.5+22.5)){
            d=2;
            getypoint(y);
        }
        if((198.5-22.5<x)&&(x<198.5+22.5)){
            d=3;
            getypoint(y);}
        if((243.5-22.5<x)&&(x<243.5+22.5)){
            d=4;
            getypoint(y);}
        if((288.5-22.5<x)&&(x<288.5+22.5)){
            d=5;
            getypoint(y);
        }
        if((333.5-22.5<x)&&(x<333.5+22.5)){
            d=6; 
            getypoint(y);
        }
        if((378.5-22.5<x)&&(x<378.5+22.5)){
            d=7;
            getypoint(y);
        }
        if((0<x)&&(x<45)&&(86<y)&&(y<351)){
            CalculateDate.dayaccount--;
            CalculateDate.relativeMonthCount--;
        }
        if((440<x)&&(x<495)&&(86<y)&&(y<351)){
            CalculateDate.dayaccount++;
            CalculateDate.relativeMonthCount++;
            }
        if((460<x)&&(x<520)&&(50<y)&&(y<80))
        {CalculateDate.dayaccount=0;
         CalculateDate.relativeMonthCount=0;
         i=1;
        Calendar.Selected.clear();
        Calendar.Selected2.clear();
        }
        }
    
     public void getypoint(float y){
        if((98.5-22.5<y)&&(y<98.5+22.5)){
            week=1;
            i=0;
            Calendar.Selected.clear();
            Calendar.Selected2.clear();
            
            addDrawableForselected(new DrawDayforselected(d,week));
        }
        if((143.5-22.5<y)&&(y<143.5+22.5)){
            week=2;
                i=0;
            Calendar.Selected.clear();
            Calendar.Selected2.clear();
            addDrawableForselected(new DrawDayforselected(d,week));
        }
        if((188.5-22.5<y)&&(y<188.5+22.5)){
            week=3;
                i=0;
            Calendar.Selected.clear();
            Calendar.Selected2.clear();
            addDrawableForselected(new DrawDayforselected(d,week));
        }
        if((233.5-22.5<y)&&(y<233.5+22.5)){
            week=4;
            i=0;
            Calendar.Selected.clear();
            Calendar.Selected2.clear();
            addDrawableForselected(new DrawDayforselected(d,week));
        }
        if((278.5-22.5<y)&&(y<278.5+22.5)){
            week=5;
            i=0;
            Calendar.Selected.clear();
            Calendar.Selected2.clear();
            addDrawableForselected(new DrawDayforselected(d,week));
        }
        if((323.5-22.5<y)&&(y<323.5+22.5)){
            week=6;
            i=0;
            Calendar.Selected.clear();
            Calendar.Selected2.clear();
            addDrawableForselected(new DrawDayforselected(d,week));
        }

    }
    public void addDrawableForselected(Drawable d){
        Calendar.Selected.add(d);
    }    
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (e.getClickCount() == 1) {
                float x=e.getX();
                float y=e.getY();
                getxpoint( x, y);
                //float distance=(x-centerX)*(x-centerX)+(y-centerY)*(y-centerY);
                //System.out.println("work");



                //(x-centerX)*(x-centerX)+(y-centerY)*(y-centerY);
                //P.setLocation(e.getX(),e.getY());(x-centerX)*(x-centerX)+(y-centerY)*(y-centerY);
                //week * 29 + 81 + 20


                //Calendar.Calendars.add(0,new(DrawMonth(Color.getColor(gray))));
            }
        }
    }
}

