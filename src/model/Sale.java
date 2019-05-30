package model;

import dto.ItemListDTO;
import dto.QuantifiedItemDTO;

public class Sale {
	private ItemList itemList;

	public Sale() {
		itemList = new ItemList();
	}

	public void addItem(QuantifiedItemDTO item) {
		// TODO Auto-generated method stub
		
		itemList.addItem(item);
	}
	public ItemListDTO getItemsDTO() {
		return itemList.getItems();
		
	}
}
