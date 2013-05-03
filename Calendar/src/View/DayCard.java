package View;

import Model.WeatherAPI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
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
    
    private int x = 280;
    private int y = 0;
    private WeatherAPI weather;
    private AnimationEngine engine;
    
    public DayCard(){
        weather = new WeatherAPI();
        weather.setWeather(new GregorianCalendar());
        setPreferredSize(new Dimension(300,400));
        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        this.engine = new AnimationEngine(this);
        Thread thread = new Thread(engine);
        thread.start();        
    }
    
    @Override
    public void paintComponent(Graphics g){        
        Graphics temp = g.create();      
        
        
        temp.setColor(Color.white);
        temp.drawString("Temperature in " + weather.getCity() + ": " + String.valueOf(this.weather.getAvgTemp()) + "C", 30, 30);
        
        try {
            paintSun(temp,y);
        } catch (IOException ex) {
            Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
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
        
        y = (y-1)*(y-1);
    }

    public void paintCloud(Graphics g) {
        g.fillRect(0, 0, 300, 280);
        g.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        g.fillOval(x, y, 7, 4);
    }
    
    public void paintRain(Graphics g){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./resources/raindrop.jpg"));
        }       
        catch (IOException e) {
            System.out.println("error!!");
        }
        g.drawImage(img,x-15, y, 30, 30,null);
    }
    
    public void paintSnow(Graphics g){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./resources/snow.jpg"));
        }       
        catch (IOException e) {
        }
        g.drawImage(img,x-15, y, 30, 30,null);
    }
}
