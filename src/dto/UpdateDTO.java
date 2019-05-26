package dto;

public class UpdateDTO {
	private QuantifiedItemDTO item;
	private double cost;
	private double vat;

	public UpdateDTO(QuantifiedItemDTO item, double cost, double vat) {
		this.item = item;
		this.cost = cost;
		this.vat = vat;
	}

	/**
	 * @return the item
	 */
	public QuantifiedItemDTO getItem() {
		return item;
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

}
