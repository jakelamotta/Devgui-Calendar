package view;

import controller.AnimationEngine;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.CalculateDate;
import model.Event;

/**
 * 
 * @author Kristian
 */
public class CalendarAnimation extends Animation{
    
    private int fadeing = -1;
    private static ArrayList<Event> events = new ArrayList();
    private int d;
    private int week;
    private Color color;
    private boolean highlighted = false;
    private int[] colorCodes = {64,64,64};
    private AnimationEngine engine;
    CalculateDate calculatedate = new CalculateDate();
    
    public CalendarAnimation(int d,int week, AnimationEngine e){
        super.showAnimation = true;
        this.d=d;
        this.week=week;
        this.setHighPrio();
        this.color = new Color(colorCodes[0],colorCodes[1],colorCodes[2]);
        engine = e;
        engine.addAnimation(this);        
    }

    public void drawString(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();  
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.010f));
        if(this.highlighted){
            g2.setColor(this.color);
            this.color = getColor();
            g2.fillRoundRect((d-1) * 45 + 86, (week-1)* 45 + 86, 40, 40,10,10);
        }
    }     
    
    private void setHighPrio(){
        for (Event e: CalendarAnimation.events){
            if(e.getEventDate().equals(calculatedate.gettime()) && e.getEventPriority() == 5){
                this.highlighted = true;
            }
        }
    }
    
    public void setHighlighted(boolean h){
        this.highlighted = h;
    }
    private void changeColors(){
        if(this.colorCodes[0] > 63 && this.colorCodes[0]<151){
            this.colorCodes[0] = this.colorCodes[0]+1;
            this.colorCodes[1] = this.colorCodes[1]+1;
            this.colorCodes[2] = this.colorCodes[2]+1;
        }
        
    }
    
    public void setFade(){
        this.fadeing = fadeing*-1;
    }
    
    public Color getColor() {
        changeColors();
        return new Color(colorCodes[0],colorCodes[1],colorCodes[2]);
    }
}