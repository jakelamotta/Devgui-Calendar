package view;

import application.CalendarApp;
import controller.AnimationEngine;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.CalculateDate;
import model.Event;

/**
 * A calendaranimation class
 * @author Kristian
 */
public class CalendarAnimation extends Animation{
    
    private int fade = 1;
    private boolean fadein = false;
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
        if(this.highlighted){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.02f));
            g2.setColor(color);
            this.color = getColor();
            g2.fillRoundRect((d-1) * 45 + 86, (week-1)* 45 + 86, 40, 40,10,10);
        }
    }     
    
    private void setHighPrio(){
        if(!CalendarApp.getFrame().getEventPanel().getModel().getFilteredData().isEmpty()){
            for (Event e: CalendarApp.getFrame().getEventPanel().getModel().getFilteredData()){
                System.out.println("Is due: " + e.getEventDueDate() + "calc date is: " + calculatedate.gettime());
                if(e.getEventDueDate().equals(calculatedate.gettime()) && e.getEventPriority() == 100){
                    this.highlighted = true;
                }
            }
        }
    }
    
    public void setHighlighted(boolean h){
        this.highlighted = h;
    }
    private void fadeIn(){
        if(fadein && this.colorCodes[1]<155 && this.colorCodes[0]<155 && this.colorCodes[2]>10){
            colorCodes[0] = colorCodes[0]+fade+6;
            colorCodes[1] = colorCodes[1]+fade+6;
            colorCodes[2] = colorCodes[2]-fade;
        }        
    }
    
    private void fadeOut(){
        if(!fadein && this.colorCodes[0] > 63 && this.colorCodes[1] > 63 && this.colorCodes[2]<64){
            colorCodes[0] = colorCodes[0]-fade+6;
            colorCodes[1] = colorCodes[1]-fade+6;
            colorCodes[2] = colorCodes[2]+fade;
        }        
    }
    
    public void setFade(){
        fadein = fadein != true;
    }
    
    public Color getColor() {
        fadeIn();
        return new Color(colorCodes[0],colorCodes[1],colorCodes[2]);
    }
}