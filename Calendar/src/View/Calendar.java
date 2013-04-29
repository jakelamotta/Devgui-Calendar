package View;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
// test the pushing
 
  
public class Calendar extends JPanel implements Runnable {
  	
  private SimpleDateFormat month = new SimpleDateFormat("MMMM");
  private SimpleDateFormat year = new SimpleDateFormat("yyyy");
  private SimpleDateFormat day = new SimpleDateFormat("d");
  private Date date = new Date();
  public List<Drawable> Calendars = new ArrayList<Drawable>();
  public List<Drawable> DrawForDay = new ArrayList<Drawable>();
  public static List<Drawable> Selected = new ArrayList<Drawable>();
 
  public  Calendar(){
      
      setPreferredSize(new Dimension(380,400));
      Thread thread = new Thread(this);
        thread.start();
  }

  
  public void addDrawable(Drawable d){
	    Calendars.add(d);
  }
  
  public void addDrawableForDay(Drawable d){
	    DrawForDay.add(d);
  }
	

//Drawable[] calendars = new Drawable[] {
  //        new DrawMonth(),
    //      new DrawYear(),
      //    new Drawday(3,5),
        //  new Drawday(1,1),
//};

  public void setDate(Date date) {
    this.date = date;
  }
  
  
  
  public void paintComponent(Graphics g) {
      
   Graphics2D temp = (Graphics2D) g.create();
    ((Graphics2D) temp).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    //temp.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.1f));
    
    temp.fillRect(0, 0, getWidth(), getHeight());
    
    //g.setColor(Color.red);
    //g.drawString(month.format(date), 34, 36);
    //g.setColor(Color.white);
    //g.drawString(year.format(date), 235, 36);
  
    addDrawable(new DrawYear());  
    addDrawable(new DrawMonth());
    addDrawable(new DrawWeek());
    for (int week = 1; week < 7; week++) {
        for (int d = 1; d < 8; d++) {
        	addDrawableForDay(new DrawDay(d,week));
                //Listener L=new Listener(d,week);
        }
        }
    this.addMouseListener(new DayMouseListener());
   // temp.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.1f));
    for (Drawable d: Calendars) {
        d.drawString(temp);
    }
     for (Drawable d: DrawForDay) {
        d.drawString(temp);
    }
      for (Drawable d: Selected) {
        d.drawString(temp);
    }
    Calendars.clear();
    DrawForDay.clear();
   // Calendar today = Calendar.getInstance();
    //today.setTime(date);
    //Calendar cal = Calendar.getInstance();
    //cal.setTime(date);
    //cal.set(Calendar.DATE, 1);
    //cal.add(Calendar.DATE, -cal.get(Calendar.DAY_OF_WEEK) + 1);
    //for (int week = 0; week < 6; week++) {
      //for (int d = 0; d < 7; d++) {
        //Color col = Color.red;
          //g.drawString(day.format(cal.getTime()), d * 30 + 46 + 4,
            //  week * 29 + 81 + 20);
       // cal.add(Calendar.DATE, +1);
      //}
    //}
    temp.dispose();
  }
  public void run() {
        while(true){
            
            this.repaint();
            
            
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

 
}

