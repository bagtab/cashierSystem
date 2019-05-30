package model;

import java.util.LinkedList;

import dto.ItemListDTO;
import dto.QuantifiedItemDTO;

public class ItemList {
	private LinkedList<QuantifiedItem> items;
	public ItemList() {
		items = new LinkedList<QuantifiedItem>();
	}
	public void addItem(QuantifiedItemDTO item) {
		// TODO Auto-generated method stub
		addItem(new QuantifiedItem(item));
	}
	private void addItem(QuantifiedItem item) {
		addOrIncreaseQuantity(item);
	}
	private void addOrIncreaseQuantity(QuantifiedItem item) {
		if(items.contains(item)) {
			increaseQuantity(item);			
		}
		else {
			addNewItem(item);
		}
	}
	private void increaseQuantity(QuantifiedItem item) {
		QuantifiedItem itemInList = items.get(items.indexOf(item));
		int currQuantity = itemInList.getQuantity();
		itemInList.increaseQuantity(item.getQuantity());
		item.increaseQuantity(currQuantity);
	}
	private void addNewItem(QuantifiedItem item) {
		items.add(item);
	}
	public ItemListDTO getItems() {
		// TODO Auto-generated method stub
		return generateListOfDTO();
	}
	private ItemListDTO generateListOfDTO() {
		LinkedList<QuantifiedItemDTO> itemsDTO = new LinkedList<QuantifiedItemDTO>();
		for(QuantifiedItem itemToConvert:items) {
			itemsDTO.add(new QuantifiedItemDTO(itemToConvert.getItemData(), itemToConvert.getQuantity()));
			
		}
		System.out.print(itemsDTO.getFirst().getPrice());
		return new ItemListDTO(itemsDTO);
	}
	
}
