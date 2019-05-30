package dto;

/**
 * an itemDTO describing an item
 * 
 * @author Linus Johannisson
 *
 */
public class ItemDTO {
	protected String description;
	protected double price;
	protected int vatRate;

	/**
	 * initializes ItemDTO
	 * 
	 * @param description
	 *            string describing the item
	 * @param price
	 *            double describing the price
	 * @param vatRate
	 *            int describing the vatrate
	 */
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
	/**
	 * returns if item is equal to this
	 * @param item
	 * @return <true> if price and description match, else <false>
	 */
	private boolean equals(ItemDTO item) {
		return getDescription() == item.getDescription() && getPrice() == item.getPrice();
	}
}
