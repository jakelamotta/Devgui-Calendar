
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

import controller.FilterAction;
import controller.ShowAddEventUIAction;

import application.CalendarApp;
import controller.AnimationEngine;
import controller.ToggleAnimationAction;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;


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
    private JMenu helpMenu;
    private JMenuItem help;
    private JMenuItem cancel;
    private JMenuItem addEventItem;
    private JMenuItem close;
    private JMenu editMenu;
    private JMenuItem undo;
    private JMenuItem redo;
    private JMenu setMenu;
    private JMenuItem btn;
    private JButton addEventButton;
    private EventPanel eventPanel;
    private AnimationEngine calendarEngine;
    private AnimationEngine dayCardEngine;
    private Glasspane G;
    public List<Drawable> Glass = new ArrayList<Drawable>();
   public Frame()
   {    JFrame f=this;
           calendarEngine = new AnimationEngine();
           dayCardEngine = new AnimationEngine();
           
	   eventPanel = new EventPanel();
	   ch = new Calendar();
	   ch.setDate(new Date());
	   card = new DayCard(dayCardEngine);
	   slider = new JSlider(0,7,0);
          
           
           //setTheGlassPane(G,true);
	   //Glasspane G= (Glasspane)this.getGlassPane();
           //G.setVisible(true);
           
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
	   
	   /*
	    * ************************************************************
	    * FILTER BUTTON FOR MOCK UP
	    * REMOVE HERE
	    */
	   
	   c.gridx = 1;
	   c.gridy = 1;
	   c.weightx = 0;
	   c.weighty = 0;
	   
	   Action filterEvent = new FilterAction("Show All Events");
	   JButton filterEventButton = new JButton(filterEvent);
	   getContentPane().add(filterEventButton, c);
	   
	   /*
	    * FILTER BUTTON FOR MOCK UP
	    * REMOVE HERE
	    * ************************************************************
	    */
	   
	   c.weightx = 1;
	   c.weighty = 1;
	   c.gridwidth = 2;
	   c.gridx = 0;
	   c.gridy = 2;
	   getContentPane().add(eventPanel, c); 
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setPreferredSize(new Dimension(1100, 630));     
	   //this.setUndecorated(true);
      
	   //********** Menu **********
	   menuBar = new JMenuBar();
	   fileMenu = new JMenu("File");
           helpMenu = new JMenu("Help");
           help= new JMenuItem("ShowGuide");
           cancel=new JMenuItem("Cancel");
	   help.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
                   try {
                       G=new Glasspane();
                   } catch (IOException ex) {
                       Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                   }
                    //G.addMouseListener(new Glasslistener());
                    setTheGlassPane(G,true);
                      
		}
	   });
           cancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
                  
                    //G.addMouseListener(new Glasslistener());
                    setTheGlassPane(G,false);
                      
		}
	   });
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
           editMenu.add(new ToggleAnimationAction(dayCardEngine));
           menuBar.add(editMenu);
      
	   this.setMenu.add(btn);
           this.helpMenu.add(help);
           this.helpMenu.add(cancel);
	   this.menuBar.add(setMenu);
           this.menuBar.add(helpMenu);
	   this.setJMenuBar(this.menuBar);
      
	   this.setVisible(true);    
	   this.pack();
   	}
     
  /* public class Glasslistener extends MouseAdapter {
   public void getxpoint(float x,float y){

        if((108.5-22.5<x)&&(x<108.5+22.5)){
             setTheGlassPane(G,false);
        }
   }
       public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (e.getClickCount() == 1) {
               float x=e.getX();
                float y=e.getY();
               getxpoint(x,y);
            }
        }
   
   }
   
   }*/
   	/**
 	* Adjust Transparency
 	*/
   void setTheGlassPane(JComponent glassPane,boolean i) {
    	this.setGlassPane(glassPane);
    	this.getGlassPane().setVisible(i);
        //this.validate();
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
