package integration;

import dto.Discount;
import dto.SaleDTO;

public class DiscountHandler {
	/**
	 * calculates the total discount for the sale depending on the customer, items purchased, quantity of items and total cost
	 * @param sale - SaleDTO, data used to calculate discount
	 * @param customerID - String, used to check customer qualification for certain discounts
	 * @return - double, the calculated discount
	 */
	public Discount generateDiscount(SaleDTO sale, String customerID) {
		if(customerID.equals("Joe")) {
			return new Discount(0, 0, 0,sale.getCost()*0.10);
		}
		return new Discount(0, 0, 0, sale.getCost()*0.10);
	}

}
