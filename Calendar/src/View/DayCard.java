package View;

import Enums.Weather;
import Model.WeatherAPI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
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
    
    private int pic = 0;
    private WeatherAPI weather;
    private AnimationEngine engine;
    private ArrayList<AnimationEngine> engines;
    private Weather current;
    private GregorianCalendar date;
    
    public DayCard(){
        this(new GregorianCalendar());
    }
    
    public DayCard(GregorianCalendar cal){
        this.date = cal;
        weather = new WeatherAPI();
        weather.setWeather(new GregorianCalendar());
        setPreferredSize(new Dimension(300,400));
        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        this.engines = new ArrayList();
        try {
            this.current = weather.getWeather(this.date);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        addEngine(new AnimationEngine(this));
        startEngines();
    }
    
    private void startEngines(){
        Iterator iterator = this.engines.iterator();
        AnimationEngine temp;
        Thread thread;
        
        while(iterator.hasNext()){
            temp = (AnimationEngine)iterator.next();
            thread = new Thread(temp);
            thread.start();            
        }
    }
    
    @Override
    public void paintComponent(Graphics g){        
        Graphics temp = g.create();      
        
        
        temp.setColor(Color.white);
        try {
            temp.drawString("Temperature in Uppsala: " + String.valueOf(this.weather.getAvgTemp(date)) + "C", 30, 30);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(this.current == Weather.CLOUDY){
            paintCloud(temp);
        }
        else if(this.current == Weather.RAINY){
        
            paintRain(temp,pic);
        }
        else if(this.current == Weather.SUNNY){
            try {
                paintSun(temp,pic);
            } catch (IOException ex) {
                Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        //Drawable d = new Testfordaycard();
        
        temp.dispose();
    }

    public void paintSun(Graphics g, int i) throws IOException {
        BufferedImage img = null;
        
        try{
        if(i==0){
            img = ImageIO.read(new File("./resources/sun.jpg"));
        }
        else if(i==1){
            img = ImageIO.read(new File("./resources/sun2.jpg"));
        }
        
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        
        g.drawImage(img,250,20,30,30,null);
        
        pic = (pic-1)*(pic-1);
    }

    public void paintCloud(Graphics g) {
        BufferedImage img = null;
        
        try{
            img = ImageIO.read(new File("./resources/clody.png"));
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        
        g.drawImage(img,250,20,30,30,null);
    }
    
    public void paintRain(Graphics g, int i){
        BufferedImage img = null;
        
        try{
        if(i==0){
            img = ImageIO.read(new File("./resources/rainpng.png"));
        }
        else if(i==1){
            img = ImageIO.read(new File("./resources/rainpng2.jpg"));
        }
        else if(i==2){
            img = ImageIO.read(new File("./resources/rainpng3.jpg"));
        }
        
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        
        g.drawImage(img,250,20,30,30,null);
        
        if(pic == 2){
            pic = 0;
        }
        else{
            pic += 1;
        }
    }
    
    public void paintSnow(Graphics g){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./resources/snow.jpg"));
        }       
        catch (IOException e) {
        }
        g.drawImage(img,280, pic, 30, 30,null);
    }
    
    private void addEngine(AnimationEngine eng){
        this.engines.add(eng);
    }
    
    public void setDate(GregorianCalendar cal){
        this.date = cal;
    }
    
    public GregorianCalendar getDate(GregorianCalendar cal){
        return this.date;
        
    }
    
    public void updateWeather(){
        try {
            this.current = this.weather.getWeather(date);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
