package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.Discount;
import dto.ItemDTO;
import dto.QuantifiedItemDTO;
import model.Cost;

class CostTest {
	Cost cost = new Cost();

	@BeforeEach
	void before() {
		cost = new Cost();
	}

	@Test
	void testWith1Item() {
		cost.addCost(new QuantifiedItemDTO(new ItemDTO("newspaper", 12, 6), 1));
		assertEquals(cost.getCost(), 12);
		assertEquals(cost.getVat(), 0.72);
	}
	
	@Test
	void testWithManyItems() {
		fill();
		assertEquals(cost.getCost(), 229);
		assertEquals(cost.getVat(), 42.1);
	}
	@Test
	void testBigDiscount() {
		fill();
		cost.applyDiscount(new Discount(0, 0, 0, 100));
		assertEquals(cost.getCost(), 129);
		assertEquals(cost.getVat(), 23.71572052401747);//is rounded in display
		assertEquals(cost.getDiscount(), 100);
		
	}
	@Test
	void testWithNullInput() {
		fill();
		cost.applyDiscount(null, null);
		assertEquals(cost.getCost(), 229);
		assertEquals(cost.getVat(), 42.1);
		assertEquals(cost.getDiscount(), 0);
		
	}
	@Test
	void testDiverseDiscount() {
		fill();
		cost.applyDiscount(new Discount(5, 5, 5, 0));
		assertEquals(cost.getCost(), 214, "");
		assertEquals(cost.getVat(), 39.95);
		assertEquals(cost.getDiscount(), 15);
	}
	void fill() {
		cost.addCost(new QuantifiedItemDTO(new ItemDTO("newspaper", 12, 6), 1));
		cost.addCost(new QuantifiedItemDTO(new ItemDTO("carrots", 0.02, 12), 2000));
		cost.addCost(new QuantifiedItemDTO(new ItemDTO("cheddar", 59, 12), 1));
		cost.addCost(new QuantifiedItemDTO(new ItemDTO("cigarettes", 59, 25), 2));
	}
}
