package Controller;

import Enums.Weather;
import View.DayCard;
import View.Drawable;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Animation engine class, each instance of the engine defines a animation. 
 * @author Kristian
 */
public class AnimationEngine implements Runnable, Drawable{
    
    private int pic = 0;
    private JPanel panel;
    private int sleepTime = 100;
    private boolean showAnimation;

    public AnimationEngine(JPanel comp){
        this.panel = comp;
    }
    

    @Override
    public void run() {
        while(true){
            
            this.panel.repaint();
            
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void drawString(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void drawWeatherAnimation(Graphics g, Weather weather) {
        //Draw animation according to current weather.
        if(weather == Weather.CLOUDY){
            paintCloud(g);
        }
        else if(weather == Weather.RAINY){
        
            paintRain(g,pic);
        }
        else if(weather == Weather.SUNNY){
            try {
                paintSun(g,pic);
            } catch (IOException ex) {
                Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Paints sun representing sunny weather.
     * @param g Graphics object to be used
     * @param i Which of the image to be used
     * @throws IOException 
     */
    public void paintSun(Graphics g, int i) throws IOException {
        BufferedImage img = null;
        
        try{
            if(i==0){
                //img = ImageIO(this.getClass().getResource("addtask.jpg"));
                img = ImageIO.read(this.getClass().getResource("sun.jpg"));
            }
        else if(i==1){
            img = ImageIO.read(this.getClass().getResource("sun2.jpg"));
        }
        
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        
        g.drawImage(img,250,20,30,30,null);
        
        //Update choice of images (switching between 0 and 1, animation shifts 
        //between two pictures to create a shining sun
        pic = (pic-1)*(pic-1);
    }

    public void paintCloud(Graphics g) {
        BufferedImage img = null;
        
        try{
            img = ImageIO.read(this.getClass().getResource("clody.png"));
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        
        g.drawImage(img,250,20,30,30,null);
    }
    
    /**
     * Function that draw a rain animation
     * @param g Graphics object to be used.
     * @param i i is the number used to choose between pictures to draw
     */
    public void paintRain(Graphics g, int i){
        BufferedImage img = null;
        
        try{
        if(i==0){
            img = ImageIO.read(this.getClass().getResource("rainpng.png"));
        }
        else if(i==1){
            img = ImageIO.read(this.getClass().getResource("rainpng2.png"));
        }
        else if(i==2){
            img = ImageIO.read(this.getClass().getResource("rainpng3.png"));
        }
        
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        
        g.drawImage(img,250,20,30,30,null);
        
        //Update choice of images (switching between 0,1 and 2, animation shifts 
        //between three pictures to create a rain animation
        if(pic == 2){
            pic = 0;
        }
        else{
            pic += 1;
        }
    }
    
    /**
     * Function that draw a snow animation
     * @param g Graphics object to be used.
     */
    public void paintSnow(Graphics g){
        BufferedImage img = null;
        try {
            img = ImageIO.read(this.getClass().getResource("snow.jpg"));
        }       
        catch (IOException e) {
        }
        g.drawImage(img,280, pic, 30, 30,null);
    }
    
    /**********************************************************
     ********* Getters and setters ****************************
     **********************************************************/
    
    public void setSleeptime(int newTime){
        this.sleepTime = newTime;
    }    
}