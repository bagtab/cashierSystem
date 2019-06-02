package integration;

import java.util.Iterator;

import dto.Discount;
import dto.ItemListDTO;
import dto.QuantifiedItemDTO;

public class DiscountHandler {
	/**
	 * calculates the total discount for the sale depending on the customer, items
	 * purchased, quantity of items and total cost
	 * 
	 * @param itemListDTO
	 *            SaleDTO, data used to calculate discount
	 * @param customerID
	 *            String, used to check customer qualification for certain discounts
	 * @return double, the calculated discount
	 */
	public Discount generateDiscount(ItemListDTO itemListDTO, String customerID) {
		double cost = 0;
		Iterator<QuantifiedItemDTO> iterator = itemListDTO.getIterator();
		while (iterator.hasNext()) {
			cost += getCost(iterator.next());
		}
		if (customerID.equals("Joe")) {

			return new Discount(0, 0, 0, cost * 0.10);
		}
		return new Discount(0, 0, 0, 0);
	}

	/**
	 * returns the cost of the quantified item
	 * 
	 * @param item
	 *            item to calculate cost of
	 * @return double cost of item
	 */
	private double getCost(QuantifiedItemDTO item) {
		return item.getQuantity() * item.getPrice();
	}
}
