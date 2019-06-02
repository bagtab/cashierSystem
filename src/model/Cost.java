package model;

import dto.Discount;
import dto.ItemListDTO;
import dto.QuantifiedItemDTO;
import dto.SaleDTO;
import dto.UpdateDTO;
import integration.DiscountHandler;

public class Cost {
	private double cost6;
	private double cost12;
	private double cost25;
	private double discount;
	private DiscountHandler discounter;

	/**
	 * increases the cost and vat with values from an added item
	 * 
	 * @param item
	 *            - DTO that stores the quantity,cost and vat used
	 */
	public Cost() {
		cost6 = 0;
		cost12 = 0;
		cost25 = 0;
		discount = 0;
		discounter = new DiscountHandler();
	}

	/**
	 * adds the cost calculated from item and returns an updateDTO containing item,
	 * cost and vat
	 * 
	 * @param item
	 *            <Code>QuantifiedItemDTO</Code> descirbing the item which price *
	 *            quantity should be added to cost
	 * @return
	 */
	public UpdateDTO addCost(QuantifiedItemDTO item) {
		calculateNewCost(item);
		return new UpdateDTO(item, getCost(), getVat());
	}

	private void calculateNewCost(QuantifiedItemDTO item) {
		switch (item.getVatRate()) {
		case 6:
			cost6 += item.getPrice() * item.getQuantity();
			break;
		case 12:
			cost12 += item.getPrice() * item.getQuantity();
			break;
		case 25:
			cost25 += item.getPrice() * item.getQuantity();
		}
	}

	/**
	 * generates a discount based upon customerID and items, and then aplies the
	 * discount to the cost
	 * 
	 * @param items ItemListDTO with items used to calculate discount
	 * @param customerID String of customerID used to calculate discount	
	 */
	public void applyDiscount(ItemListDTO items, String customerID) {
		applyDiscount(discounter.generateDiscount(items, customerID));
	}

	/**
	 * applies discount to the cost
	 * 
	 * @param discount Discount object describing the discount to apply to cost
	 */
	public void applyDiscount(Discount discount) {
		double costBefore = getCost();
		cost6 -= discount.getDiscountVat6() + discount.getBigDiscount() * cost6 / costBefore;
		cost12 -= discount.getDiscountVat12() + discount.getBigDiscount() * cost12 / costBefore;
		cost25 -= discount.getDiscountVat25() + discount.getBigDiscount() * cost25 / costBefore;
		this.discount = discount.getDiscountVat6() + discount.getDiscountVat12() + discount.getDiscountVat25()
				+ discount.getBigDiscount();
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost6 + cost12 + cost25;
	}

	/**
	 * @return the vat
	 */
	public double getVat() {
		return cost6 * 0.06 + cost12 * 0.12 + cost25 * 0.25;
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}
	/**
	 * resets the cost class so that the cost and dicount = 0
	 */
	public void resetCost() {
		cost6 = 0;
		cost12 = 0;
		cost25 = 0;
		discount = 0;
	}

	/**
	 * generates a SaleDTO for current sale
	 * 
	 * @param itemsDTO List of QuantifiedItemDTOs in current sale
	 * @return
	 */
	public SaleDTO getSalesDTO(ItemListDTO itemsDTO) {
		return new SaleDTO(getCost(), getVat(), getDiscount(), itemsDTO);
	}
}