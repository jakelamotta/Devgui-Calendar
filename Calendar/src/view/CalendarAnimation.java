package view;

import application.CalendarApp;
import controller.AnimationEngine;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import model.InputUtilities;
import model.CalculateDate;
import model.Event;

/**
 * A calendaranimation class
 * @author Kristian
 */
public class CalendarAnimation extends Animation{
    
    private static int fade = 1;
    public static boolean fadein;
    private static ArrayList<Event> events = new ArrayList();
    private int d;
    private int week;
    private Color color;
    private boolean highlighted = false;
    private static int[] colorCodes = {64,64,64};
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
        calculatedate.setCalendar2();
    }

    public void drawString(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();  
        
        this.setHighPrio();
        
        if(this.highlighted){
            
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.2f));
            g2.setColor(this.color);
            this.color = getColor();
            g2.fillRoundRect((d-1) * 45 + 86, (week-1)* 45 + 86, 40, 40,10,10);
        }
        calculatedate.upgradeCalendar2();
    }     
    
    private void setHighPrio(){
                
        if(!CalendarApp.getFrame().getEventPanel().getModel().getFilteredData().isEmpty()){
            for (Event e: CalendarApp.getFrame().getEventPanel().getModel().getFilteredData()){
                if(InputUtilities.convertStringToDate(e.getEventDueDate()).getTime().getDate() == calculatedate.gettime2().getDate() &&
                        InputUtilities.convertStringToDate(e.getEventDueDate()).getTime().getMonth() == calculatedate.gettime2().getMonth() &&     
                        InputUtilities.convertStringToDate(e.getEventDueDate()).getTime().getYear() == calculatedate.gettime2().getYear()){
                    this.highlighted = true;
                }
            }
        }
    }
    
    public void setHighlighted(boolean h){
        this.highlighted = h;
    }
    
    private static void fadeIn(){
        if(fadein && colorCodes[1]<245 && colorCodes[0]<245 && colorCodes[2]>7){
            colorCodes[0] = colorCodes[0]+fade+6;
            colorCodes[1] = colorCodes[1]+fade+6;
            colorCodes[2] = colorCodes[2]-fade;

        }        
    }
    
    private static void fadeOut(){
        if(!fadein && colorCodes[0] > 63 && colorCodes[1] > 63 && colorCodes[2]<64){
            colorCodes[0] = colorCodes[0]-fade-6;
            colorCodes[1] = colorCodes[1]-fade-6;
            colorCodes[2] = colorCodes[2]+fade;
        }
    }
    
    public void setFade(){
        fadein = fadein != true;
    }
    
    public static Color getColor() {
        fadeIn();
        fadeOut();
        return new Color(colorCodes[0],colorCodes[1],colorCodes[2]);
    }
}