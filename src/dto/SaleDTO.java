package dto;

import java.util.LinkedList;

public class SaleDTO {
	double cost;
	double vat;
	double discount;
	LinkedList<QuantifiedItemDTO> items;

	public SaleDTO(double cost, double vat, double discount, LinkedList<QuantifiedItemDTO> items) {
		this.cost = cost;
		this.vat = vat;
		this.discount = discount;
		this.items = items;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @return the vat
	 */
	public double getVat() {
		return vat;
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @return the items
	 */
	public LinkedList<QuantifiedItemDTO> getItems() {
		return items;
	}

}
