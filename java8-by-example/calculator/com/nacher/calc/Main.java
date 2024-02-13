package com.nacher.calc;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class Main extends JFrame implements PropertyChangeListener {
	
	private static final long serialVersionUID = -4136829057174783241L;
	
	private static Main mySelf;
	private static PanelCalculator panelCalc;
	
	public static Controller controller;
	
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });		
	}
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {	
    	controller = new Controller();
        panelCalc = new PanelCalculator(controller);
        controller.addPropertyChangeListener(panelCalc);
        mySelf = new Main();
        
        try {
	        mySelf.setTitle("Calculator");
	        mySelf.setLocationRelativeTo(null);
	        mySelf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        mySelf.setIconImage(new ImageIcon(mySelf.getClass().getResource(ImageConstants.CALC_IMAGE_THREE)).getImage());
	        mySelf.getContentPane().add(panelCalc);
	        mySelf.setResizable(false);
	        mySelf.addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent e) {
	            	System.out.println("Quitting the application.");
	            }
	        });
	        mySelf.pack();
	        mySelf.setVisible(true);
	        controller.addPropertyChangeListener(mySelf);//Main listens to controller	        
        }catch(Exception ex) {
            System.out.println("The application could not run.");
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
    
    private void setLookAndFeel(PropertyChangeEvent evt) {
		String c = evt.getPropertyName();
		if (c.equals(Constants.ACTION_COMMAND_GRAPHITE)) {
			try{
	            UIManager.setLookAndFeel(new GraphiteLookAndFeel());
	        }catch(UnsupportedLookAndFeelException ulafe){
	            System.out.println("JTattoo Graphite failed to set");
	        }
		}
		if (c.equals(Constants.ACTION_COMMAND_BERNSTEIN)) {
			try{
	            UIManager.setLookAndFeel(new BernsteinLookAndFeel());
	        }catch(UnsupportedLookAndFeelException ulafe){
	            System.out.println("JTattoo Bernstein failed to set");
	        }
		}
		if (c.equals(Constants.ACTION_COMMAND_FAST)) {
			try{
	            UIManager.setLookAndFeel(new FastLookAndFeel());
	        }catch(UnsupportedLookAndFeelException ulafe){
	            System.out.println("JTattoo Fast failed to set");
	        }
		}
		if (c.equals(Constants.ACTION_COMMAND_HIFI)) {
			try{
	            UIManager.setLookAndFeel(new HiFiLookAndFeel());
	        }catch(UnsupportedLookAndFeelException ulafe){
	            System.out.println("JTattoo HiFi failed to set");
	        }
		}
		if (c.equals(Constants.ACTION_COMMAND_LUNA)) {
			try{
	            UIManager.setLookAndFeel(new LunaLookAndFeel());
	        }catch(UnsupportedLookAndFeelException ulafe){
	            System.out.println("JTattoo Luna failed to set");
	        }
		}
		SwingUtilities.updateComponentTreeUI(mySelf);
		this.revalidate();
		this.repaint();
	}
    
    public static void rePack() {
    	mySelf.pack();
    }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {		
		setLookAndFeel(evt);
	}

}
