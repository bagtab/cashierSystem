package model;

import dto.ItemDTO;
import dto.QuantifiedItemDTO;

public class QuantifiedItem {
	private int quantity;
	private ItemDTO itemData;
	public QuantifiedItem(QuantifiedItemDTO item) {
		this.quantity = item.getQuantity();
		this.itemData = new ItemDTO(item.getDescription(), item.getPrice(), item.getVatRate());
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the itemData
	 */
	public ItemDTO getItemData() {
		return itemData;
	}
	/**
	 * @return the vatrate
	 */
	public double getVatRate() {
		return itemData.getVatRate();
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return itemData.getPrice();
	}
	/**
	 * @return the item description
	 */
	public String getDescription() {
		return itemData.getDescription();
	}
	/**
	 * @return QuantifiedItemDTO version of this QuantifiedItem
	 */
	public QuantifiedItemDTO getDTO() {
		return new QuantifiedItemDTO(itemData, quantity);

	}
	/**
	 * @param addedQauntity integer to increase the quantity with
	 */
	public void increaseQuantity(QuantifiedItem item) {
		if(equals(item)) {
			increaseQuantity(item.getQuantity());			
		}
	}
	public void increaseQuantity(int addedQuantity) {
		quantity += addedQuantity;
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof QuantifiedItem) {
			return equals((QuantifiedItem) o);
		}
		return false;
	}
	/**
	 * @param item QuantifiedItem to check equality of
	 * @return	true if the items are the same, else false
	 */
	private boolean equals(QuantifiedItem item) {
		return sameDescription(item) && sameCost(item) && sameVAT(item);
	}
	/**
	 * @param item QuantifiedItem to check if cost is the same
	 * @return true if the item costs are the same, else false
	 */
	private boolean sameCost(QuantifiedItem item) {
		return getPrice() == item.getPrice();
	}
	/**
	 * @param item QuantifiedItem to check if description is the same
	 * @return true if the item descriptions are the same, else false
	 */
	private boolean sameDescription(QuantifiedItem item) {
		return getDescription().equals(item.getDescription());
	}
	/**
	 * @param item QuantifiedItem to check if vatrate is the same
	 * @return true if the item vatrate are the same, else false
	 */
	private boolean sameVAT(QuantifiedItem item) {
		return getVatRate() == item.getVatRate();
	}
}
