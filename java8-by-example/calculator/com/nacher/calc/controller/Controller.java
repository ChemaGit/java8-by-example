package com.nacher.calc.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.nacher.calc.action.Calculator;
import com.nacher.calc.action.LambdaCalc;
import com.nacher.calc.ui.Constants;

public class Controller extends AbstractModel implements PropertyChangeListener{
	private Calculator lambdaCalc;
	
	
	private StringBuilder buildOper = new StringBuilder("");
	private StringBuilder buildNumber = new StringBuilder("");
	
	private String calcType = Constants.CALC_STANDARD;
	private String calcFunc = Constants.CALC_BASIC;
	
	private String calculatorMode;

	public Controller() {
		lambdaCalc = new LambdaCalc();
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String c = evt.getPropertyName();		
		//Number events (Fired from the keyboard and from the number buttons)
		if (c.equals(Constants.ACTION_COMMAND_ONE) || c.equals(Constants.ACTION_COMMAND_TWO) || c.equals(Constants.ACTION_COMMAND_THREE) || 
				c.equals(Constants.ACTION_COMMAND_FOUR) || c.equals(Constants.ACTION_COMMAND_FIVE) || c.equals(Constants.ACTION_COMMAND_SIX) || 
				c.equals(Constants.ACTION_COMMAND_SEVEN) || c.equals(Constants.ACTION_COMMAND_EIGHT) || c.equals(Constants.ACTION_COMMAND_NINE) || 
				c.equals(Constants.ACTION_COMMAND_ZERO) || c.equals(Constants.ACTION_COMMAND_COMMA)) {
			setNumber(evt);
		}
		//Simple operation events (Fired from the keyboard and the plus, minus, multiply, divide and equal buttons)
		if (c.equals(Constants.ACTION_COMMAND_PLUS) || c.equals(Constants.ACTION_COMMAND_MINUS) || c.equals(Constants.ACTION_COMMAND_MULT) || 
				c.equals(Constants.ACTION_COMMAND_DIV) || c.equals(Constants.ACTION_COMMAND_EQUALS)) {
			setOperationTwoOperands(evt);
		}
		//Special operation events (Fired from the square root, percent, fraction and sign buttons)
		if (c.equals(Constants.ACTION_COMMAND_SQRT) || c.equals(Constants.ACTION_COMMAND_PERCENT) || c.equals(Constants.ACTION_COMMAND_FRAC) || 
				c.equals(Constants.ACTION_COMMAND_SIGN)) {
			setOperationOneOperand(evt);
		}
		//Deletion events (Fired from the keyboard and from the backspace, C and CE buttons)
		if (c.equals(Constants.ACTION_COMMAND_BACK) || c.equals(Constants.ACTION_COMMAND_CLEAR) || c.equals(Constants.ACTION_COMMAND_CE)) {
			delete(evt);
		}
		//Look and Feel events (Fired from the options menu)
		if (c.equals(Constants.ACTION_COMMAND_GRAPHITE) || c.equals(Constants.ACTION_COMMAND_BERNSTEIN) || c.equals(Constants.ACTION_COMMAND_FAST) ||
				c.equals(Constants.ACTION_COMMAND_HIFI) || c.equals(Constants.ACTION_COMMAND_LUNA)) {
			this.firePropertyChange(c, null, true);
		}
        //Set Scientific Calculator
        if (c.equals(Constants.SET_CALC_SCIENTIFIC)) {
        	//System.out.println("Controller speaking. Set the Scientific Calculator");
        	if (!calculatorMode.equals(Constants.SET_CALC_SCIENTIFIC)) {
        		this.firePropertyChange(c, null, true);
        		calcType = Constants.CALC_SCIENTIFIC;
        	}             
        }
        //Set Standard Calculator
        if (c.equals(Constants.SET_CALC_STANDARD)) {
        	//System.out.println("Controller speaking. Set the Standard Calculator");
        	if (!calculatorMode.equals(Constants.SET_CALC_STANDARD)) {
        		this.firePropertyChange(c, null, true);
        		calcType = Constants.CALC_STANDARD;
        	}
        }
		
	}

	private void setNumber(PropertyChangeEvent evt) {
		String c = evt.getPropertyName();
		String v = (String)evt.getNewValue();
		buildNumber = lambdaCalc.setBuildNumber(buildNumber, v);
		
		writeNumber(buildNumber.toString());
	}
	
	private void setOperationOneOperand(PropertyChangeEvent evt) {
		String c = evt.getPropertyName();
		String v = (String)evt.getNewValue();
	}
	
	private void setOperationTwoOperands(PropertyChangeEvent evt) {
		String c = evt.getPropertyName();
		String v = (String)evt.getNewValue();
		lambdaCalc.setOperation(v);
		//Si recibimos una operación siempre esperamos un resultado
		//Si la operación es un igual hay que resetear buildOper y buildNumber
		if(c.equals(Constants.ACTION_COMMAND_EQUALS)) {//Hay que operar. Si se puede!!!
			if(lambdaCalc.getOperation() != null){
				//Hay que borrar buildOper y escribirlo
				buildOper = new StringBuilder("");
				this.firePropertyChange(Constants.WRITE_OPERATION, null, buildOper.toString());
				//Hay que operar	
				lambdaCalc.setLastInput(buildNumber.toString());								
				buildNumber = new StringBuilder("");
				performOperation();
			}
		} else {
			if(buildOper.length() < 1) {
				if(buildNumber.toString().equals("")) {
					buildNumber.append(lambdaCalc.getResultado());
				}
				buildOper.append(buildNumber.toString()).append(" ").append(v);
				lambdaCalc.setLastInput(buildNumber.toString());					
				buildNumber = new StringBuilder("");
			} else {
				if(buildNumber.length() < 1) {//Hay que cambiar el operador
					buildOper.setCharAt(buildOper.length() - 1, v.charAt(0));					
				} else {//Aquí hay que ir haciendo la operación
					buildOper.append(" ").append(buildNumber.toString()).append(" ").append(v);
					lambdaCalc.setLastInput(buildNumber.toString());										
					buildNumber = new StringBuilder("");
					//Operamos
					performOperation();
				}
			}
			this.firePropertyChange(Constants.WRITE_OPERATION, null, buildOper.toString());
		}		
	}
	
	private void writeNumber(String result) {
		if(calcType.equals(Constants.CALC_STANDARD)) {
			this.firePropertyChange(Constants.WRITE_NUMBER, null, result);
		} else if(calcType.equals(Constants.CALC_SCIENTIFIC)) {
			this.firePropertyChange(Constants.WRITE_NUMBER_SCIENTIFIC, null, result);
		}
	}
	
	private void performOperation() {
		String result = ((LambdaCalc)lambdaCalc).doOperation();
		//Hay que escribir el resultado
		writeNumber(result);
		
	}
	
	private void delete(PropertyChangeEvent evt) {
		String c = evt.getPropertyName();
		if (c.equals(Constants.ACTION_COMMAND_CLEAR)) {
			buildNumber = new StringBuilder("");
			buildOper = new StringBuilder("");
			this.firePropertyChange(Constants.WRITE_NUMBER, null, buildNumber.toString());
			this.firePropertyChange(Constants.WRITE_OPERATION, null, buildOper.toString());
			lambdaCalc.setOperation(null);
			lambdaCalc.setOperating1("");
			lambdaCalc.setOperating2("");
			lambdaCalc.setLastInput("");
			lambdaCalc.setResultado("");
		}
	}
	
	/**
	 * @return the calculatorMode
	 */
	public String getCalculatorMode() {
		return calculatorMode;
	}

	/**
	 * @param calculatorMode the calculatorMode to set
	 */
	public void setCalculatorMode(String calculatorMode) {
		this.calculatorMode = calculatorMode;
	}
	
}
