package view;

import controller.AnimationEngine;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import controller.DayMouseListener;
import controller.Daymousemovelistener;
import controller.ImportantMouseListener;
import controller.MouseListenerImpt;
import controller.MouseListenerPrevNext;
import controller.MouseListenerToday;
/**
 * Draw for the left Panel
 * @author Guo
 * @author kristian
 */
 
  
public class Calendar extends JPanel implements Runnable {
  	
  private SimpleDateFormat month = new SimpleDateFormat("MMMM");
  private SimpleDateFormat year = new SimpleDateFormat("yyyy");
  private SimpleDateFormat day = new SimpleDateFormat("d");
  private Date date = new Date();
  private AnimationEngine engine;
  public List<Drawable> Calendars = new ArrayList<Drawable>();
  public List<Drawable> DrawForDay = new ArrayList<Drawable>();
  public List<Drawable> drawAnimation = new ArrayList<Drawable>();
  public static List<Drawable> Selected = new ArrayList<Drawable>();
  public static List<Drawable> Selected2 = new ArrayList<Drawable>();
  public static List<Drawable> MovedPrevNext = new ArrayList<Drawable>();
  public static List<Drawable> MovedToday = new ArrayList<Drawable>();
  public static List<Drawable> MovedImportant = new ArrayList<Drawable>();
  
  public  Calendar(){
      
   setPreferredSize(new Dimension(380,420));
   this.addMouseListener(new DayMouseListener());
   this.addMouseMotionListener(new Daymousemovelistener());
   this.addMouseMotionListener(new MouseListenerPrevNext());
   this.addMouseMotionListener(new MouseListenerToday());
   this.addMouseMotionListener(new MouseListenerImpt());
      
      this.engine = new AnimationEngine(this);
      engine.startEngine();
     
      ImportantMouseListener listener = new ImportantMouseListener();
      this.addMouseListener(listener);
  }

  
  public void addDrawable(Drawable d){
	    Calendars.add(d);
  }
  
  public void addDrawableForDay(Drawable d){
	    DrawForDay.add(d);
  }
  
  public void addDrawableForAnimation(Drawable d){
      this.drawAnimation.add(d);
  }

  public void setDate(Date date) {
    this.date = date;
  }
  
  
  public void paintComponent(Graphics g) {
      
   Graphics2D temp = (Graphics2D) g.create();
    ((Graphics2D) temp).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
  
    temp.fillRect(0, 0, getWidth(), getHeight());
    
   
    addDrawable(new DrawButtons());
    addDrawable(new DrawYear());  
    addDrawable(new DrawMonth());
    addDrawable(new DrawWeek());
    
    this.engine.clearAnimationList();
    for (int week = 1; week < 7; week++) {
        for (int d = 1; d < 8; d++) {
        	addDrawableForDay(new DrawDay(d,week));
                addDrawableForAnimation(new CalendarAnimation(d,week,this.engine));
               
        }
        }
    

   
    for (Drawable d: Calendars) {
        d.drawString(temp);
    }
     for (Drawable d: DrawForDay) {
        d.drawString(temp);
    }
      for (Drawable d: Selected) {
        d.drawString(temp);
    }
       for (Drawable d: Selected2) {
        d.drawString(temp);
    }
        for (Drawable d: MovedPrevNext) {
        d.drawString(temp);
    }
        for (Drawable d: MovedToday) {
        d.drawString(temp);
    }
        for (Drawable d: MovedImportant) {
        d.drawString(temp);
    }
        for (Drawable d: drawAnimation){
            d.drawString(temp);
        }
    Calendars.clear();
    DrawForDay.clear();
    drawAnimation.clear();
  
    temp.dispose();
  }
  public void run() {
        while(true){
            
            this.repaint();
            
            
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    

 
}

