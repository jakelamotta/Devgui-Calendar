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
import model.CalculateDate;
import model.EventTable;
import model.TableModel;
import view.DrawDay;
import view.DrawMonth;
import view.DrawYear;
import view.EventPanel;
/**
 *
 * @author bigbigguoguo
 */
public class DayMouseListener extends MouseAdapter {
    private SimpleDateFormat present= new SimpleDateFormat("yyyyMMd");
    
    private int d;
    private int week;
    private Date today=new Date();

    String taskdate;
    ArrayList<EventTable> datacopy= new ArrayList<EventTable>();
    public void getxpoint(float x,float y){
        

if((108.5-22.5<x)&&(x<108.5+22.5)){
                 d=1;
                 getypoint(d,y);}
if((153.5-22.5<x)&&(x<153.5+22.5)){
                 d=2;
                 getypoint(d,y);}
if((198.5-22.5<x)&&(x<198.5+22.5)){
                 d=3;
                 getypoint(d,y);}
if((243.5-22.5<x)&&(x<243.5+22.5)){
                 d=4;
                 getypoint(d,y);}
if((288.5-22.5<x)&&(x<288.5+22.5)){
                 d=5;
                 getypoint(d,y);}
if((333.5-22.5<x)&&(x<333.5+22.5)){
                 d=6; 
                 getypoint(d,y);}
if((378.5-22.5<x)&&(x<378.5+22.5)){
                 d=7;
                 getypoint(d,y);}
if((336<x)&&(x<396)&&(15<y)&&(y<45))
{
TodayTask();
EventPanel.table.updateUI();
}
if((0<x)&&(x<45)&&(86<y)&&(y<351)){
    CalculateDate.dayaccount--;
System.out.print(CalculateDate.dayaccount+"\n");
}
if((440<x)&&(x<495)&&(86<y)&&(y<351)){
  CalculateDate.dayaccount++;}
}
     public void getypoint(int d ,float y){
if((98.5-22.5<y)&&(y<98.5+22.5)){
    
                 week=1;
            EverydayTask(d,week);
         
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((143.5-22.5<y)&&(y<143.5+22.5)){
                 week=2;
            EverydayTask(d,week);
        
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((188.5-22.5<y)&&(y<188.5+22.5)){
                 week=3;
            EverydayTask(d,week);
         
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((233.5-22.5<y)&&(y<233.5+22.5)){
                 week=4;
            EverydayTask(d,week);
          
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((278.5-22.5<y)&&(y<278.5+22.5)){
                 week=5;
            EverydayTask(d,week);
           
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
if((323.5-22.5<y)&&(y<323.5+22.5)){
                 week=6;
            EverydayTask(d,week);
            
                 Calendar.Selected.clear();
                 Calendar.Selected2.clear();
 addDrawableForselected(new DrawDayforselected(d,week));
}
}
      
public void addDrawableForselected(Drawable d){
	    Calendar.Selected.add(d);
}    
     
public void EverydayTask(int d,int week){
  for(EventTable a: TableModel.data)
  {
  datacopy.add(a);
  } 
    
    for(int i = 0; i<TableModel.data.size(); i++){         

        if(TableModel.data.get(i).getEventDueDate()
                .equals(DrawYear.Year+DrawMonth.Month+DrawDay.dateposition[d][week])
                ==false){
            
        TableModel.removeRowforDisplay(i);    
         EventPanel.table.updateUI();   
       TableModel.data.clear();

}
}       




}
public void TodayTask(){
 for(EventTable a: TableModel.data)
  {
  datacopy.add(a);
  } 
    for(int i = 0; i<TableModel.data.size(); i++){         

        if(TableModel.data.get(i).getEventDueDate()
                .equals(present.format(today))
                ==false){
        TableModel.removeRowforDisplay(i);    
        EventPanel.table.updateUI();
        TableModel.data.clear();
 for(EventTable a: datacopy)
  {
  TableModel.data.add(a);
  } 
}
}   
}
    public void mouseClicked(MouseEvent e) {

    
      	     if (e.getButton() == MouseEvent.BUTTON1) {
             float x=e.getX();
             float y=e.getY();
      	     if (e.getClickCount() == 1) {
             
             getxpoint( x, y);

                 }
            }
}
}

