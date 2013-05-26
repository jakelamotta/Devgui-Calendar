/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;

import view.Calendar;
import view.DrawDayforselected;
import view.Drawable;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.EventTable;
import model.TableModel;
import view.EventPanel;
/**
 *
 * @author bigbigguoguo
 */
public class DayMouseListener extends MouseAdapter {
    private SimpleDateFormat present= new SimpleDateFormat("yyyyMMd")	;
    private int d;
    private int week;
    private Date today=new Date();
    int row;
    String taskdate;
    
    //float leftX=(float)((d-2) * 45 + 41);  
    //float upY=(float)((week-2) * 45);  
    //float rightX=(float)((d) * 45 + 41);  
    //float downY=(float)((week) * 45);  
    public void getxpoint(float x,float y){
        row= EventPanel.table.getRowCount();

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
if((336<x)&&(x<396)&&(15<y)&&(y<45))
{System.out.print(row); 
TodayTask();
EventPanel.table.updateUI();
}
}
     public void getypoint(float y){
if((98.5-22.5<y)&&(y<98.5+22.5)){
                 week=1;
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((143.5-22.5<y)&&(y<143.5+22.5)){
                 week=2;
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((188.5-22.5<y)&&(y<188.5+22.5)){
                 week=3;
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((233.5-22.5<y)&&(y<233.5+22.5)){
                 week=4;
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((278.5-22.5<y)&&(y<278.5+22.5)){
                 week=5;
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((323.5-22.5<y)&&(y<323.5+22.5)){
                 week=6;
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
}
      
public void addDrawableForselected(Drawable d){
	    Calendar.Selected.add(d);
}    
     
public void TodayTask(){

    for(int i = 0; i<TableModel.data.size(); i++){         

        if(TableModel.data.get(i).getEventDueDate()
                .equals(present.format(today))
                ==false){
        TableModel.removeRowforDisplay(i);    
}
}   
}
    public void mouseClicked(MouseEvent e) {

    
      	     if (e.getButton() == MouseEvent.BUTTON1) {
      	     if (e.getClickCount() == 1) {
             float x=e.getX();
             float y=e.getY();
             getxpoint( x, y);

                 }
            }
}
}

