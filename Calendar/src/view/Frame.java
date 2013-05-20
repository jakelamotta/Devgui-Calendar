
package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;
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

import controller.DisableAnimationAction;
import controller.EnableAnimationAction;
import controller.ShowAddEventUIAction;

import application.CalendarApp;


/**
 *
 * @author Guo
 * @author Qi
 * @author Deha
 */
public class Frame extends JFrame{
    private Calendar ch;
    private DayCard card;
	private JSlider slider;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem addEventItem;
    private JMenuItem close;
    private JMenu editMenu;
    private JMenuItem undo;
    private JMenuItem redo;
    private JMenu setMenu;
    private JMenuItem btn;
    private JButton addEventButton;
    private EventPanel eventPanel;
    
   public Frame()
   { 
	   eventPanel = new EventPanel();
	   ch = new Calendar();
	   ch.setDate(new Date());
	   card = new DayCard();
	   slider = new JSlider(0,7,0);
	   
	   getContentPane().setLayout(new GridBagLayout());
	   
	   GridBagConstraints c = new GridBagConstraints();
	   c.fill = GridBagConstraints.BOTH;
	   c.weightx = 2;
	   c.weighty = 2;
	   c.gridx = 0;
	   c.gridy = 0;	   
	   getContentPane().add(ch, c);
	   
	   c.gridx = 1;
	   getContentPane().add(card, c);
	   
	   c.gridx = 0;
	   c.gridy = 1;
	   c.weightx = 0;
	   c.weighty = 0;
	   
	   Action addEvent = new ShowAddEventUIAction("Add Event");
	   addEventButton = new JButton(addEvent);
	   getContentPane().add(addEventButton, c);
	   
	   c.weightx = 1;
	   c.weighty = 1;
	   c.gridwidth = 2;
	   c.gridy = 2;
	   getContentPane().add(eventPanel, c); 
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setPreferredSize(new Dimension(900, 630));     
	   this.setUndecorated(true);
      
	   //********** Menu **********
	   menuBar = new JMenuBar();
	   fileMenu = new JMenu("File");
	   
	   addEventItem = new JMenuItem(addEvent);
	   
	   close = new JMenuItem("Exit");
	   close.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	   });
	   
	   setMenu = new JMenu("Settings");
      
           //Set Transparency
	   btn=new JMenuItem("Window Transparency");
	   btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                 setOpacity();
                }
           });
   
	   editMenu = new JMenu("Edit");
	
	   //Undo
	   undo = new JMenuItem("Undo");
	   undo.setEnabled(false);
	
	   undo.addActionListener(new ActionListener() {
		
		   @Override
		   public void actionPerformed(ActionEvent arg0) {
			   CalendarApp.getInvoker().unexecuteCommand();
			
		   }
	   });
	
      //Redo
	   redo = new JMenuItem("Redo");
	   redo.setEnabled(false);
	
	   redo.addActionListener(new ActionListener() {
		
		   @Override
		   public void actionPerformed(ActionEvent e) {
			   CalendarApp.getInvoker().reexecuteCommand();
		   }
	   });
	   
	   this.fileMenu.add(addEventItem);
	   this.fileMenu.add(close);
	   this.menuBar.add(fileMenu);
      
	   editMenu.add(undo);
	   editMenu.add(redo);
           editMenu.add(new EnableAnimationAction());
           editMenu.add(new DisableAnimationAction());
	   menuBar.add(editMenu);
      
	   this.setMenu.add(btn);
	   this.menuBar.add(setMenu);
      
	   this.setJMenuBar(this.menuBar);
      
	   this.setVisible(true);    
	   this.pack();
   	}
     
   	/**
 	* Adjust Transparency
 	*/
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
   		if(com.sun.awt.AWTUtilities.isWindowOpaque(this)){
   			com.sun.awt.AWTUtilities.setWindowOpacity(this, (float)(1-value));
   			slider.setCursor(new Cursor(Cursor.HAND_CURSOR));
   		}
   		else{JOptionPane.showMessageDialog(this,"not support");}
   	}
  
   	public EventPanel getEventPanel() {
   		return eventPanel;
   	}

   	public void setUndo(boolean state){
   		undo.setEnabled(state); 
   	}
 
   	public void setRedo(boolean state){
   		redo.setEnabled(state);  
   	}
}