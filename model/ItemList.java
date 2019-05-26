package model;

import java.util.LinkedList;

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
		items.get(items.indexOf(item)).increaseQuantity(item.getQuantity());
	}
	private void addNewItem(QuantifiedItem item) {
		items.add(item);
	}
	public LinkedList<QuantifiedItemDTO> getItems() {
		// TODO Auto-generated method stub
		return generateListOfDTO();
	}
	private LinkedList<QuantifiedItemDTO> generateListOfDTO() {
		LinkedList<QuantifiedItemDTO> itemsDTO = new LinkedList<QuantifiedItemDTO>();
		for(QuantifiedItem itemToConvert:items) {
			itemsDTO.add(new QuantifiedItemDTO(itemToConvert.getItemData(), itemToConvert.getQuantity()));
			
		}
		System.out.print(itemsDTO.getFirst().getPrice());
		return itemsDTO;
	}
	
}
