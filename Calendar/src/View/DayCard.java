package View;

import Model.WeatherAPI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
 * 
 * All the animations should later be put into the animation engine
 * 
 * Animations arent done yet
 * 
 * @author Kristian
 */
public class DayCard extends JPanel implements Runnable{
    
    private int x = 280;
    private int y = 10;
    private WeatherAPI weather;
    
    public DayCard(){
        weather = new WeatherAPI();
        weather.setWeather(new GregorianCalendar());
        setPreferredSize(new Dimension(300,400));
        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        Thread thread = new Thread(this);
        thread.start();
        
    }
    
    @Override
    public void paintComponent(Graphics g){        
        Graphics temp = g.create();
        
        if(weather.isRainy()){
            paintRain(temp);
        }
        if(weather.isSunny()){
            //paintSun(temp);
        }
        if(weather.isWindy()){
            //paintWind(temp);
        }
        
        
        temp.setColor(Color.white);
        temp.drawString("Temperature in " + weather.getCity() + ": " + String.valueOf(this.weather.getAvgTemp()) + "C", 30, 30);
        
        //Drawable d = new Testfordaycard();
        
        temp.dispose();
    }
    
    @Override
    public void run() {
        while(true){
            
            this.repaint();
            
            if(y == 50){
                y = 0;
            }
            
            y += 10;
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(DayCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void paintSun(Graphics g) {
        g.fillRect(0, 0, 300, 280);
        g.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        g.fillOval(x, y, 4, 7);
    }

    private void paintWind(Graphics g) {
        g.fillRect(0, 0, 300, 280);
        g.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        g.fillOval(x, y, 7, 4);
    }
    
    private void paintRain(Graphics g){
        g.fillRect(0, 0, 300, 280);
        g.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        g.fillOval(x, y, 4, 7);
    }
    
    private void paintSnow(Graphics g){
        g.fillRect(0, 0, 300, 280);
        g.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
        g.fillOval(x, y, 4, 7);
    }
}
