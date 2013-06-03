package view;

import enums.Weather;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
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
    private ArrayList<BufferedImage> imgSuns;
    private ArrayList<BufferedImage> imgClouds;
    private ArrayList<BufferedImage> imgRains;
    private ArrayList<BufferedImage> imgSnow;
    
    
    public WeatherAnimation(){
        super.showAnimation = true;
        loadWeatherImages();
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
                    paintSun(g,pic);
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
    public void paintSun(Graphics g, int i) {
                
        g.drawImage(this.imgSuns.get(i),250,20,150,150,null);
        
        //Update choice of images (switching between 0 and 1, animation shifts 
        //between two pictures to create a shining sun
        if(showAnimation){
            if(pic == 2){
                pic = 0;
            }
            else{
                pic += 1;
            }
        }
    }

    /**
     * Paints a cloud
     * @param g 
     */    
    public void paintCloud(Graphics g) {
        g.drawImage(this.imgClouds.get(0),250,20,30,30,null);
    }
    
    /**
     * Function that draw a rain animation
     * @param g Graphics object to be used.
     * @param i i is the number used to choose between pictures to draw
     */
    public void paintRain(Graphics g, int i){
        
        g.drawImage(this.imgRains.get(i),250,20,150,150,null);       
        
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
        g.drawImage(this.imgSnow.get(0),280, pic, 30, 30,null);
    }

    private void loadWeatherImages() {
        this.imgClouds = new ArrayList();
        this.imgRains = new ArrayList();
        this.imgSnow = new ArrayList();
        this.imgSuns = new ArrayList();
        
        try {
            this.imgRains.add(ImageIO.read(this.getClass().getResource("rainpng.png")));
            this.imgRains.add(ImageIO.read(this.getClass().getResource("rainpng2.png")));
            this.imgRains.add(ImageIO.read(this.getClass().getResource("rainpng3.png")));
            
            this.imgSuns.add(ImageIO.read(this.getClass().getResource("sun.png")));
            this.imgSuns.add(ImageIO.read(this.getClass().getResource("sun2.png")));
            this.imgSuns.add(ImageIO.read(this.getClass().getResource("sun3.png")));
            
            this.imgClouds.add(ImageIO.read(this.getClass().getResource("clody.png")));
        } catch (IOException ex) {
            Logger.getLogger(WeatherAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
