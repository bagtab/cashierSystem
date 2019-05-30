package dto;

/**
 * a DTO representation of a shoppingitem. since equals is overriden, this is
 * technically not a DTO. this is done to avoid implementing an Item-class which
 * only function would be to override equals
 */
public class QuantifiedItemDTO extends ItemDTO {
	private int quantity;

	public QuantifiedItemDTO(ItemDTO itemData, int quantity) {
		super(itemData.getDescription(), itemData.getPrice(), itemData.getVatRate());
		this.quantity = quantity;
	}
	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
}
