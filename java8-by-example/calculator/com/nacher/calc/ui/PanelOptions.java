package com.nacher.calc.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import net.miginfocom.swing.MigLayout;

public class PanelOptions extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3248250552026167520L;
	
	private String calculatorMode = Constants.SET_CALC_STANDARD;
	
	private JMenuBar menuBar;
	
	private JMenu menuVer;
	
	private ButtonGroup groupRadioCalcClass;
	private JRadioButtonMenuItem rbStandard;
	private JRadioButtonMenuItem rbScientific;
	
	private ButtonGroup groupRadioExtraCalc;
	private JRadioButtonMenuItem rbBasic;
	private JRadioButtonMenuItem rbExam;
	private JRadioButtonMenuItem rbDates;
	private JRadioButtonMenuItem rbConvert;
	
	
	private JMenu menuEdicion;
	
	private JMenuItem jmItemCopy;
	private JMenuItem jmItemPaste;
	private JMenu menuColor;
	private JMenuItem jmItemScrColor;
	private JMenuItem jmItemNumColor;
	private JMenu menuLook;
	private JMenuItem jmItemGraphite;
	private JMenuItem jmItemBernstein;
	private JMenuItem jmItemFast;
	private JMenuItem jmItemHiFi;
	private JMenuItem jmItemLuna;
	
	private JMenu menuAyuda;
	
	private JMenuItem jmItemHelp;
	private JMenuItem jmItemAbout;
	
	public PanelOptions(String calculatorMode) {	
		this.setLayout(new MigLayout());
		this.calculatorMode = calculatorMode;
		buildComponents();		
		situateComponents();		
		
	}
	
	private void buildComponents() {
		menuBar = new JMenuBar();
		
		menuVer = new JMenu("Ver");
		menuVer.setMnemonic(KeyEvent.VK_V);
		rbStandard = new JRadioButtonMenuItem("Estándar");
		rbStandard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		rbStandard.setMnemonic(KeyEvent.VK_S);
		rbStandard.setActionCommand(Constants.SET_CALC_STANDARD);
		rbStandard.addActionListener(this);		
		rbScientific = new JRadioButtonMenuItem("Científica");
		rbScientific.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		rbScientific.setMnemonic(KeyEvent.VK_C);
		rbScientific.setActionCommand(Constants.SET_CALC_SCIENTIFIC);
		rbScientific.addActionListener(this);
		
		if(calculatorMode.equals(Constants.SET_CALC_STANDARD)) {
			rbStandard.setSelected(true);
		} else {
			rbScientific.setSelected(true);			
		}
		groupRadioCalcClass = new ButtonGroup();
		groupRadioCalcClass.add(rbScientific);
		groupRadioCalcClass.add(rbStandard);			
		
		
		rbBasic = new JRadioButtonMenuItem("Básicas");
		rbBasic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
		rbBasic.setMnemonic(KeyEvent.VK_B);
		rbBasic.setActionCommand(Constants.SET_CALC_BASIC);
		rbBasic.addActionListener(this);
		rbBasic.setSelected(true);
		rbConvert = new JRadioButtonMenuItem("Conversión de Unidades");
		rbConvert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		rbConvert.setMnemonic(KeyEvent.VK_V);
		rbConvert.setActionCommand(Constants.SET_CALC_CONV_UNIT);
		rbConvert.addActionListener(this);
		rbExam = new JRadioButtonMenuItem("Examen Belén");
		rbExam.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		rbExam.setMnemonic(KeyEvent.VK_X);
		rbExam.setActionCommand(Constants.SET_CALC_EXAM_BELEN);
		rbExam.addActionListener(this);
		rbDates = new JRadioButtonMenuItem("Cálculo de Fechas");
		rbDates.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		rbDates.setMnemonic(KeyEvent.VK_D);
		rbDates.setActionCommand(Constants.SET_CALC_DATES);
		rbDates.addActionListener(this);
		groupRadioExtraCalc = new ButtonGroup();
		groupRadioExtraCalc.add(rbBasic);
		groupRadioExtraCalc.add(rbConvert);
		groupRadioExtraCalc.add(rbExam);
		groupRadioExtraCalc.add(rbDates);
		
		menuEdicion = new JMenu("Edición");
		menuEdicion.setMnemonic(KeyEvent.VK_E);
		jmItemCopy = new JMenuItem("Copiar");
		jmItemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		jmItemCopy.setMnemonic(KeyEvent.VK_O);
		jmItemCopy.setActionCommand(Constants.ACTION_COMMAND_COPY);
		jmItemCopy.addActionListener(this);
		jmItemPaste = new JMenuItem("Pegar");
		jmItemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		jmItemPaste.setMnemonic(KeyEvent.VK_P);
		jmItemPaste.setActionCommand(Constants.ACTION_COMMAND_PASTE);
		jmItemPaste.addActionListener(this);
		menuColor = new JMenu("Color");
		menuColor.setMnemonic(KeyEvent.VK_R);
		jmItemScrColor = new JMenuItem("Pantalla");
		jmItemScrColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		jmItemScrColor.setMnemonic(KeyEvent.VK_A);
		jmItemScrColor.setActionCommand(Constants.ACTION_COMMAND_SCRCOL);
		jmItemScrColor.addActionListener(this);
		jmItemNumColor = new JMenuItem("Números");
		jmItemNumColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		jmItemNumColor.setMnemonic(KeyEvent.VK_N);
		jmItemNumColor.setActionCommand(Constants.ACTION_COMMAND_NUMCOL);
		jmItemNumColor.addActionListener(this);
		menuLook = new JMenu("Look and Feel");
		menuLook.setMnemonic(KeyEvent.VK_K);
		jmItemGraphite = new JMenuItem("Graphite");
		jmItemGraphite.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		jmItemGraphite.setMnemonic(KeyEvent.VK_G);
		jmItemGraphite.setActionCommand(Constants.ACTION_COMMAND_GRAPHITE);
		jmItemGraphite.addActionListener(this);
		jmItemGraphite.setSelected(true);
		jmItemBernstein = new JMenuItem("Bernstein");
		jmItemBernstein.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		jmItemBernstein.setMnemonic(KeyEvent.VK_T);
		jmItemBernstein.setActionCommand(Constants.ACTION_COMMAND_BERNSTEIN);
		jmItemBernstein.addActionListener(this);
		jmItemFast = new JMenuItem("Fast");
		jmItemFast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		jmItemFast.setMnemonic(KeyEvent.VK_F);
		jmItemFast.setActionCommand(Constants.ACTION_COMMAND_FAST);
		jmItemFast.addActionListener(this);
		jmItemHiFi = new JMenuItem("HiFi");
		jmItemHiFi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		jmItemHiFi.setMnemonic(KeyEvent.VK_H);
		jmItemHiFi.setActionCommand(Constants.ACTION_COMMAND_HIFI);
		jmItemHiFi.addActionListener(this);
		jmItemLuna = new JMenuItem("Luna");
		jmItemLuna.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		jmItemLuna.setMnemonic(KeyEvent.VK_L);
		jmItemLuna.setActionCommand(Constants.ACTION_COMMAND_LUNA);
		jmItemLuna.addActionListener(this);
		
		menuAyuda = new JMenu("Ayuda");
		menuAyuda.setMnemonic(KeyEvent.VK_U);
		jmItemHelp = new JMenuItem("Ver la Ayuda");
		jmItemHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		jmItemHelp.setMnemonic(KeyEvent.VK_V);
		jmItemHelp.setActionCommand(Constants.ACTION_COMMAND_HELP);
		jmItemHelp.addActionListener(this);
		jmItemAbout = new JMenuItem("Acerca de la Calculadora");
		jmItemAbout.setMnemonic(KeyEvent.VK_A);
		jmItemAbout.setActionCommand(Constants.ACTION_COMMAND_ABOUT);
		jmItemAbout.addActionListener(this);
	}
	
	private void situateComponents() {
		menuVer.add(rbStandard);
		menuVer.add(rbScientific);
		menuVer.addSeparator();
		menuVer.add(rbBasic);
		menuVer.add(rbExam);
		menuVer.add(rbDates);
		menuVer.add(rbConvert);
		
		menuEdicion.add(jmItemCopy);
		menuEdicion.add(jmItemPaste);
		menuEdicion.addSeparator();
		menuEdicion.add(menuColor);
		menuEdicion.addSeparator();
		menuEdicion.add(menuLook);
		
		menuColor.add(jmItemScrColor);
		menuColor.add(jmItemNumColor);
		
		menuLook.add(jmItemGraphite);
		menuLook.add(jmItemBernstein);
		menuLook.add(jmItemFast);
		menuLook.add(jmItemHiFi);
		menuLook.add(jmItemLuna);
		
		menuAyuda.add(jmItemHelp);
		menuAyuda.addSeparator();
		menuAyuda.add(jmItemAbout);
		
		menuBar.add(menuVer);
		menuBar.add(menuEdicion);
		menuBar.add(menuAyuda);
		this.add(menuBar, "span, pushx, growx, pushy, growy");
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		String com = e.getActionCommand();
		if(com.equals(Constants.SET_CALC_SCIENTIFIC)) {			
			this.firePropertyChange(Constants.SET_CALC_SCIENTIFIC, null, null);
		} else if(com.equals(Constants.SET_CALC_STANDARD)) {
			this.firePropertyChange(Constants.SET_CALC_STANDARD, null, null);
		} else if(com.equals(Constants.SET_CALC_BASIC)) {
			System.out.println("I am Basic Calculator");
		} else if(com.equals(Constants.SET_CALC_CONV_UNIT)) {
			System.out.println("I am Unit Converter Calculator");
		} else if(com.equals(Constants.SET_CALC_DATES)) {
			System.out.println("I am Dates Calculator");
		} else if(com.equals(Constants.SET_CALC_EXAM_BELEN)) {
			System.out.println("I am Exam Belen Calculator");
		} else if(com.equals(Constants.ACTION_COMMAND_COPY)) {
			System.out.println("Copying Current Textbox Contents");
		} else if(com.equals(Constants.ACTION_COMMAND_PASTE)) {
			System.out.println("Pasting Clipboard Contents into the Textbox");
		} else if(com.equals(Constants.ACTION_COMMAND_SCRCOL)) {
			Color c = JColorChooser.showDialog(this,"Choose Color", null);			
			this.firePropertyChange(com, null, c);
		} else if(com.equals(Constants.ACTION_COMMAND_NUMCOL)) {
			Color c = JColorChooser.showDialog(this,"Choose Color", null);			
			this.firePropertyChange(com, null, c);
		} else if(com.equals(Constants.ACTION_COMMAND_GRAPHITE)) {
			this.firePropertyChange(com, null, true);
		} else if(com.equals(Constants.ACTION_COMMAND_BERNSTEIN)) {
			this.firePropertyChange(com, null, true);
		} else if(com.equals(Constants.ACTION_COMMAND_FAST)) {
			this.firePropertyChange(com, null, true);
		} else if(com.equals(Constants.ACTION_COMMAND_HIFI)) {
			this.firePropertyChange(com, null, true);
		} else if(com.equals(Constants.ACTION_COMMAND_LUNA)) {
			this.firePropertyChange(com, null, true);
		} else if(com.equals(Constants.ACTION_COMMAND_HELP)) {
			System.out.println("Help! I need somebody!");
		} else if(com.equals(Constants.ACTION_COMMAND_ABOUT)) {
			System.out.println("This calculator was made by the Nacher brothers, the best coders in the universe!");
		}
		
	}
	
	public void removeListeners() {
		PropertyChangeListener listeners[] = this.getPropertyChangeListeners();

		if(listeners != null && listeners.length > 0) {
			for(int i = 0;i < listeners.length;i++){
				this.removePropertyChangeListener(listeners[i]);
			}
		}
	}

}
