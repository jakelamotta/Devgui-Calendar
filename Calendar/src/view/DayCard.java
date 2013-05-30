package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import model.WeatherAPI;

import controller.AnimationEngine;
import controller.WeatherMouseListener;
import enums.Weather;

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
    private WeatherAnimation animation = new WeatherAnimation();
    
    /**
     * Default constructor, chain calls the 2nd constructor with null object.
     */
    public DayCard(){
        this(null);
    }
    
    /**
     * Calls the 2-parameter constructor with todays date
     * @param engine 
     */
    public DayCard(AnimationEngine engine){
        this(engine,new GregorianCalendar());
    }
    
    /**
     * Constructor with one parameter, create the day card corresponding to
     * a specific date.
     * @param cal 
     */
    public DayCard(AnimationEngine eng, GregorianCalendar cal){
        //Initialize all variables
        this.date = cal;
        
        weather = new WeatherAPI();
        weather.setWeather(new GregorianCalendar());
        
        setPreferredSize(new Dimension(300,400));
        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        
        this.engine = eng;
        eng.setPanel(this);
        
        this.addMouseListener(new WeatherMouseListener(engine));
        
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
        this.engine.addAnimation(this.animation);
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
        //set layout of the texts /Qi
        temp.setColor(Color.lightGray);
        Font Eweather=new Font("Century Gothic",Font.PLAIN,50);
        temp.setFont(Eweather);
        temp.drawString(String.valueOf(this.weather.getAvgTemp()), 50, 100);
        Font Gweather=new Font("Century Gothic",Font.PLAIN,30);
        temp.setFont(Gweather);
        temp.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        temp.drawString("°C", 110, 100);
        Font Fweather=new Font("Century Gothic",Font.PLAIN,26);
        temp.setFont(Fweather);
        temp.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        temp.drawString("Uppsala",50,150);
        
        ((WeatherAnimation)this.engine.getAnimationAtIndex(0)).drawWeatherAnimation(temp,this.current);
        
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
