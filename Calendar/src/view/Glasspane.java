/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author bigbigguoguo
 */
public class Glasspane extends JComponent {
public Glasspane()
{
 

}
    @Override
    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.30f));
      g2.setColor(Color.getHSBColor((float)0.5,(float) 0.5,(float) 0.5));
      g2.fillRect(222,150, 380, 420);
      
    }
    
}
