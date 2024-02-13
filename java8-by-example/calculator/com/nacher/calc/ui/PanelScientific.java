package com.nacher.calc.ui;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import net.miginfocom.swing.MigLayout;

public class PanelScientific extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	// Row one
	JRadioButton rbSex;
	JRadioButton rbRad;
	JRadioButton rbCent;
	ButtonGroup groupRadioUnits;

	// Row two
	JButton btnBlank;
	JButton btnInv;
	JButton btnIn;
	JButton btnParL;
	JButton btnParR;
	JButton btnBck;
	JButton btnCE;
	JButton btnC;
	JButton btnSign;
	JButton btnSqrt;

	// Row three
	JButton btnInt;
	JButton btnSinh;
	JButton btnSin;
	JButton btnPotTwo;
	JButton btnFact;
	JButton btnSeven;
	JButton btnEight;
	JButton btnNine;
	JButton btnDiv;
	JButton btnPercent;

	// Row four
	JButton btnDms;
	JButton btnCosh;
	JButton btnCos;
	JButton btnPotN;
	JButton btnNRoot;
	JButton btnFour;
	JButton btnFive;
	JButton btnSix;
	JButton btnMult;
	JButton btnFrac;

	// Row five
	JButton btnPi;
	JButton btnTanh;
	JButton btnTan;
	JButton btnPotThree;
	JButton btnCubicRoot;
	JButton btnOne;
	JButton btnTwo;
	JButton btnThree;
	JButton btnMinus;
	JButton btnEquals;

	// Row six
	JButton btnF_E;
	JButton btnExp;
	JButton btnMod;
	JButton btnLog;
	JButton btnTenPotN;
	JButton btnZero;
	JButton btnComma;
	JButton btnPlus;

	Font buttonFont = new Font("Times New Roman", Font.BOLD, 12);
	Font buttonFontMin = new Font("Times New Roman", Font.BOLD, 10);

	public PanelScientific() {
		this.setLayout(new MigLayout());

		this.buildComponents();
		this.situateComponents();
	}

	private void buildComponents() {
		// Row one
		rbSex = new JRadioButton("Sexages.");
		rbSex.setActionCommand(Constants.ACTION_COMMAND_SEX);
		rbSex.addActionListener(this);
		rbSex.setSelected(true);
		rbSex.setFont(buttonFont);

		rbRad = new JRadioButton("Radianes.");
		rbRad.setActionCommand(Constants.ACTION_COMMAND_RAD);
		rbRad.addActionListener(this);
		rbRad.setFont(buttonFont);

		rbCent = new JRadioButton("Cent.");
		rbCent.setActionCommand(Constants.ACTION_COMMAND_CENT);
		rbCent.addActionListener(this);
		rbCent.setFont(buttonFont);

		groupRadioUnits = new ButtonGroup();
		groupRadioUnits.add(rbSex);
		groupRadioUnits.add(rbRad);
		groupRadioUnits.add(rbCent);

		// Row two
		btnBlank = new JButton("");
		btnBlank.setMargin(new Insets(1, 1, 1, 1));
		btnBlank.setActionCommand("");
		btnBlank.addActionListener(this);
		btnBlank.setEnabled(false);

		btnIn = new JButton("In");
		btnIn.setMargin(new Insets(1, 1, 1, 1));
		btnIn.setActionCommand(Constants.ACTION_COMMAND_IN);
		btnIn.addActionListener(this);
		btnIn.setFont(buttonFont);

		btnInv = new JButton("Inv");
		btnInv.setMargin(new Insets(1, 1, 1, 1));
		btnInv.setActionCommand(Constants.ACTION_COMMAND_INV);
		btnInv.addActionListener(this);
		btnInv.setFont(buttonFont);

		btnParL = new JButton("(");
		btnParL.setMargin(new Insets(1, 1, 1, 1));
		btnParL.setActionCommand(Constants.ACTION_COMMAND_PARENT_R);
		btnParL.addActionListener(this);
		btnParL.setFont(buttonFont);

		btnParR = new JButton(")");
		btnParR.setMargin(new Insets(1, 1, 1, 1));
		btnParR.setActionCommand(Constants.ACTION_COMMAND_PARENT_R);
		btnParR.addActionListener(this);
		btnParR.setFont(buttonFont);

		btnBck = new JButton("<html>\u2b05</html>");
		btnBck.setMargin(new Insets(1, 1, 1, 1));
		btnBck.setFont(buttonFont);
		btnBck.setActionCommand(Constants.ACTION_COMMAND_BACK);
		btnBck.addActionListener(this);

		btnCE = new JButton("CE");
		btnCE.setMargin(new Insets(1, 1, 1, 1));
		btnCE.setFont(buttonFont);
		btnCE.setActionCommand(Constants.ACTION_COMMAND_CE);
		btnCE.addActionListener(this);

		btnC = new JButton(" C ");
		btnC.setMargin(new Insets(1, 1, 1, 1));
		btnC.setFont(buttonFont);
		btnC.setActionCommand(Constants.ACTION_COMMAND_CLEAR);
		btnC.addActionListener(this);

		btnSign = new JButton(" \u00B1 ");
		btnSign.setMargin(new Insets(1, 1, 1, 1));
		btnSign.setFont(buttonFont);
		btnSign.setActionCommand(Constants.ACTION_COMMAND_SIGN);
		btnSign.addActionListener(this);

		btnSqrt = new JButton("\u221A");
		btnSqrt.setMargin(new Insets(1, 1, 1, 1));
		btnSqrt.setFont(buttonFont);
		btnSqrt.setActionCommand(Constants.ACTION_COMMAND_SQRT);
		btnSqrt.addActionListener(this);

		// Row three
		btnInt = new JButton("Int");
		btnInt.setMargin(new Insets(1, 1, 1, 1));
		btnInt.setActionCommand(Constants.ACTION_COMMAND_INT);
		btnInt.addActionListener(this);
		btnInt.setFont(buttonFont);

		btnSinh = new JButton("sinh");
		btnSinh.setMargin(new Insets(1, 1, 1, 1));
		btnSinh.setActionCommand(Constants.ACTION_COMMAND_SINH);
		btnSinh.addActionListener(this);
		btnSinh.setFont(buttonFont);

		btnSin = new JButton("sin");
		btnSin.setMargin(new Insets(1, 1, 1, 1));
		btnSin.setActionCommand(Constants.ACTION_COMMAND_SIN);
		btnSin.addActionListener(this);
		btnSin.setFont(buttonFont);

		btnPotTwo = new JButton("<html>x&sup2</html>");
		btnPotTwo.setMargin(new Insets(1, 1, 1, 1));
		btnPotTwo.setActionCommand(Constants.ACTION_COMMAND_POT_TWO);
		btnPotTwo.addActionListener(this);
		btnPotTwo.setFont(buttonFont);

		btnFact = new JButton("n!");
		btnFact.setMargin(new Insets(1, 1, 1, 1));
		btnFact.setActionCommand(Constants.ACTION_COMMAND_FACTORIAL);
		btnFact.addActionListener(this);
		btnFact.setFont(buttonFont);

		btnSeven = new JButton("7");
		btnSeven.setMargin(new Insets(1, 1, 1, 1));
		btnSeven.setFont(buttonFont);
		btnSeven.setActionCommand(Constants.ACTION_COMMAND_SEVEN);
		btnSeven.addActionListener(this);

		btnEight = new JButton("8");
		btnEight.setMargin(new Insets(1, 1, 1, 1));
		btnEight.setFont(buttonFont);
		btnEight.setActionCommand(Constants.ACTION_COMMAND_EIGHT);
		btnEight.addActionListener(this);

		btnNine = new JButton("9");
		btnNine.setMargin(new Insets(1, 1, 1, 1));
		btnNine.setFont(buttonFont);
		btnNine.setActionCommand(Constants.ACTION_COMMAND_NINE);
		btnNine.addActionListener(this);

		btnDiv = new JButton("/");
		btnDiv.setMargin(new Insets(1, 1, 1, 1));
		btnDiv.setFont(buttonFont);
		btnDiv.setActionCommand(Constants.ACTION_COMMAND_DIV);
		btnDiv.addActionListener(this);

		btnPercent = new JButton("%");
		btnPercent.setMargin(new Insets(1, 1, 1, 1));
		btnPercent.setFont(buttonFont);
		btnPercent.setActionCommand(Constants.ACTION_COMMAND_PERCENT);
		btnPercent.addActionListener(this);

		// Row four
		btnDms = new JButton("dms");
		btnDms.setMargin(new Insets(1, 1, 1, 1));
		btnDms.setActionCommand(Constants.ACTION_COMMAND_DMS);
		btnDms.addActionListener(this);
		btnDms.setFont(buttonFont);

		btnCosh = new JButton("cosh");
		btnCosh.setMargin(new Insets(1, 1, 1, 1));
		btnCosh.setActionCommand(Constants.ACTION_COMMAND_COSH);
		btnCosh.addActionListener(this);
		btnCosh.setFont(buttonFont);

		btnCos = new JButton("cos");
		btnCos.setMargin(new Insets(1, 1, 1, 1));
		btnCos.setActionCommand(Constants.ACTION_COMMAND_COS);
		btnCos.addActionListener(this);
		btnCos.setFont(buttonFont);

		btnPotN = new JButton("<html>x<sup>y</sup></html>");
		btnPotN.setMargin(new Insets(1, 1, 1, 1));
		btnPotN.setActionCommand(Constants.ACTION_COMMAND_POTN);
		btnPotN.addActionListener(this);
		btnPotN.setFont(buttonFontMin);

		btnNRoot = new JButton("<html><sup>x</sup>&#8730y</html>");
		btnNRoot.setMargin(new Insets(1, 1, 1, 1));
		btnNRoot.setActionCommand(Constants.ACTION_COMMAND_NROOT);
		btnNRoot.addActionListener(this);
		btnNRoot.setFont(buttonFontMin);

		btnFour = new JButton("4");
		btnFour.setMargin(new Insets(1, 1, 1, 1));
		btnFour.setFont(buttonFont);
		btnFour.setActionCommand(Constants.ACTION_COMMAND_FOUR);
		btnFour.addActionListener(this);

		btnFive = new JButton("5");
		btnFive.setMargin(new Insets(1, 1, 1, 1));
		btnFive.setFont(buttonFont);
		btnFive.setActionCommand(Constants.ACTION_COMMAND_FIVE);
		btnFive.addActionListener(this);

		btnSix = new JButton("6");
		btnSix.setMargin(new Insets(1, 1, 1, 1));
		btnSix.setFont(buttonFont);
		btnSix.setActionCommand(Constants.ACTION_COMMAND_SIX);
		btnSix.addActionListener(this);

		btnMult = new JButton("*");
		btnMult.setMargin(new Insets(1, 1, 1, 1));
		btnMult.setFont(buttonFont);
		btnMult.setActionCommand(Constants.ACTION_COMMAND_MULT);
		btnMult.addActionListener(this);

		btnFrac = new JButton("1/x");
		btnFrac.setMargin(new Insets(1, 1, 1, 1));
		btnFrac.setFont(buttonFont);
		btnFrac.setActionCommand(Constants.ACTION_COMMAND_FRAC);
		btnFrac.addActionListener(this);

		// Row five
		btnPi = new JButton("<html>&nbsp;&pi;&nbsp;</html>");
		btnPi.setMargin(new Insets(1, 1, 1, 1));
		btnPi.setActionCommand(Constants.ACTION_COMMAND_PI);
		btnPi.addActionListener(this);
		btnPi.setFont(buttonFont);

		btnTanh = new JButton("tanh");
		btnTanh.setMargin(new Insets(1, 1, 1, 1));
		btnTanh.setActionCommand(Constants.ACTION_COMMAND_TANH);
		btnTanh.addActionListener(this);
		btnTanh.setFont(buttonFont);

		btnTan = new JButton("tan");
		btnTan.setMargin(new Insets(1, 1, 1, 1));
		btnTan.setActionCommand(Constants.ACTION_COMMAND_TAN);
		btnTan.addActionListener(this);
		btnTan.setFont(buttonFont);

		btnPotThree = new JButton("<html>x&#179</html>");
		btnPotThree.setMargin(new Insets(1, 1, 1, 1));
		btnPotThree.setActionCommand(Constants.ACTION_COMMAND_POWTHREE);
		btnPotThree.addActionListener(this);
		btnPotThree.setFont(buttonFont);

		btnCubicRoot = new JButton("<html>&#8731</html>");
		btnCubicRoot.setMargin(new Insets(1, 1, 1, 1));
		btnCubicRoot.setActionCommand(Constants.ACTION_COMMAND_CUBICROOT);
		btnCubicRoot.addActionListener(this);
		btnCubicRoot.setFont(buttonFont);

		btnOne = new JButton("1");
		btnOne.setMargin(new Insets(1, 1, 1, 1));
		btnOne.setFont(buttonFont);
		btnOne.setActionCommand(Constants.ACTION_COMMAND_ONE);
		btnOne.addActionListener(this);

		btnTwo = new JButton("2");
		btnTwo.setMargin(new Insets(1, 1, 1, 1));
		btnTwo.setFont(buttonFont);
		btnTwo.setActionCommand(Constants.ACTION_COMMAND_TWO);
		btnTwo.addActionListener(this);

		btnThree = new JButton("3");
		btnThree.setMargin(new Insets(1, 1, 1, 1));
		btnThree.setFont(buttonFont);
		btnThree.setActionCommand(Constants.ACTION_COMMAND_THREE);
		btnThree.addActionListener(this);

		btnMinus = new JButton("-");
		btnMinus.setMargin(new Insets(1, 1, 1, 1));
		btnMinus.setFont(buttonFont);
		btnMinus.setActionCommand(Constants.ACTION_COMMAND_MINUS);
		btnMinus.addActionListener(this);

		btnEquals = new JButton("=");
		btnEquals.setMargin(new Insets(1, 1, 1, 1));
		btnEquals.setFont(buttonFont);
		btnEquals.setActionCommand(Constants.ACTION_COMMAND_EQUALS);
		btnEquals.addActionListener(this);

		// Row six
		btnF_E = new JButton("F-E");
		btnF_E.setMargin(new Insets(1, 1, 1, 1));
		btnF_E.setActionCommand(Constants.ACTION_COMMAND_FE);
		btnF_E.addActionListener(this);
		btnF_E.setFont(buttonFont);

		btnExp = new JButton("Exp");
		btnExp.setMargin(new Insets(1, 1, 1, 1));
		btnExp.setActionCommand(Constants.ACTION_COMMAND_EXP);
		btnExp.addActionListener(this);
		btnExp.setFont(buttonFont);

		btnMod = new JButton("Mod");
		btnMod.setMargin(new Insets(1, 1, 1, 1));
		btnMod.setActionCommand(Constants.ACTION_COMMAND_MOD);
		btnMod.addActionListener(this);
		btnMod.setFont(buttonFont);

		btnLog = new JButton("log");
		btnLog.setMargin(new Insets(1, 1, 1, 1));
		btnLog.setActionCommand(Constants.ACTION_COMMAND_LOG);
		btnLog.addActionListener(this);
		btnLog.setFont(buttonFont);

		btnTenPotN = new JButton("<html>10<sup>x</sup></html>");
		btnTenPotN.setMargin(new Insets(1, 1, 1, 1));
		btnTenPotN.setActionCommand(Constants.ACTION_COMMAND_TENPOWN);
		btnTenPotN.addActionListener(this);
		btnTenPotN.setFont(buttonFontMin);

		btnZero = new JButton("0");
		btnZero.setMargin(new Insets(1, 1, 1, 1));
		btnZero.setFont(buttonFont);
		btnZero.setActionCommand(Constants.ACTION_COMMAND_ZERO);
		btnZero.addActionListener(this);

		btnComma = new JButton(",");
		btnComma.setMargin(new Insets(1, 1, 1, 1));
		btnComma.setFont(buttonFont);
		btnComma.setActionCommand(Constants.ACTION_COMMAND_COMMA);
		btnComma.addActionListener(this);

		btnPlus = new JButton("+");
		btnPlus.setMargin(new Insets(1, 1, 1, 1));
		btnPlus.setFont(buttonFont);
		btnPlus.setActionCommand(Constants.ACTION_COMMAND_PLUS);
		btnPlus.addActionListener(this);

	}

	private void situateComponents() {
		// Row One
		/*
		 * this.add(groupRadioUnits, "pushx, growx, pushy, growy");
		 */

		// Row Two
		this.add(btnBlank, "pushx, growx, pushy, growy");
		this.add(btnInv, "pushx, growx, pushy, growy");
		this.add(btnIn, "pushx, growx, pushy, growy");
		this.add(btnParL, "pushx, growx, pushy, growy");
		this.add(btnParR, "pushx, growx, pushy, growy");
		this.add(btnBck, "pushx, growx, pushy, growy");
		this.add(btnCE, "pushx, growx, pushy, growy");
		this.add(btnC, "pushx, growx, pushy, growy");
		this.add(btnSign, "pushx, growx, pushy, growy");
		this.add(btnSqrt, "pushx, growx, pushy, growy, wrap");

		// Row Three
		this.add(btnInt, "pushx, growx, pushy, growy");
		this.add(btnSinh, "pushx, growx, pushy, growy");
		this.add(btnSin, "pushx, growx, pushy, growy");
		this.add(btnPotTwo, "pushx, growx, pushy, growy");
		this.add(btnFact, "pushx, growx, pushy, growy");
		this.add(btnSeven, "pushx, growx, pushy, growy");
		this.add(btnEight, "pushx, growx, pushy, growy");
		this.add(btnNine, "pushx, growx, pushy, growy");
		this.add(btnDiv, "pushx, growx, pushy, growy");
		this.add(btnPercent, "pushx, growx, pushy, growy, wrap");

		// Row Four
		this.add(btnDms, "pushx, growx, pushy, growy");
		this.add(btnCosh, "pushx, growx, pushy, growy");
		this.add(btnCos, "pushx, growx, pushy, growy");
		this.add(btnPotN, "pushx, growx, pushy, growy");
		this.add(btnNRoot, "pushx, growx, pushy, growy");
		this.add(btnFour, "pushx, growx, pushy, growy");
		this.add(btnFive, "pushx, growx, pushy, growy");
		this.add(btnSix, "pushx, growx, pushy, growy");
		this.add(btnMult, "pushx, growx, pushy, growy");
		this.add(btnFrac, "pushx, growx, pushy, growy, wrap");

		// Row Five
		this.add(btnPi, "pushx, growx, pushy, growy");
		this.add(btnTanh, "pushx, growx, pushy, growy");
		this.add(btnTan, "pushx, growx, pushy, growy");
		this.add(btnPotThree, "pushx, growx, pushy, growy");
		this.add(btnCubicRoot, "pushx, growx, pushy, growy");
		this.add(btnOne, "pushx, growx, pushy, growy");
		this.add(btnTwo, "pushx, growx, pushy, growy");
		this.add(btnThree, "pushx, growx, pushy, growy");
		this.add(btnMinus, "pushx, growx, pushy, growy");
		this.add(btnEquals, "span 1 2, pushx, growx, pushy, growy, wrap");

		// Row six
		this.add(btnF_E, "pushx, growx, pushy, growy");
		this.add(btnExp, "pushx, growx, pushy, growy");
		this.add(btnMod, "pushx, growx, pushy, growy");
		this.add(btnLog, "pushx, growx, pushy, growy");
		this.add(btnTenPotN, "pushx, growx, pushy, growy");
		this.add(btnZero, "span 2, pushx, growx, pushy, growy");
		this.add(btnComma, "pushx, growx, pushy, growy");
		this.add(btnPlus, "pushx, growx, pushy, growy");

		/*
		 * JButton btnF_E; JButton btnExp; JButton btnMod; JButton btnLog;
		 * JButton btnTenPotN;
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object v = "";
		String c = e.getActionCommand();
		// Filter Action Commands
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
			v = new Boolean(true);
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
