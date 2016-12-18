/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingCart;

/**
 *
 * @author robin
 */
public class Product {
	private final String productCode;
	private final String productName;
	private final double price;	
	
	public Product(String productCode, String productName, double price){
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
}