package dto;
public class SaleDTO {
	private double cost;
	private double vat;
	private double discount;
	private ItemListDTO items;

	public SaleDTO(double cost, double vat, double discount, ItemListDTO items) {
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
	public ItemListDTO getItems() {
		return items;
	}

}
