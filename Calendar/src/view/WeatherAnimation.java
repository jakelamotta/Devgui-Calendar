package view;

import enums.Weather;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * A class of type animation that has definitions for how the weather
 * animation is to be drawn
 * @author Kristian
 */
public class WeatherAnimation extends Animation {
    
    //this int defines what picture to draw, the animation is done by
    //rotating between pictures.
    private int pic = 0;
    
    public WeatherAnimation(){
        super.showAnimation = true;
    }
    
    @Override
    public void drawString(Graphics g) {
    }
    
    /**
     * Function that make sure the correct animation is drawn by using an
     * Weather enum as parameter
     * @param g Object to draw on
     * @param weather Weather to be drawn
     */
    public void drawWeatherAnimation(Graphics g, Weather weather) {
        switch(weather){
                default:
                    break;
                case CLOUDY:
                    paintCloud(g);
                    break;
                case RAINY:
                    paintRain(g,pic);
                    break;
                case SUNNY:
                    try {
                        paintSun(g,pic);
                    } 
                    catch (IOException ex) {
                        Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case SNOWY:
                    paintSnow(g);
                    break;
        }
        if(!super.showAnimation){
            pic = 0;
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
        if(showAnimation){
            pic = (pic-1)*(pic-1);
        }
    }

    /**
     * Paints a cloud
     * @param g 
     */    
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
        
        g.drawImage(img,250,20,150,150,null);
        
        
        
        if(showAnimation){
            //Update choice of images (switching between 0,1 and 2, animation shifts 
            //between three pictures to create a rain animation
            if(pic == 2){
                pic = 0;
            }
            else{
                pic += 1;
            }
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
}
