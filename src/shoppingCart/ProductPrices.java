/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingCart;

import java.util.HashMap;
import static shoppingCart.ProductCodes.ONE_GB;
import static shoppingCart.ProductCodes.ULT_LARGE;
import static shoppingCart.ProductCodes.ULT_MEDIUM;
import static shoppingCart.ProductCodes.ULT_SMALL;

/**
 *
 * @author robin
 */
public class ProductPrices {
	static HashMap products = new HashMap();
	static Product product;
			
	public ProductPrices () {
		products.put(ULT_SMALL, new Product("ult_small", "Unlimited 1GB", 24.90));
		products.put(ULT_MEDIUM, new Product("ult_medium", "Unlimited 2GB", 29.90));
		products.put(ULT_LARGE, new Product("ult_large", "Unlimited 5 GB", 44.90));
		products.put(ONE_GB, new Product("1gb", "1 GB Data pack", 9.90));		
	}
	
	public static double getPrice(String productCode){
		ProductPrices.product = (Product) products.get(productCode);
		return ProductPrices.product.getPrice();
	}
}
