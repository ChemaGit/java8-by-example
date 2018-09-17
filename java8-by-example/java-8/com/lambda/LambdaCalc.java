package com.lambda;

import java.util.function.DoubleFunction;

public class LambdaCalc {
	
	public String operando1;
	public String operando2;	
	public DoubleFunction<String> sum = t -> String.valueOf(t + Double.valueOf(operando2)); 
	public DoubleFunction<String> minus = t -> String.valueOf(t - Double.valueOf(operando2));
	public DoubleFunction<String> prod = t -> String.valueOf(t * Double.valueOf(operando2));
	public DoubleFunction<String> div = t -> String.valueOf(t / Double.valueOf(operando2));
	
	public LambdaCalc(String operando1, String operando2) {
		this.operando1 = operando1;
		this.operando2 = operando2;
	}
	
	
	public boolean containsComma(String operando) {
		return operando.contains(".");
	}
	
	public String replaceDot(String result) {		
		return result.replace('.', ',');
	}
	
	public boolean decimalMeant(double num) {
		boolean result = false;
		double floor = Math.floor(num);
		
		result = ( (num - floor ) > 0.0);
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaCalc calc = new LambdaCalc("1254.65", "3215.56");
		String resultSum = calc.sum.apply(Double.valueOf(calc.operando1));
		System.out.println("The result: " + resultSum);
		
		boolean prueba = calc.decimalMeant(Double.valueOf("0.000001"));
		if(prueba) {
			System.out.println("Significa algo");
		} else {
			System.out.println("No significa una mierda");
		}
		
	}	

}
