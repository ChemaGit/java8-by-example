package com.example.io_nio;

import java.io.Serializable;

public class ShoppingCart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -982836637675585847L;
	private int id;
	private String product;
	private String description;
	private double price;
	
	public ShoppingCart(int id, String product, String description, double price) {
		this.setId(id);
		this.setProduct(product);
		this.setDescription(description);
		this.setPrice(price);
	}
	
	public String toString() {
		return "ID: " + this.getId() + "\n" +
				"PRODUCT: " + this.getProduct() + "\n" + 
				"DESCRIPTION: " + this.getDescription() + "\n" + 
				"PRICE: " + this.getPrice() + "\n";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
