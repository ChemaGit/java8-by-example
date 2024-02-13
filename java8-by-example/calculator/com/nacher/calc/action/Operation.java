package com.nacher.calc.action;

import com.nacher.calc.ui.Constants;

public enum Operation {
	SUM(Constants.OPER_PLUS), MINUS(Constants.OPER_MINUS), MULT(Constants.OPER_MULT), DIV(Constants.OPER_DIV),
	EQ(Constants.OPER_EQUALS);
	
	private String oper;
	
	private Operation(String oper) {
		this.oper = oper;
	}	
	
	public String toString( ) {
		return this.oper;
	}
}
