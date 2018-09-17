package com.exception;

public class InvalidOperationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5053030859641965666L;

	public InvalidOperationException(){
		super();
	}
	
	public InvalidOperationException(String message){
		super(message);
	}
	
	public InvalidOperationException(Throwable cause) {
		super(cause);
	}
	
	public InvalidOperationException(String message, Throwable cause) {
		super(message, cause);
	}
}
