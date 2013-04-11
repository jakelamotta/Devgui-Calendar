package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Kristian
 */
public class DayCard extends JPanel implements Runnable{
    
    private int x = 280;
    private int y = 10;
    
    public DayCard(){
        setPreferredSize(new Dimension(300,280));
        
    }
    
    @Override
    public void paintComponent(Graphics g){        
        Graphics temp = g.create();
        temp.fillRect(0, 0, 300, 280);
        //temp.dispose();
        
        //temp = g.create();
        temp.setColor(Color.BLUE);
        temp.fillOval(x, y, 4, 7);
                
        temp.dispose();
    }
    
    public static void main(String[] args){
        DayCard card = new DayCard();
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        
        Thread thread = new Thread(card);
        thread.start();
        
        frame.getContentPane().add(card);
        
        frame.pack();
        frame.setVisible(true);
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
}
