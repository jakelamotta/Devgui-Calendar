package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calendar extends JPanel  {
	
  private SimpleDateFormat month = new SimpleDateFormat("MMMM");
  private SimpleDateFormat year = new SimpleDateFormat("yyyy");
  private SimpleDateFormat day = new SimpleDateFormat("d");
  private Date date = new Date();
  private List<Drawable> Calendars = new ArrayList<Drawable>();
  private List<Drawable> DrawForDay = new ArrayList<Drawable>();
  
  public void Calendar(){
      setPreferredSize(new Dimension(300,280));
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
      
    Graphics temp = g.create();  
    ((Graphics2D) temp).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    temp.fillRect(0, 0, getWidth(), getHeight());
    //g.setColor(Color.red);
    //g.drawString(month.format(date), 34, 36);
    //g.setColor(Color.white);
    //g.drawString(year.format(date), 235, 36);
    addDrawable(new DrawMonth());
    addDrawable(new DrawYear());
    for (int week = 0; week < 6; week++) {
        for (int d = 0; d < 7; d++) {
        	addDrawableForDay(new DrawDay(d,week));
        }
        }
    
    for (Drawable d: Calendars) {
        d.drawString(temp);
    }
     for (Drawable d: DrawForDay) {
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
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setPreferredSize(new Dimension(600, 280));

    Calendar ch = new Calendar();
    ch.setDate(new Date());
    
    DayCard card = new DayCard();
    
    frame.getContentPane().add(ch, BorderLayout.CENTER);
    frame.getContentPane().add(card, BorderLayout.EAST);
    frame.setUndecorated(true);

    frame.pack();
    frame.setVisible(true);
  }
}

