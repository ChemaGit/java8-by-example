package com.example.io_nio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Portfolio implements Serializable{

	private static final long serialVersionUID = -333975979803001893L;
	
	private Set<Stock>stocks;
	
	
	/**
	 * @return the stocks
	 */
	public Set<Stock> getStocks() {
		return stocks;
	}

	/**
	 * @param stocks the stocks to set
	 */
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	public void addStock(Stock newStock) {
		if(stocks == null) {
			stocks = new HashSet<Stock>();
		}
		
		stocks.add(newStock);
	}
	
	public double getValue() {
		return 0.0;
	}
	
	public String toString() {
		return "";
	}
}
