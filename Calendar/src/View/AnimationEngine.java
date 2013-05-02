package View;

import javax.swing.JComponent;

/**
 * Animation engine class, each instance of the engine defines a animation. 
 * @author Kristian
 */
public class AnimationEngine implements Runnable{
    
    private JComponent component;
    private final int sleepTime = 100;

    public AnimationEngine(JComponent comp){
        this.component = comp;
    }
    

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void drawRaindrop(){
        
    }
    
    private void drawSun(){
        
    }
    
    private void drawCloud(){
    }
    
    private void drawSnowflake(){
    }
    
}