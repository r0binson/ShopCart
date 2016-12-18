/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingCart;

import java.util.ArrayList;
import java.util.List;
import static shoppingCart.ProductCodes.ONE_GB;
import static shoppingCart.ProductCodes.ULT_LARGE;
import static shoppingCart.ProductCodes.ULT_MEDIUM;
import static shoppingCart.ProductCodes.ULT_SMALL;

/**
 *
 * @author robin
 */
public class PricingRules {

	//TODO: Convert to Singleton
	ProductPrices productPrice = new ProductPrices();
	
	double total;
	List items = new ArrayList();
	int smallCounter = 0;
	int largeCounter = 0;
	boolean isDiscountApplicable = false;
  double ultLargeDiscount = 5;
	double discountOnFourULTLarge = 20;
	private final String VALID_PROMO_CODE = "I<3AMAYSIM";
	private String promoCode = "";
	

	public void add(String item) {
		items.add(item);
		total += ProductPrices.getPrice(item);

    if(isThreeForTwoApplicable(item)){
			applyThreeForTwoDiscount();
		}
		
		if(isBulkDiscountApplicable(item)){
			applyBulkDiscount();
		}
		
		if(isBundlePromoApplicable(item)){
			applyBundleDiscount();
		}

		if(isPromoCodeValid(promoCode)){
			applyPromoCodeDiscount();
		}
	}

	
	private boolean isPromoCodeValid(String promoCode){
		return promoCode.equals(VALID_PROMO_CODE);
	}
	
	private void applyPromoCodeDiscount(){
		total *= 0.90;
	}

	private boolean isBundlePromoApplicable(String item){
		return item.equals(ULT_MEDIUM);
	}
	
	private void applyBundleDiscount () {
		items.add(ONE_GB);
	}
	
	private boolean isBulkDiscountApplicable(String item){
		if (item.equals(ULT_LARGE)) {
			++largeCounter;
		}
		return (largeCounter>3 && item.equals(ULT_LARGE));
	}
	
	private void applyBulkDiscount(){
			if (isDiscountApplicable) {
				total -= ultLargeDiscount;
			} else {
				isDiscountApplicable = true;
				total -= discountOnFourULTLarge;
			}
	}

	private boolean isThreeForTwoApplicable(String item) {
		if (item.equals(ULT_SMALL)) {
			++smallCounter;
		}
		return (smallCounter==3 && item.equals(ULT_SMALL));
	}
	
	private void applyThreeForTwoDiscount(){
		total -= ProductPrices.getPrice(ULT_SMALL);
		smallCounter = 0;		
	}

	/**
	 * @param promoCode the promoCode to set
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
}
