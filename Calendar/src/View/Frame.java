/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author bigbigguoguo
 */
public class Frame extends JFrame{
    JSlider slider =new JSlider(0,7,0);
    JMenuBar menuBar = new JMenuBar();;
    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
    JMenu setMenu = new JMenu("Setting");
    JMenuItem btn;
    
   public Frame()
   { 
    
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      this.setPreferredSize(new Dimension(800, 400));     
      
      //this.setUndecorated(true); //to be fixed?
      
      btn=new JMenuItem("Window Transparency");
    btn.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent ae) {
            setOpacity();
          }
       });

    
   
    this.editMenu.add(new JMenuItem("Undo"));
    this.editMenu.add(new JMenuItem("Redo"));
    this.setMenu.add(btn);
    this.menuBar.add(fileMenu);
    this.menuBar.add(editMenu);
    this.menuBar.add(setMenu);
    this.setJMenuBar(this.menuBar);
    this.setVisible(true);     
   }
     
   
   public void setOpacity(){
  JDialog dialog;
  dialog = new JDialog(this,"Adjust Transparency",true);
  dialog.setSize(270,60);
  dialog.setResizable(false);
  Dimension thisSize=this.getSize();
  Point thisPoint=this.getLocation();
  Dimension diaSize=dialog.getSize();
  dialog.setLocation(50,50);
  JLabel label=new JLabel();
  
  slider.addChangeListener(new ChangeListener(){
          @Override
   public void stateChanged(ChangeEvent ce) {
      slider();
          }
  });
  JPanel upPanel=new JPanel(new FlowLayout());
  upPanel.add(label);
  upPanel.add(slider);
  dialog.add(upPanel,BorderLayout.CENTER);
  dialog.setVisible(true);
  }
   
   
   
public void slider(){
  double value=slider.getValue()/10.0;
  if(
  com.sun.awt.AWTUtilities.isWindowOpaque(this)){
  com.sun.awt.AWTUtilities.setWindowOpacity(this, (float)(1-value));
  slider.setCursor(new Cursor(Cursor.HAND_CURSOR));
 }
  else{JOptionPane.showMessageDialog(this,"not support");}
     }
  


public static void main(String[] args) {
 Frame frame = new Frame();
 Calendar ch = new Calendar();
 ch.setDate(new Date());
 DayCard card = new DayCard();
 frame.getContentPane().add(ch, BorderLayout.CENTER);
 frame.getContentPane().add(card, BorderLayout.EAST);
//frame.setUndecorated(true);

frame.pack();
frame.setVisible(true);     
}
}