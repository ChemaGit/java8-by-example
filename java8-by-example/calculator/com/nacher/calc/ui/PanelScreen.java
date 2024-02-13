package com.nacher.calc.ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.nacher.calc.controller.Controller;

import net.miginfocom.swing.MigLayout;

public class PanelScreen extends JPanel implements PropertyChangeListener, KeyListener {
	
	private static final long serialVersionUID = -3191311346001142380L;
	
	private JTextField textOper;
	
	private JTextField textNumber;

	Font numberFont = new Font ("Times New Roman", Font.BOLD, 20);
	Font numberSmall = new Font ("Times New Roman", Font.BOLD, 16);
	Font operFont = new Font ("Times New Roman", Font.PLAIN, 11);
	
	public PanelScreen() {
		
		this.setLayout(new MigLayout());
	
		buildComponents();
		situateComponents();
	}
	
	private void buildComponents() {
		textOper = new JTextField();
		textOper.setBorder(new EmptyBorder(0, 0, 0, 0));
		textOper.setBackground(new Color(255, 255, 255));
		textOper.setMargin(new Insets(1,1,1,1));
		textOper.setFont(operFont);
		textOper.setEditable(false);		
		textOper.setHorizontalAlignment(JTextField.RIGHT);
		textOper.addKeyListener(this);
		
		textNumber = new JTextField();
		textNumber.setBorder(new EmptyBorder(0, 0, 0, 0));
		textNumber.setBackground(new Color(255, 255, 255));
		textNumber.setMargin(new Insets(1,1,1,1));
		textNumber.setFont(numberFont);
		textNumber.setEditable(false);
		textNumber.setHorizontalAlignment(JTextField.RIGHT);
		textNumber.setText("0");
		textNumber.addKeyListener(this);
		
	}
	
	private void situateComponents() {
		this.add(textOper, "span, pushx, growx");
		this.add(textNumber, "span, pushx, growx");
	}

	@Override
	/**
	 * It works First
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	/**
	 * It works Second
	 */
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		String cad = String.valueOf(c);
		buildEvent(cad);
		System.out.println(cad);
	}

	@Override
	/**
	 * It works Last
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {		
		String c = evt.getPropertyName();
		Object value = evt.getNewValue();
		if(c.equals(Constants.ACTION_COMMAND_SCRCOL) || c.equals(Constants.ACTION_COMMAND_NUMCOL)) {
			changeColor(evt);
		}
		
		if(c.equals(Constants.WRITE_NUMBER)) {
			if (value.equals("")) {
				textNumber.setFont(numberFont);
				textNumber.setText("0");
			} else {
				if(value.toString().length() >= 16) {
					textNumber.setFont(numberSmall);
				} else {
					textNumber.setFont(numberFont);
				}
				textNumber.setText(value.toString());
			}
		}
		
		if(c.equals(Constants.WRITE_NUMBER_SCIENTIFIC)) {
			if (value.equals("")) {
				textNumber.setFont(numberFont);
				textNumber.setText("0");
			} else {
				if(value.toString().length() >= 32) {
					textNumber.setFont(numberSmall);
				} else {
					textNumber.setFont(numberFont);
				}
				textNumber.setText(value.toString());
			}
		}
		
		if(c.equals(Constants.WRITE_OPERATION)) {
			textOper.setText(value.toString());			
		}
		
		this.textNumber.requestFocusInWindow();
	}
	
	private void changeColor(PropertyChangeEvent evt) {
		Color c = (Color)evt.getNewValue();
		if (evt.getPropertyName().equalsIgnoreCase(Constants.ACTION_COMMAND_SCRCOL)) {
			this.textNumber.setBackground(c);
			this.textOper.setBackground(c);
			this.setBackground(c);
		} else {
			this.textNumber.setForeground(c);
			this.textOper.setForeground(c);
		}
		SwingUtilities.updateComponentTreeUI(textNumber);
		SwingUtilities.updateComponentTreeUI(textOper);
	}
	
	public void buildEvent(String c) {
		String command = "";
		Object oldValue = null;
		Object newValue = c;
		String source = "";
		switch(c) {
			case Constants.NUMBER_ZERO :
				command = Constants.ACTION_COMMAND_ZERO;
				source = Constants.NUMBER;
				break;
			case Constants.NUMBER_ONE :
				command = Constants.ACTION_COMMAND_ONE;
				source = Constants.NUMBER;
				break;
			case Constants.NUMBER_TWO :
				command = Constants.ACTION_COMMAND_TWO;
				source = Constants.NUMBER;
				break;
			case Constants.NUMBER_THREE :
				command = Constants.ACTION_COMMAND_THREE;
				source = Constants.NUMBER;
				break;
			case Constants.NUMBER_FOUR :
				command = Constants.ACTION_COMMAND_FOUR;
				source = Constants.NUMBER;
				break;
			case Constants.NUMBER_FIVE :
				command = Constants.ACTION_COMMAND_FIVE;
				source = Constants.NUMBER;
				break;
			case Constants.NUMBER_SIX :
				command = Constants.ACTION_COMMAND_SIX;
				source = Constants.NUMBER;
				break;
			case Constants.NUMBER_SEVEN :
				command = Constants.ACTION_COMMAND_SEVEN;
				source = Constants.NUMBER;
				break;
			case Constants.NUMBER_EIGHT :
				command = Constants.ACTION_COMMAND_EIGHT;
				source = Constants.NUMBER;
				break;
			case Constants.NUMBER_NINE :
				command = Constants.ACTION_COMMAND_NINE;
				source = Constants.NUMBER;
				break;
			case Constants.OPER_PLUS :
				break;
			case Constants.OPER_MINUS :
				break;
			case Constants.OPER_MULT :
				break;
			case Constants.OPER_DIV :
				break;
			case Constants.OPER_COMMA :
				command = Constants.ACTION_COMMAND_COMMA;
				source = Constants.NUMBER;				
				break;
			case Constants.OPER_EQUALS :
				break;
			case Constants.KEY_BCK :
				break;
			case Constants.KEY_SUPR :
				break;
			default :
				break;
		}
		if (source.equals(Constants.NUMBER) || source.equals(Constants.OPERATION)) {
			this.firePropertyChange(command, oldValue, newValue);
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
