package dto;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * DTO that for the items of the current sale
 * 
 * @author mrjoh
 */
public class ItemListDTO {
	private LinkedList<QuantifiedItemDTO> items;

	/**
	 * creates a new ItemList which stores the content of itemList
	 * 
	 * @param itemList
	 *            a list with quantifiedItem
	 */
	public ItemListDTO(LinkedList<QuantifiedItemDTO> itemList) {
		items = itemList;
	}

	/**
	 * extracts an iterator over the QuantifiedItemDTOs in the itemlist
	 * 
	 * @return Iterator<QuantifiedItemDTO> for this itemlist
	 */
	public Iterator<QuantifiedItemDTO> getIterator() {
		return items.iterator();
	}
}
