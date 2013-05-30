package view;

import application.CalendarApp;
import controller.AnimationEngine;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.InputUtilities;
import model.CalculateDate;
import model.Event;
import model.TableModel;

/**
 * A calendaranimation class of the type animation
 * @author Kristian
 */
public class CalendarAnimation extends Animation{
    
    //Model with event objects
    private TableModel model = CalendarApp.getFrame().getEventPanel().getModel();
    
    //static variables as they arent instance specific and all highligts have
    //the same color
    public static boolean fadein;
    private static int[] colorCodes = {64,64,64};
    
    private int d;
    private int week;
    private Color color;
    private boolean highlighted = false;    
    private AnimationEngine engine;
    CalculateDate calculatedate = new CalculateDate();
    
    /**
     * Constructor that sets the intial variables of the animation
     * @param d
     * @param week
     * @param e 
     */
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

    /**
     * Overriden drawstring method, paints the highligting if the day should be
     * highlighted, if not this function doesnt do anything. 
     * @param g 
     */
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
    
    /**
     * Method that for the given day sets the boolean "highlighted" to true 
     * or false depending on whether or not that day has a high prio event
     * on it
     */
    private void setHighPrio(){                
        if(model.isFiltered() && model.getRowCount()>0){
            for (int i=0; i<model.getRowCount(); i++){
            	Event e = model.getRow(i);
                if(InputUtilities.convertStringToDate(e.getEventDueDate()).getTime().getDate() == calculatedate.gettime2().getDate() &&
                        InputUtilities.convertStringToDate(e.getEventDueDate()).getTime().getMonth() == calculatedate.gettime2().getMonth() &&     
                        InputUtilities.convertStringToDate(e.getEventDueDate()).getTime().getYear() == calculatedate.gettime2().getYear()){
                    this.highlighted = true;
                }
            }
        }
    }
    
    /**
     * Function that fades in on the highlighting by changing the color codes
     * accordingly
     */
    private static void fadeIn(){
        if(fadein && colorCodes[1]<245 && colorCodes[0]<245 && colorCodes[2]>7){
            colorCodes[0] = colorCodes[0]+7;
            colorCodes[1] = colorCodes[1]+7;
            colorCodes[2] = colorCodes[2]-1;

        }        
    }
    
    /**
     * Function that fades out from the highlighting by changing the color codes
     * accordingly
     */
    private static void fadeOut(){
        if(!fadein && colorCodes[0] > 63 && colorCodes[1] > 63 && colorCodes[2]<64){
            colorCodes[0] = colorCodes[0]-7;
            colorCodes[1] = colorCodes[1]-7;
            colorCodes[2] = colorCodes[2]+1;
        }
    }
    
    /**********************************************************
     ********* Getters and setters ****************************
     **********************************************************/
    
    public void setFade(){
        fadein = fadein != true;
    }
    
    public static Color getColor() {
        fadeIn();
        fadeOut();
        return new Color(colorCodes[0],colorCodes[1],colorCodes[2]);
    }
    
    public void setHighlighted(boolean h){
        this.highlighted = h;
    }
}
