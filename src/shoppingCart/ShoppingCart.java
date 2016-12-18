/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingCart;

import java.util.List;

/**
 *
 * @author robin
 */
public class ShoppingCart {
	PricingRules pricingRules;
	double total;
	List items;
	
	
	public ShoppingCart(PricingRules pricingRules){
		this.pricingRules = pricingRules;
	}
	
	public void add(String item){
		pricingRules.add(item);
		total = pricingRules.total;
		items = pricingRules.items;
	}

	public void add(String item, String promoCode){
		pricingRules.setPromoCode(promoCode);
		add(item);
	}
	
	public int getQuantity (String productCode) {
		int quantity = 0;
		for (Object item : items) {
			if(item.equals(productCode)){
				++quantity;
			}
		}
		return quantity;
	}
}
