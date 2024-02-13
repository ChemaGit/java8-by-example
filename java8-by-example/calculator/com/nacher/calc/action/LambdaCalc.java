package com.nacher.calc.action;

import java.util.function.DoubleFunction;

import com.nacher.calc.ui.Constants;


public class LambdaCalc extends Calculator{
	
	private DoubleFunction<Double> sum = t -> (t + Double.valueOf(this.getOperating2()));
	private DoubleFunction<Double> minus = t -> (t - Double.valueOf(this.getOperating2()));
	private DoubleFunction<Double> prod = t -> (t * Double.valueOf(this.getOperating2()));
	private DoubleFunction<Double> div = t -> (t / Double.valueOf(this.getOperating2()));
	private DoubleFunction<Double> sqrt = t -> (Math.sqrt(t));
	private DoubleFunction<Double> reciproc = t -> (1/t);
	
	public LambdaCalc(){
		super();	
	}
	
	/*********************************************************************
	 ********************SET THE OPERATINGS******************************
	 *********************************************************************/	
	public String doOperation() {
		String result = "";
		result = makeOperations();
		//Filtramos y parseamos el resultado
		return result;
	}
	
	/*********************************************************************
	 ********************MAKE THE OPERATIONS******************************
	 *********************************************************************/		
	private String makeOperations() {
		String result = "";
		String operation = super.getOperationCache()[1];
		if(operation != null && !operation.equals("")) {
			switch(operation) {
				case Constants.OPER_PLUS:
					result = sum();
					break;
				case Constants.OPER_MINUS:
					result = minus();
					break;
				case Constants.OPER_MULT:
					result = prod();
					break;
				case Constants.OPER_DIV:
					result = div();
					break;
				case Constants.OPER_SQRT:
					result = sqrt();
					break;					
				case Constants.OPER_EQUALS:					
					result = equals();
					break;
				default :
					
			}
			if(result != null && !result.equals(Constants.ERROR_VALUE) && !result.equals(Constants.DIV_ZERO)) {
				this.setResultado(result);				
			} else {
				this.setResultado(null);
			}
		} else {			
			result = this.getLastInput();				
		}
		return result;
	}
	

	/*********************************************************************
	 ********************OPERATIONS METHODS*******************************
	 *********************************************************************/
	private String equals() {
		String result = "";
		String operation = super.getOperationCache()[1];
		if(operation != null && !operation.equals("")) {
			switch(operation) {
				case Constants.OPER_PLUS:
					result = sum();					
					break;
				case Constants.OPER_MINUS:
					result = minus();
					break;
				case Constants.OPER_MULT:
					result = prod();
					break;
				case Constants.OPER_DIV:
					result = div();
					break;
				case Constants.OPER_EQUALS:					
					operation = super.getOperationCache()[2];
					if(operation != null && !operation.equals("")) {
						switch(operation) {
						case Constants.OPER_PLUS:
							result = sum();					
							break;
						case Constants.OPER_MINUS:
							result = minus();
							break;
						case Constants.OPER_MULT:
							result = prod();
							break;
						case Constants.OPER_DIV:
							result = div();
							break;
						default :
							result = this.getResultado();
						}
					} else {
						result = this.getResultado();
					}
				default :					
			}	
		} else {
			result = this.getLastInput();
		}
		return result;
	}
	
	private String sum() {
		boolean decimal = false;
		String result = "";
		boolean operar = false;
		if(this.setOperands(Constants.OPER_PLUS)) {
			operar = true;
		} else {
			operar = false;
			result = "ERROR";
		}
		if(operar) {			
			if(this.containsComma(this.getOperating1())) {
				this.setOperating1(this.replaceComma(this.getOperating1()));
			}
			if(this.containsComma(this.getOperating2())) {
				this.setOperating2(this.replaceComma(this.getOperating2()));
			}				    
						    			
			result = this.conversion(sum.apply(Double.valueOf(this.getOperating1())));
			decimal = decimalMeant(Double.valueOf(result));
			if(!decimal) {
				result = removeDecimals(result);
			} else {
				result = replaceDot(result);
			}			
		}

		return result;
	}
	
	private String minus() {
		boolean decimal = false;
		String result = "";
		boolean operar = false;
		if(this.setOperands(Constants.OPER_MINUS)) {
			operar = true;
		} else {
			operar = false;
			result = "ERROR";
		}
		if(operar) {
			if(this.containsComma(this.getOperating1())) {
				this.setOperating1(this.replaceComma(this.getOperating1()));
			}
			if(this.containsComma(this.getOperating2())) {
				this.setOperating2(this.replaceComma(this.getOperating2()));
			}
			result = this.conversion(minus.apply(Double.valueOf(this.getOperating1())));
			decimal = decimalMeant(Double.valueOf(result));
			if(!decimal) {
				result = removeDecimals(result);
			} else {
				result = replaceDot(result);
			}			
		}

		return result;
	}
	
	private String prod() {
		boolean decimal = false;
		String result = "";
		boolean operar = false;
		if(this.setOperands(Constants.OPER_MULT)) {
			operar = true;
		} else {
			operar = false;
			result = "ERROR";
		}
		if(operar) {
			if(this.containsComma(this.getOperating1())) {
				this.setOperating1(this.replaceComma(this.getOperating1()));
			}
			if(this.containsComma(this.getOperating2())) {
				this.setOperating2(this.replaceComma(this.getOperating2()));
			}
			result = this.conversion(prod.apply(Double.valueOf(this.getOperating1())));
			double prueba = new Double(result).doubleValue();
			System.out.println("doubleValue(): " + prueba);
			decimal = decimalMeant(Double.valueOf(result));
			if(!decimal) {
				result = removeDecimals(result);
			} else {
				result = replaceDot(result);
			}			
		}

		return result;
	}
	
	private String div() {
		boolean decimal = false;
		String result = "";
		boolean operar = false;
		if(this.setOperands(Constants.OPER_DIV)) {
			operar = true;
		} else {
			operar = false;
			result = "ERROR";
		}
		if(operar) {
			if(this.containsComma(this.getOperating1())) {
				this.setOperating1(this.replaceComma(this.getOperating1()));
			}
			if(this.containsComma(this.getOperating2())) {
				this.setOperating2(this.replaceComma(this.getOperating2()));
			}
			result = this.conversion(div.apply(Double.valueOf(this.getOperating1())));
			decimal = decimalMeant(Double.valueOf(result));
			if(!decimal) {
				result = removeDecimals(result);
			} else {
				result = replaceDot(result);
			}			
		}

		return result;		
	}
	
	private String sqrt() {
		boolean decimal = false;
		String result = "";
		boolean operar = false;
		if(this.setOperands(Constants.OPER_SQRT)) {
			operar = true;
		} else {
			operar = false;
			result = "ERROR";
		}
		if(operar) {
			if(this.containsComma(this.getOperating1())) {
				this.setOperating1(this.replaceComma(this.getOperating1()));
			}
			result = this.conversion(sqrt.apply(Double.valueOf(this.getOperating1())));
			decimal = decimalMeant(Double.valueOf(result));
			if(!decimal) {
				result = removeDecimals(result);
			} else {
				result = replaceDot(result);
			}
		}
		
		return result;
	}
}
