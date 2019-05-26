package dto;

public class ItemDTO {
	private String description;
	private double price;
	private int vatRate;

	public ItemDTO(String description, double price, int vatRate) {
		this.description = description;
		this.price = price;
		this.vatRate = vatRate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the vatRate
	 */
	public int getVatRate() {
		return vatRate;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ItemDTO) {
			return equals((ItemDTO) o);
		}
		return false;
	}

	private boolean equals(ItemDTO item) {
		return getDescription() == item.getDescription();
	}
}
