package integration;

import java.util.HashMap;

import dto.ItemDTO;

public class Inventory {
	private HashMap<Integer, ItemDTO> database;
	/**
	 * initializes a new inventory
	 */
	public Inventory() {
		database = new HashMap<Integer, ItemDTO>();
		init();
	}

	/**
	 * returns matching itemDTO to matching itemID
	 * 
	 * @param itemID id of item searched
	 * @return ItemDTO matching the itemID
	 */
	public ItemDTO findItem(int itemID) {
		ItemDTO item = database.get(itemID);
		return item;
	}

	/**
	 * generates an existing database used to simulate the program
	 */
	private void init() {
		ItemDTO[] items = new ItemDTO[6];
		items[0] = new ItemDTO("hotdogs", 25, 12);
		items[1] = new ItemDTO("milk", 11, 12);
		items[2] = new ItemDTO("newspaper", 10, 6);
		items[3] = new ItemDTO("ciggaretes", 60, 25);
		items[4] = new ItemDTO("potatoes", 0.01, 12);
		items[5] = new ItemDTO("carrots", 0.02, 12);
		for (int i = 0; i < 6; i++) {
			database.put(i, items[i]);
		}
	}
}
