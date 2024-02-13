package com.nacher.calc.action;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import com.nacher.calc.ui.Constants;

public class Calculator {
	private String operation;
	private String[] operationCache;// La posición [0] es para la operación actual
									// la [1] es para la operación anterior									
									//la posición [2] es para la última operación aritmética que se ha realizado
	
	private String operatingCache;//La penúltima entrada del usuario
	private String operating2;
	private String operating1;
	private String lastInput; //La última entrada del usuario

	private String resultado;

	public Calculator() {
		operation = null;
		operating1 = "";
		operating2 = "";
		
		resultado = "";
		operatingCache = "";
		operationCache = new String[3];
	}

	/*********************************************************************
	 ******************** IS NUMBER VALID**********************************
	 *********************************************************************/
	public StringBuilder setBuildNumber(StringBuilder number, String add) {
		/*
		 * tenemos que comprobar si hay un resultado y si hay o no operación y
		 * si el resultado es igual al parametro que llega number
		 */
		// Si viene la coma la tratamos primero.
		if (add.equals(Constants.OPER_COMMA)) {
			if (number.length() < 1) {
				number.append(Constants.NUMBER_ZERO + Constants.OPER_COMMA);
			} else {
				number.append(add);
			}
		} else {
			if (number.length() < 1) {
				number.append(add);
			} else if (number.length() == 1 && number.toString().equals(Constants.NUMBER_ZERO)) {
				number.deleteCharAt(0);
				number.append(add);
			} else {
				number.append(add);
			}
		}

		return number;
	}

	protected boolean isThereOperation() {
		if (this.operation != null && !this.operation.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isThereOperating1() {
		if (this.operating1 != null && !this.operating1.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isThereOperating2() {
		if (this.operating2 != null && !this.operating2.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	/*********************************************************************
	 ******************** PARSE METHODS*******************************
	 *********************************************************************/
	protected boolean containsComma(String operando) {
		return operando.contains(",");
	}

	protected String replaceDot(String result) {
		return result.replace('.', ',');
	}

	protected String replaceComma(String operando) {
		return operando.replace(',', '.');
	}

	protected String removeDecimals(String result) {
		int index = result.indexOf(".");
		if(index >= 0) {
			String parts = result.substring(0, (index));
			return parts;
		}		
		return result;
	}

	protected boolean decimalMeant(double num) {
		boolean result = false;
		double floor = Math.floor(num);

		result = ((num - floor) > 0.0);

		return result;
	}

	protected boolean isZeroValid(String number) {
		boolean valid = true;
		if (number.startsWith(Constants.NUMBER_ZERO)) {
			valid = false;
		}
		return valid;
	}
	
    protected  String conversion(Double valor) {
    	String pattern = "#######################################.######################################";
    	Locale loc = Locale.US;
    	Locale.setDefault(loc);
    	NumberFormat nf = NumberFormat.getNumberInstance(loc);   
    	DecimalFormat df = (DecimalFormat)nf;
    	df.applyPattern(pattern);    
    	return df.format(valor);
    }		

	/*********************************************************************
	 ******************** GETTER/SETTER METHODS****************************
	 *********************************************************************/
	//set the operating1 and the operating2 for the operation
    //TODO: TERMINAR
    //TODO: Filtro mediante método que compruebe si la operación es simple o compleja y devuelva un boolean.
	protected boolean setOperands(String operation) {		
		boolean operar = true;
		//if(operation.equals)
		if(resultado.equals("")) { //resultado vacío
			if (lastInput != null && !lastInput.equals("") && 
					(operatingCache != null && !operatingCache.equals(""))) { //CASO 1 => lastInput y operatingCache tienen valor
				this.setOperating1(operatingCache);
				this.setOperating2(lastInput);
			} else if (lastInput == null || lastInput.equals("") &&
					(operatingCache != null && !operatingCache.equals(""))) { //CASO 2 => Solo operatingCache tiene valor
				this.setOperating1(operatingCache);
				this.setOperating2(operatingCache);
			}
		} else if(!resultado.equals("")) { //resultado tiene valor
			if (lastInput != null && !lastInput.equals("") &&
					(operatingCache != null && !operatingCache.equals(""))) { //CASO 3 => operatingCache y lastInput tienen valor
				this.setOperating1(resultado);
				this.setOperating2(lastInput);
			} else if(!resultado.equals("") && (lastInput == null || lastInput.equals("")) &&
					(operatingCache != null && !operatingCache.equals(""))) { //CASO 4 => lastInput no tiene valor
				this.setOperating1(resultado);
				this.setOperating2(operatingCache);
			}
		} else {
			operar = false;
		}

		return operar;
	}	

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return this.operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
		// Establecemos la caché de la operación
		if (this.operation == null) {
			operationCache[0] = null;
			operationCache[1] = null;
			operationCache[2] = null;
		} else {
			operationCache[1] = operationCache[0];
			operationCache[0] = this.operation;
			if(!this.operation.equalsIgnoreCase(Constants.OPER_EQUALS)) {
				operationCache[2] = this.operation;
			}
		}
	}

	/**
	 * @return the operationCache
	 */
	public String[] getOperationCache() {
		return operationCache;
	}

	/**
	 * @return the operating2
	 */
	public String getOperating2() {
		return operating2;
	}

	/**
	 * @param operating2
	 *            the operating2 to set
	 */
	public void setOperating2(String operating2) {
		this.operating2 = operating2;
	}

	/**
	 * @return the operating1
	 */
	public String getOperating1() {
		return operating1;
	}

	/**
	 * @param operating1
	 *            the operating1 to set
	 */
	public void setOperating1(String operating1) {
		this.operating1 = operating1;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado
	 *            the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	/**
	 * @return the operatingCache
	 */
	public String getOperatingCache() {
		return operatingCache;
	}

	/**
	 * @param operatingCache the operatingCache to set
	 */
	private void setOperatingCache(String operatingCache) {
		if(operatingCache != null && !operatingCache.equalsIgnoreCase("")) {
			this.operatingCache = operatingCache;
		}		
	}

	/**
	 * @param operationCache the operationCache to set
	 */
	public void setOperationCache(String[] operationCache) {
		this.operationCache = operationCache;
	}	
	
	public String getLastInput() {
		return lastInput;
	}

	public void setLastInput(String lastInput) {
		this.setOperatingCache(this.lastInput);
		this.lastInput = lastInput;
	}	

}
