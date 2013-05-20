package View;

import Model.CalculateDate;
import Model.Event;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Kristian
 */
public class CalendarAnimation extends Animation{
    
    private static ArrayList<Event> events = new ArrayList();
    private int d;
    private int week;
    private Color color;
    private boolean highlighted = false;
    CalculateDate calculatedate = new CalculateDate();
    
    public CalendarAnimation(int d,int week, Color col){
        
        this.d=d;
        this.week=week;
        this.color = col;
        this.setHighPrio();
    }

    public void drawString(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();  
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.30f));
        if(this.highlighted){
            g2.setColor(this.color);
            g2.drawRoundRect((d-1) * 45 + 86, (week-1)* 45 + 86, 40, 40,10,10);
        }
    }     
    
    private void setHighPrio(){
        CalendarAnimation.events.add(new Event());
        
        for (Event e: CalendarAnimation.events){
            if(e.getEventDate().equals(calculatedate.gettime()) && e.getEventPriority() == 5){
                this.highlighted = true;
            }
        }
    }
    
    public void setColor(Color c){
        this.color = c;
    }
    
    public void setHighlighted(boolean h){
        this.highlighted = h;
    }
}