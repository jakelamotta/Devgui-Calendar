package View;

import Controller.AnimationEngine;
import Enums.Weather;
import Model.WeatherAPI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Not done:
 * 
 * Currently only works with todays date, obv need to get specific date from
 * calendar selection
 * 
 * All the animations should later be put into the animation engine
 * 
 * Animations arent done yet
 * 
 * @author Kristian
 */
public class DayCard extends JPanel{
    
    private WeatherAPI weather;
    private AnimationEngine engine;
    private Weather current;
    private GregorianCalendar date;
    
    /**
     * Default constructor, created with todays date as date.
     */
    public DayCard(){
        this(new GregorianCalendar());
    }
    
    /**
     * Constructor with one parameter, create the day card corresponding to
     * a specific date.
     * @param cal 
     */
    public DayCard(GregorianCalendar cal){
        //Initialize all variables
        this.date = cal;
        weather = new WeatherAPI();
        weather.setWeather(new GregorianCalendar());
        setPreferredSize(new Dimension(300,400));
        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        this.engine = new AnimationEngine(this);
        
        //attempt to get weather information
        try {
            this.current = weather.getWeather(this.date);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setTemperature();
        
        startEngine(engine);
    }
    
    
    private void startEngine(AnimationEngine engine){
        Thread thread = new Thread(engine);
        thread.start();            
        
    }
    
    /**
     * Overriden paintcomponent function, when called the animations are updated
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){        
        Graphics temp = g.create();      
                
        temp.setColor(Color.white);
        
        temp.drawString("Temperature in Uppsala: " + String.valueOf(this.weather.getAvgTemp()) + "C", 30, 30);
        
        this.engine.drawWeatherAnimation(temp,this.current);
        
        temp.dispose();
    }
    
    /**********************************************************
     ********* Getters and setters ****************************
     **********************************************************/
    
    public void setWeather(){
        try {
            this.current = this.weather.getWeather(date);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setDate(GregorianCalendar cal){
        this.date = cal;
    }
    
    public GregorianCalendar getDate(GregorianCalendar cal){
        return this.date;
        
    }

    private void setTemperature() {
        try {
            this.weather.setAvgTemp(date);
        } catch (IOException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
