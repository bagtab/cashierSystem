package dto;

import java.util.Iterator;
import java.util.LinkedList;
public class ItemListDTO {
	private LinkedList<QuantifiedItemDTO> items;
	public ItemListDTO(LinkedList<QuantifiedItemDTO> itemList) {
		items = itemList;
	}
	public QuantifiedItemDTO getDTO(int i){
		return items.get(i);
	}
	public int getSize() {
		return items.size();
	}
	public Iterator<QuantifiedItemDTO> getIterator() {
		return items.iterator();
	}
}
