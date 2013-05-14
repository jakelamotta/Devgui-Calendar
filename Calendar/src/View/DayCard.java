package View;

import Controller.AnimationEngine;
import Enums.Weather;
import Model.WeatherAPI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Not done:
 * 
 * Currently only works with todays date, obv need to get specific date from
 * calendar selection
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
        setBackground(new Color(51,51,51));
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
    
    /**
     * Function that starts a new thread for the input animationengine
     * @param engine 
     */
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
    	super.paintComponent(g);
    	
        Graphics temp = g.create();      
                
        temp.setColor(Color.black);
        
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
