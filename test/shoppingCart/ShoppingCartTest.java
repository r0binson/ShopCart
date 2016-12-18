package shoppingCart;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Assert;
import org.junit.Test;
import static shoppingCart.ProductCodes.ONE_GB;
import static shoppingCart.ProductCodes.ULT_LARGE;
import static shoppingCart.ProductCodes.ULT_MEDIUM;
import static shoppingCart.ProductCodes.ULT_SMALL;

/**
 *
 * @author robin
 */
public class ShoppingCartTest {

	public ShoppingCartTest() {
	}

	@Test
	public void scenario1Total() {
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		//given
		double EXPECTED_CART_TOTAL = 94.70;

		//when 
		cart.add(ULT_SMALL);
		cart.add(ULT_SMALL);
		cart.add(ULT_SMALL);
		cart.add(ULT_LARGE);

		//then
		Assert.assertEquals(EXPECTED_CART_TOTAL, cart.total, 0.0001);
	}

	@Test
	public void scenario1Quantity() {
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		//given
		int EXPECTED_QUANTITY_SMALL = 3;
		int EXPECTED_QUANTITY_LARGE = 1;

		//when 
		cart.add(ULT_SMALL);
		cart.add(ULT_SMALL);
		cart.add(ULT_SMALL);
		cart.add(ULT_LARGE);

		//then
		Assert.assertEquals(EXPECTED_QUANTITY_LARGE, cart.getQuantity(ULT_LARGE));
		Assert.assertEquals(EXPECTED_QUANTITY_SMALL, cart.getQuantity(ULT_SMALL));
	}

	@Test
	public void scenario2Total() {
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		//given
		double EXPECTED_CART_TOTAL = 209.40;

		//when 
		cart.add(ULT_SMALL);
		cart.add(ULT_SMALL);
		cart.add(ULT_LARGE);
		cart.add(ULT_LARGE);
		cart.add(ULT_LARGE);
		cart.add(ULT_LARGE);

		//then
		Assert.assertEquals(EXPECTED_CART_TOTAL, cart.total, 0.0001);
	}

	@Test
	public void scenario2Quantity() {
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		//given
		int EXPECTED_QUANTITY_SMALL = 2;
		int EXPECTED_QUANTITY_LARGE = 4;

		//when 
		//when 
		cart.add(ULT_SMALL);
		cart.add(ULT_SMALL);
		cart.add(ULT_LARGE);
		cart.add(ULT_LARGE);
		cart.add(ULT_LARGE);
		cart.add(ULT_LARGE);

		//then
		Assert.assertEquals(EXPECTED_QUANTITY_LARGE, cart.getQuantity(ULT_LARGE));
		Assert.assertEquals(EXPECTED_QUANTITY_SMALL, cart.getQuantity(ULT_SMALL));
	}

	@Test
	public void scenario3Total() {
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		//given
		double EXPECTED_CART_TOTAL = 84.70;

		//when 
		cart.add(ULT_SMALL);
		cart.add(ULT_MEDIUM);
		cart.add(ULT_MEDIUM);

		//then
		Assert.assertEquals(EXPECTED_CART_TOTAL, cart.total, 0.0001);
	}

	@Test
	public void scenario3Quantity() {
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		//given
		int EXPECTED_QUANTITY_SMALL = 1;
		int EXPECTED_QUANTITY_MEDIUM = 2;
		int EXPECTED_QUANTITY_ONE_GB = 2;

		//when 
		cart.add(ULT_SMALL);
		cart.add(ULT_MEDIUM);
		cart.add(ULT_MEDIUM);


		//then
		Assert.assertEquals(EXPECTED_QUANTITY_MEDIUM, cart.getQuantity(ULT_MEDIUM));
		Assert.assertEquals(EXPECTED_QUANTITY_SMALL, cart.getQuantity(ULT_SMALL));
		Assert.assertEquals(EXPECTED_QUANTITY_ONE_GB, cart.getQuantity(ONE_GB));
	}

	
	@Test
	public void scenario4Total() {
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		//given
		double EXPECTED_CART_TOTAL = 31.32;

		//when 
		cart.add(ULT_SMALL);
		cart.add(ONE_GB, "I<3AMAYSIM");
		

		//then
		Assert.assertEquals(EXPECTED_CART_TOTAL, cart.total, 0.0001);
	}

	@Test
	public void scenario4Quantity() {
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		//given
		int EXPECTED_QUANTITY_SMALL = 1;
		int EXPECTED_QUANTITY_ONE_GB = 1;

		//when 
		cart.add(ULT_SMALL);
		cart.add(ONE_GB, "I<3AMAYSIM");


		//then
		Assert.assertEquals(EXPECTED_QUANTITY_SMALL, cart.getQuantity(ULT_SMALL));
		Assert.assertEquals(EXPECTED_QUANTITY_ONE_GB, cart.getQuantity(ONE_GB));
	}
	
	@Test
	public void test_WhenAnItemIsAddedToCart_ItShouldDisplayCorrectTotal() {
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		//Given
		String productCode = ULT_SMALL;
		double EXPECTED_TOTAL = 24.90;

		//When
		cart.add(productCode);

		//then
		Assert.assertEquals(EXPECTED_TOTAL, cart.total, 0.001);
	}

	@Test
	public void test_When2SameItemsAreAddedToCart_ItShouldDisplayCorrectTotal() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		String productCode = ULT_SMALL;
		double EXPECTED_TOTAL = 49.80;

		//When
		//1st item
		cart.add(productCode);
		//2nd item
		cart.add(productCode);

		//then
		Assert.assertEquals(EXPECTED_TOTAL, cart.total, 0.001);
	}

	@Test
	public void test_WhenDifferentItemsAreAddedToCart_ItShouldDisplayCorrectTotal() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		String productCode1 = ULT_SMALL;
		String productCode2 = ULT_LARGE;
		double EXPECTED_TOTAL = 114.70;

		//When
		//1st item
		cart.add(productCode1);

		//2nd item (different Item)
		cart.add(productCode2);

		//3rd item (same as item 2)
		cart.add(productCode2);

		//then
		Assert.assertEquals(EXPECTED_TOTAL, cart.total, 0.001);
	}

	@Test
	public void test_WhenDifferentItemsAreAddedToCart_ItShouldDisplayCorrectQuantity() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		String SMALL = ULT_SMALL;
		String LARGE = ULT_LARGE;
		int EXPECTED_QUANTITY_SMALL = 1;
		int EXPECTED_QUANTITY_LARGE = 2;
		//When
		cart.add(SMALL); //1st item
		cart.add(LARGE); //2nd item (different Item)
		cart.add(LARGE); //3rd item (same as item 2)

		//then
		Assert.assertEquals(EXPECTED_QUANTITY_SMALL, cart.getQuantity(SMALL));
		Assert.assertEquals(EXPECTED_QUANTITY_LARGE, cart.getQuantity(LARGE));
	}

	@Test
	public void Given_ThreeForTwoDeal_When3Unlimited1GBSimsAddedToCart_totalShouldBeEqualtoThePriceOfTwo() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		String SMALL = ULT_SMALL;
		double EXPECTED_TOTAL_SMALL = 49.80;

		//When
		cart.add(SMALL);
		cart.add(SMALL);
		cart.add(SMALL);

		//then
		Assert.assertEquals(EXPECTED_TOTAL_SMALL, cart.total, 0.001);
	}

	@Test
	public void Given_ThreeForTwoDeal_When5Unlimited1GBSimsAddedToCart_totalShouldBeEqualto99_6() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		String SMALL = ULT_SMALL;
		double EXPECTED_TOTAL_SMALL = 99.6;

		//When
		cart.add(SMALL);
		cart.add(SMALL);
		cart.add(SMALL);
		cart.add(SMALL);
		cart.add(SMALL);

		//then
		Assert.assertEquals(EXPECTED_TOTAL_SMALL, cart.total, 0.001);
	}

	@Test
	public void Given_ThreeForTwoDeal_When5Unlimited1GBSimsAddedToCart_quantityShouldBeEqualto5() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		String SMALL = ULT_SMALL;
		int EXPECTED_QUANTITY_SMALL = 5;

		//When
		cart.add(SMALL); //item 1
		cart.add(SMALL); //item 2		
		cart.add(SMALL); //item 3
		cart.add(SMALL); //item 4
		cart.add(SMALL); //item 5

		//then
		Assert.assertEquals(EXPECTED_QUANTITY_SMALL, cart.getQuantity(SMALL));
	}

	@Test
	public void Given_ThreeForTwoDeal_When6Unlimited1GBSimsAddedToCart_totalShouldBeEqualto99_6() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);;
		String SMALL = ULT_SMALL;
		double EXPECTED_TOTAL_SMALL = 99.6;

		//When
		cart.add(SMALL);
		cart.add(SMALL);
		cart.add(SMALL);
		cart.add(SMALL);
		cart.add(SMALL);
		cart.add(SMALL);

		//then
		Assert.assertEquals(EXPECTED_TOTAL_SMALL, cart.total, 0.001);
	}

	@Test
	public void Given_ThreeForTwoDeal_When6Unlimited1GBSimsAddedToCart_quantityShouldBeEqualto5() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		String SMALL = ULT_SMALL;
		int EXPECTED_QUANTITY_SMALL = 6;

		//When
		cart.add(SMALL); //item 1
		cart.add(SMALL); //item 2		
		cart.add(SMALL); //item 3
		cart.add(SMALL); //item 4
		cart.add(SMALL); //item 5
		cart.add(SMALL); //item 6
		//then
		Assert.assertEquals(EXPECTED_QUANTITY_SMALL, cart.getQuantity(SMALL));
	}

	@Test
	public void Given_bulkDiscountPromo_When4Unlimited5GBSimsAddedToCart_totalShouldBeEqualto159_6() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		double EXPECTED_TOTAL_LARGE = 159.6;

		//When
		cart.add(ULT_LARGE); //item 1
		cart.add(ULT_LARGE); //item 2		
		cart.add(ULT_LARGE); //item 3
		cart.add(ULT_LARGE); //item 4

		//then
		Assert.assertEquals(EXPECTED_TOTAL_LARGE, cart.total, 0.001);
	}

	@Test
	public void Given_bulkDiscountPromo_When4Unlimited5GBSimsAddedToCart_quantityShouldBeEqualto4() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);

		int EXPECTED_QUANTITY_LARGE = 4;

		//When
		cart.add(ULT_LARGE); //item 1
		cart.add(ULT_LARGE); //item 2		
		cart.add(ULT_LARGE); //item 3
		cart.add(ULT_LARGE); //item 4

		//then
		Assert.assertEquals(EXPECTED_QUANTITY_LARGE, cart.getQuantity(ULT_LARGE));
	}

	@Test
	public void Given_bulkDiscountPromoCombinedWithThreeForTwoPromo_When4Unlimited5GBAnd3OneGBSimsAddedToCart_thenTotalShouldBeEqualto209_4() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		double EXPECTED_TOTAL = 209.4;

		//When
		cart.add(ULT_LARGE); //item 1
		cart.add(ULT_SMALL); //item 2
		cart.add(ULT_LARGE); //item 3		
		cart.add(ULT_SMALL); //item 4
		cart.add(ULT_LARGE); //item 5
		cart.add(ULT_SMALL); //item 6
		cart.add(ULT_LARGE); //item 7

		//then
		Assert.assertEquals(EXPECTED_TOTAL, cart.total, 0.001);
	}

	@Test
	public void given_bundlePromo_when_2GBSimIsAddedToCart_thenOneGBDataPackWillbeAdded() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		int EXPECTED_2GB_QUANTITY = 1;
		int EXPECTED_1GB_QUANTITY = 1;

		//When
		cart.add(ULT_MEDIUM); //item 1

		//then
		Assert.assertEquals(EXPECTED_2GB_QUANTITY, cart.getQuantity(ULT_MEDIUM));
		Assert.assertEquals(EXPECTED_1GB_QUANTITY, cart.getQuantity(ONE_GB));

	}

	@Test
	public void given_bundlePromo_when_Three2GBSimIsAddedToCart_thenThreeOneGBDataPackWillbeAdded() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		int EXPECTED_2GB_QUANTITY = 3;
		int EXPECTED_1GB_QUANTITY = 3;

		//When
		cart.add(ULT_MEDIUM); //item 1
		cart.add(ULT_MEDIUM); //item 2
		cart.add(ULT_MEDIUM); //item 3

		//then
		Assert.assertEquals(EXPECTED_2GB_QUANTITY, cart.getQuantity(ULT_MEDIUM));
		Assert.assertEquals(EXPECTED_1GB_QUANTITY, cart.getQuantity(ONE_GB));

	}

	@Test
	public void given_promoCodeDiscount_when_OneGBAnd1ULTSmallSimIsAddedToCart_then10PercentDiscountShouldbeApplied() {
		//Given
		PricingRules pricingRules = new PricingRules();
		ShoppingCart cart = new ShoppingCart(pricingRules);
		String promoCode = "I<3AMAYSIM";

		double EXPECTED_TOTAL = 31.32;

		//When
		cart.add(ULT_SMALL); //item 1
		cart.add(ONE_GB, promoCode); //item 2

		//then
		Assert.assertEquals(EXPECTED_TOTAL, cart.total, 0.001);

	}

}
