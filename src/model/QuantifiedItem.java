package model;

import dto.ItemDTO;
import dto.QuantifiedItemDTO;

public class QuantifiedItem {
	private int quantity;
	private ItemDTO itemData;

	/*public QuantifiedItem(ItemDTO itemData, int quantity) {
		this.quantity = quantity;
		this.itemData = itemData;
	}*/

	public QuantifiedItem(QuantifiedItemDTO item) {
		// TODO Auto-generated constructor stub
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

	public double getVatRate() {
		return itemData.getVatRate();
	}

	public double getPrice() {
		return itemData.getPrice();
	}

	public String getDescription() {
		return itemData.getDescription();
	}
	
	public QuantifiedItemDTO getDTO() {
		return new QuantifiedItemDTO(itemData, quantity);
		
	}
	public void increaseQuantity(int addedQauntity){
		quantity += addedQauntity;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof QuantifiedItem) {
			return equals((QuantifiedItem) o);
		}
		return false;
	}

	private boolean equals(QuantifiedItem item) {
		return sameDescription(item) && sameCost(item) && sameVAT(item);
	}




	private boolean sameCost(QuantifiedItem item) {
		// TODO Auto-generated method stub
		return getPrice() == item.getPrice();
	}

	private boolean sameDescription(QuantifiedItem item) {
		// TODO Auto-generated method stub
		return getDescription().equals(item.getDescription());
	}
	
	private boolean sameVAT(QuantifiedItem item) {
		// TODO Auto-generated method stub
		return getVatRate() == item.getVatRate();
	}
}
