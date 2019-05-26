package integration;

import java.util.HashMap;

import dto.ItemDTO;

public class Inventory {	
	private HashMap<Integer, ItemDTO> database;
	public Inventory() {
		database = new HashMap<Integer, ItemDTO>();
		init();
	}
	
	public ItemDTO findItem(int itemID) {
		// TODO Auto-generated method stub
		ItemDTO item = database.get(itemID);
		return item;
	}
	/**
	 * generates an existing databse used to test the program
	 */
	private void init() {
		ItemDTO[] items = new ItemDTO[6];
		items[0] = new ItemDTO("hotdogs", 25, 12);
		items[1] = new ItemDTO("milk", 11, 12);
		items[2] = new ItemDTO("newspaper", 10, 6);
		items[3] = new ItemDTO("ciggaretes", 60, 25);
		items[4] = new ItemDTO("potatoes", 0.01, 12);
		items[5] = new ItemDTO("carrots", 0.02, 12);
		for(int i = 0; i < 6; i++) {
			database.put(i, items[i]);
		}
	}
}
