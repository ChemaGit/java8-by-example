package com.nacher.calc.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.nacher.calc.Main;
import com.nacher.calc.controller.Controller;

import net.miginfocom.swing.MigLayout;


/**
 * 
 * @author chema && Sergio
 * This Panel contains buttons and textbox to perform the calculator actions
 */
public class PanelCalculator extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = -8377215712645516042L;
    
    private PanelNumbers panelNumbers;
    private PanelScreen panelScreen;
    private PanelOptions panelOptions;
    private PanelScientific panelScientific;
    
    public Controller controller;

	public PanelCalculator(Controller controller) {
		this.controller = controller;	
		this.setLayout(new MigLayout("wrap"));
		//Initialize JTattoo Library    	
        try{
            UIManager.setLookAndFeel(new GraphiteLookAndFeel());
        }catch(UnsupportedLookAndFeelException ulafe){
            System.out.println("JTattoo Graphite failed to set");
        }
		
		buildComponents();		
		situateComponents();
		addPropertyChangeListeners();
		
	}
	
	private void buildComponents(){
		controller.setCalculatorMode(Constants.SET_CALC_STANDARD);
		this.removeAll();
		this.setPreferredSize(new Dimension(210, 280));
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelOptions = new PanelOptions(Constants.SET_CALC_STANDARD);
		panelOptions.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelOptions.setPreferredSize(new Dimension(200, 50));
		
		panelScreen = new PanelScreen();
		panelScreen.setBorder(BorderFactory.createEtchedBorder());
		panelScreen.setPreferredSize(new Dimension(200, 40));
		panelScreen.setBackground(new Color(255, 255, 255));
		
		panelNumbers = new PanelNumbers();
		panelNumbers.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelNumbers.setPreferredSize(new Dimension(200, 185));
		
	}
	
	private void situateComponents(){
		this.add(panelOptions, "span");
		this.add(panelScreen, "span");
		this.add(panelNumbers, "span");
	}
	
	private void addPropertyChangeListeners() {
		panelOptions.addPropertyChangeListener(panelScreen);//panelScreen escucha a panelOptions
		panelNumbers.addPropertyChangeListener(panelScreen);//panelScreen escucha a panelNumbers
		controller.addPropertyChangeListener(panelScreen);//panelScreen escucha a controller
		
		panelOptions.addPropertyChangeListener(controller);//controller escucha a panelOptions
		panelNumbers.addPropertyChangeListener(controller);//controller escucha a panelNumbers
		panelScreen.addPropertyChangeListener(controller);//controller escucha a panelScreen
		
		controller.addPropertyChangeListener(this);//PanelCalculator escucha a controller
		
	}
	
	private void removePropertyChangeListeners() {
		panelOptions.removeListeners();
		panelNumbers.removeListeners();
		panelScreen.removeListeners();
		
		controller.removePropertyChangeListener(panelScreen);
		controller.removePropertyChangeListener(this);			
		
	}
	
	/**
	 * To build the Scientific Calculator
	 */
	private void buildScientific() {
		//Instantiate the panelScientific
		controller.setCalculatorMode(Constants.SET_CALC_SCIENTIFIC);
		this.removeAll();
		this.setPreferredSize(new Dimension(400, 300));
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelOptions = new PanelOptions(Constants.SET_CALC_SCIENTIFIC);
		panelOptions.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		panelScreen = new PanelScreen();
		panelScreen.setBorder(BorderFactory.createEtchedBorder());
		panelScreen.setPreferredSize(new Dimension(400, 40));
		panelScreen.setBackground(new Color(255, 255, 255));
		
		panelScientific = new PanelScientific();
		panelScientific.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelScientific.setPreferredSize(new Dimension(400, 185));
		
	}
	
	private void situateScientific() {
		this.add(panelOptions, "span");
		this.add(panelScreen, "span");
		this.add(panelScientific, "span");
		
	}
	
	private void addPropertyChangeScientific() {
		panelOptions.addPropertyChangeListener(panelScreen);//panelScreen escucha a panelOptions
		panelScientific.addPropertyChangeListener(panelScreen);//panelScreen escucha a panelScientific
		controller.addPropertyChangeListener(panelScreen);//panelScreen escucha a controller
		
		panelOptions.addPropertyChangeListener(controller);//controller escucha a panelOptions
		panelScientific.addPropertyChangeListener(controller);//controller escucha a panelScientific
		panelScreen.addPropertyChangeListener(controller);//controller escucha a panelScreen
		
		controller.addPropertyChangeListener(this);//PanelCalculator escucha a controller
		
	}
	
	private void removePropertyChangeScientific() {
		panelOptions.removeListeners();
		panelScientific.removeListeners();
		panelScreen.removeListeners();
		
		controller.removePropertyChangeListener(panelScreen);
		controller.removePropertyChangeListener(this);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String c = evt.getPropertyName();		
		if (c.equals(Constants.SET_CALC_SCIENTIFIC)) {
			System.out.println("Set the Scientific Calculator");
			removePropertyChangeListeners();
			buildScientific();
			situateScientific();
			addPropertyChangeScientific();
			
		}
		if (c.equals(Constants.SET_CALC_STANDARD)) {
			System.out.println("Set the Standard Calculator");
			removePropertyChangeScientific();
			buildComponents();
			situateComponents();
			addPropertyChangeListeners();
			
		}
		this.repaint();
		this.revalidate();
		Main.rePack();
	}

}
