package com.example.io_nio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Stock implements Serializable {

	private static final long serialVersionUID = -7495650505923289296L;
	private String symbol;
	private int shares;
	private double purchasePrice;
	private transient double currPrice;
	
	public Stock(String symbol, int shares, double purchasePrice) {
		this.symbol = symbol;
		this.shares = shares;
		this.purchasePrice = purchasePrice;
		setStockPrice();
	}
	
	//This method is called post-serialization
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		//perform other initialization
		setStockPrice();
	}
	
	private void setStockPrice() {
		this.currPrice = 12365.23;
	}

}
