package com.nacher.calc.ui;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PanelNumbers extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8338113083603013816L;
	
	// Row One
	JButton btnBck;
	JButton btnCE;
	JButton btnC;
	JButton btnSign;
	JButton btnSqrt;

	// Row Two
	JButton btnSeven;
	JButton btnEight;
	JButton btnNine;
	JButton btnDiv;
	JButton btnPercent;

	// Row Three
	JButton btnFour;
	JButton btnFive;
	JButton btnSix;
	JButton btnMult;
	JButton btnFrac;

	// Row Four
	JButton btnOne;
	JButton btnTwo;
	JButton btnThree;
	JButton btnMinus;
	JButton btnEquals;

	// Row Five
	JButton btnZero;
	JButton btnComma;
	JButton btnPlus;
	
	Font buttonFont = new Font ("Times New Roman", Font.BOLD, 12);
	Font buttonFontMin = new Font ("Times New Roman", Font.BOLD, 10);

	public PanelNumbers() {
		this.setLayout(new MigLayout());

		this.buildComponents();
		this.situateComponents();
	}

	private void buildComponents() {
		// Row One
		//btnBck = new JButton("\u232B");
		btnBck = new JButton("<html>\u2b05</html>");
		btnBck.setMargin(new Insets(1,1,1,1));
		btnBck.setFont(buttonFont);
		btnBck.setActionCommand(Constants.ACTION_COMMAND_BACK);
		btnBck.addActionListener(this);
		btnCE = new JButton("CE");
		btnCE.setMargin(new Insets(1,1,1,1));
		btnCE.setFont(buttonFont);
		btnCE.setActionCommand(Constants.ACTION_COMMAND_CE);
		btnCE.addActionListener(this);
		btnC = new JButton(" C ");
		btnC.setMargin(new Insets(1,1,1,1));
		btnC.setFont(buttonFont);
		btnC.setActionCommand(Constants.ACTION_COMMAND_CLEAR);
		btnC.addActionListener(this);
		btnSign = new JButton(" \u00B1 ");
		btnSign.setMargin(new Insets(1,1,1,1));
		btnSign.setFont(buttonFont);
		btnSign.setActionCommand(Constants.ACTION_COMMAND_SIGN);
		btnSign.addActionListener(this);
		btnSqrt = new JButton("\u221A");
		btnSqrt.setMargin(new Insets(1,1,1,1));
		btnSqrt.setFont(buttonFont);
		btnSqrt.setActionCommand(Constants.ACTION_COMMAND_SQRT);
		btnSqrt.addActionListener(this);

		// Row Two
		btnSeven = new JButton("7");
		btnSeven.setMargin(new Insets(1,1,1,1));
		btnSeven.setFont(buttonFont);
		btnSeven.setActionCommand(Constants.ACTION_COMMAND_SEVEN);
		btnSeven.addActionListener(this);
		btnEight = new JButton("8");
		btnEight.setMargin(new Insets(1,1,1,1));
		btnEight.setFont(buttonFont);
		btnEight.setActionCommand(Constants.ACTION_COMMAND_EIGHT);
		btnEight.addActionListener(this);
		btnNine = new JButton("9");
		btnNine.setMargin(new Insets(1,1,1,1));
		btnNine.setFont(buttonFont);
		btnNine.setActionCommand(Constants.ACTION_COMMAND_NINE);
		btnNine.addActionListener(this);
		btnDiv = new JButton("/");
		btnDiv.setMargin(new Insets(1,1,1,1));
		btnDiv.setFont(buttonFont);
		btnDiv.setActionCommand(Constants.ACTION_COMMAND_DIV);
		btnDiv.addActionListener(this);
		btnPercent = new JButton("%");
		btnPercent.setMargin(new Insets(1,1,1,1));
		btnPercent.setFont(buttonFont);
		btnPercent.setActionCommand(Constants.ACTION_COMMAND_PERCENT);
		btnPercent.addActionListener(this);

		// Row Three
		btnFour = new JButton("4");
		btnFour.setMargin(new Insets(1,1,1,1));
		btnFour.setFont(buttonFont);
		btnFour.setActionCommand(Constants.ACTION_COMMAND_FOUR);
		btnFour.addActionListener(this);
		btnFive = new JButton("5");
		btnFive.setMargin(new Insets(1,1,1,1));
		btnFive.setFont(buttonFont);
		btnFive.setActionCommand(Constants.ACTION_COMMAND_FIVE);
		btnFive.addActionListener(this);
		btnSix = new JButton("6");
		btnSix.setMargin(new Insets(1,1,1,1));
		btnSix.setFont(buttonFont);
		btnSix.setActionCommand(Constants.ACTION_COMMAND_SIX);
		btnSix.addActionListener(this);
		btnMult = new JButton("*");
		btnMult.setMargin(new Insets(1,1,1,1));
		btnMult.setFont(buttonFont);
		btnMult.setActionCommand(Constants.ACTION_COMMAND_MULT);
		btnMult.addActionListener(this);
		btnFrac = new JButton("1/x");
		btnFrac.setMargin(new Insets(1,1,1,1));
		btnFrac.setFont(buttonFont);
		btnFrac.setActionCommand(Constants.ACTION_COMMAND_FRAC);
		btnFrac.addActionListener(this);

		// Row Four
		btnOne = new JButton("1");
		btnOne.setMargin(new Insets(1,1,1,1));
		btnOne.setFont(buttonFont);
		btnOne.setActionCommand(Constants.ACTION_COMMAND_ONE);
		btnOne.addActionListener(this);
		btnTwo = new JButton("2");
		btnTwo.setMargin(new Insets(1,1,1,1));
		btnTwo.setFont(buttonFont);
		btnTwo.setActionCommand(Constants.ACTION_COMMAND_TWO);
		btnTwo.addActionListener(this);
		btnThree = new JButton("3");
		btnThree.setMargin(new Insets(1,1,1,1));
		btnThree.setFont(buttonFont);
		btnThree.setActionCommand(Constants.ACTION_COMMAND_THREE);
		btnThree.addActionListener(this);
		btnMinus = new JButton("-");
		btnMinus.setMargin(new Insets(1,1,1,1));
		btnMinus.setFont(buttonFont);
		btnMinus.setActionCommand(Constants.ACTION_COMMAND_MINUS);
		btnMinus.addActionListener(this);
		btnEquals = new JButton("=");
		btnEquals.setMargin(new Insets(1,1,1,1));
		btnEquals.setFont(buttonFont);
		btnEquals.setActionCommand(Constants.ACTION_COMMAND_EQUALS);
		btnEquals.addActionListener(this);

		// Row Five
		btnZero = new JButton("0");
		btnZero.setMargin(new Insets(1,1,1,1));
		btnZero.setFont(buttonFont);
		btnZero.setActionCommand(Constants.ACTION_COMMAND_ZERO);
		btnZero.addActionListener(this);
		btnComma = new JButton(",");
		btnComma.setMargin(new Insets(1,1,1,1));
		btnComma.setFont(buttonFont);
		btnComma.setActionCommand(Constants.ACTION_COMMAND_COMMA);
		btnComma.addActionListener(this);
		btnPlus = new JButton("+");
		btnPlus.setMargin(new Insets(1,1,1,1));
		btnPlus.setFont(buttonFont);
		btnPlus.setActionCommand(Constants.ACTION_COMMAND_PLUS);
		btnPlus.addActionListener(this);
		
	}

	private void situateComponents() {
		// Row One
		this.add(btnBck, "pushx, growx, pushy, growy");
		this.add(btnCE, "pushx, growx, pushy, growy");
		this.add(btnC, "pushx, growx, pushy, growy");
		this.add(btnSign, "pushx, growx, pushy, growy");
		this.add(btnSqrt, "pushx, growx, pushy, growy, wrap");

		// Row Two
		this.add(btnSeven, "pushx, growx, pushy, growy");
		this.add(btnEight, "pushx, growx, pushy, growy");
		this.add(btnNine, "pushx, growx, pushy, growy");
		this.add(btnDiv, "pushx, growx, pushy, growy");
		this.add(btnPercent, "pushx, growx, pushy, growy, wrap");

		// Row Three
		this.add(btnFour, "pushx, growx, pushy, growy");
		this.add(btnFive, "pushx, growx, pushy, growy");
		this.add(btnSix, "pushx, growx, pushy, growy");
		this.add(btnMult, "pushx, growx, pushy, growy");
		this.add(btnFrac, "pushx, growx, pushy, growy, wrap");

		// Row Four
		this.add(btnOne, "pushx, growx, pushy, growy");
		this.add(btnTwo, "pushx, growx, pushy, growy");
		this.add(btnThree, "pushx, growx, pushy, growy");
		this.add(btnMinus, "pushx, growx, pushy, growy");
		this.add(btnEquals, "span 1 2, pushx, growx, pushy, growy, wrap");

		// Row Five
		this.add(btnZero, "span 2, pushx, growx, pushy, growy");
		this.add(btnComma, "pushx, growx, pushy, growy");
		this.add(btnPlus, "pushx, growx, pushy, growy");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object v = "";
		String c = e.getActionCommand();
		if(c.equals(Constants.ACTION_COMMAND_ONE)) {
			v = "1";			
		} else if(c.equals(Constants.ACTION_COMMAND_TWO)) {
			v = "2";
		} else if(c.equals(Constants.ACTION_COMMAND_THREE)) {
			v = "3";
		} else if(c.equals(Constants.ACTION_COMMAND_FOUR)) {
			v = "4";
		} else if(c.equals(Constants.ACTION_COMMAND_FIVE)) {
			v = "5";
		} else if(c.equals(Constants.ACTION_COMMAND_SIX)) {
			v = "6";
		} else if(c.equals(Constants.ACTION_COMMAND_SEVEN)) {
			v = "7";
		} else if(c.equals(Constants.ACTION_COMMAND_EIGHT)) {
			v = "8";
		} else if(c.equals(Constants.ACTION_COMMAND_NINE)) {
			v = "9";
		} else if(c.equals(Constants.ACTION_COMMAND_ZERO)) {
			v = "0";
		} else if(c.equals(Constants.ACTION_COMMAND_BACK)) {
			v = new Boolean(true);
		} else if(c.equals(Constants.ACTION_COMMAND_CLEAR)) {
			v = new Boolean(true);
		} else if(c.equals(Constants.ACTION_COMMAND_CE)) {
			v = new Boolean(true);
		} else if(c.equals(Constants.ACTION_COMMAND_PLUS)) {
			v = "+";
		} else if(c.equals(Constants.ACTION_COMMAND_MINUS)) {
			v = "-";
		} else if(c.equals(Constants.ACTION_COMMAND_MULT)) {
			v = "*";
		} else if(c.equals(Constants.ACTION_COMMAND_DIV)) {
			v = "/";
		} else if(c.equals(Constants.ACTION_COMMAND_SQRT)) {
			v = "sqrt";
		} else if(c.equals(Constants.ACTION_COMMAND_PERCENT)) {
			v = new Boolean(true);
		} else if(c.equals(Constants.ACTION_COMMAND_FRAC)) {
			v = new Boolean(true);
		} else if(c.equals(Constants.ACTION_COMMAND_SIGN)) {
			v = "-";
		} else if(c.equals(Constants.ACTION_COMMAND_COMMA)) {
			v = ",";
		} else if(c.equals(Constants.ACTION_COMMAND_EQUALS)) {
			v = "=";
		} 
		this.firePropertyChange(c, null, v);
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
