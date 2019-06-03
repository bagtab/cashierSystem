package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.ItemDTO;
import dto.QuantifiedItemDTO;
import model.QuantifiedItem;

class QuantifiedItemTest {
	private ItemDTO[]items = new ItemDTO[5];
	@BeforeEach
	void setup() {
		items[0] = new ItemDTO("ball", 20, 6);
		items[1] = new ItemDTO("frisbee", 20, 6);
		items[2] = new ItemDTO("ball", 19, 6);
		items[3] = new ItemDTO("ball", 20, 12);
		items[4] = new ItemDTO("ball", 20, 6);
	}
	@Test
	void testEqual() {
		QuantifiedItem item = new QuantifiedItem(new QuantifiedItemDTO(items[0], 4));
		try{
			assertNotEquals(item, null,"Comparing to a Null object gives true");
		}catch(NullPointerException exception){
			fail("threw excepton when compared to null item");
		}
		QuantifiedItem comparedItem = new QuantifiedItem(new QuantifiedItemDTO(items[0], 3));
		assertEquals(item, comparedItem,"missmatching quantity gave mismatch");
		comparedItem = new QuantifiedItem(new QuantifiedItemDTO(items[4], 4));
		assertEquals(item, comparedItem,"different instance gave mismatch");
		comparedItem = new QuantifiedItem(new QuantifiedItemDTO(items[1], 4));
		assertNotEquals(item, comparedItem,"different description gave match");
		comparedItem = new QuantifiedItem(new QuantifiedItemDTO(items[2], 4));
		assertNotEquals(item, comparedItem,"different cost gave match");
		comparedItem = new QuantifiedItem(new QuantifiedItemDTO(items[3], 4));
		assertNotEquals(item, comparedItem,"different vat gave match");	
	}
	@Test
	void testIncreseQauntity() {
		QuantifiedItem item = new QuantifiedItem(new QuantifiedItemDTO(items[0], 4));
		QuantifiedItem addedItem = new QuantifiedItem(new QuantifiedItemDTO(items[0], 3));
		item.increaseQuantity(addedItem);
		assertEquals(item.getQuantity(), 7,"quantity not increased when using QuantifiedItem as input");
		item.increaseQuantity(1);
		assertEquals(item.getQuantity(), 8,"quantity not increased when using integer as input");
		addedItem = new QuantifiedItem(new QuantifiedItemDTO(items[1], 3));
		item.increaseQuantity(addedItem);
		assertEquals(item.getQuantity(), 8,"quantity was increased when using mismatching QuantifiedItem as input");
	}
}
