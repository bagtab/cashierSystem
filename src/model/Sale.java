package model;

import dto.QuantifiedItemDTO;
import dto.SaleDTO;
import dto.UpdateDTO;
import integration.DiscountHandler;

public class Sale {
	private DiscountHandler discounter;
	private Cost cost;
	private ItemList itemList;

	public Sale() {
		// TODO Auto-generated constructor stub
		discounter = new DiscountHandler();
		cost = new Cost();
		itemList = new ItemList();
	}

	public UpdateDTO addItem(QuantifiedItemDTO item) {
		// TODO Auto-generated method stub
		
		itemList.addItem(item);
		cost.addCost(item);
		
		return new UpdateDTO(item, cost.getCost(), cost.getVat());
	}

	public double applyDiscount(String customerID) {
		cost.applyDiscount(discounter.generateDiscount(getSaleDTO(), customerID));
		return cost.getCost();
	}
	public SaleDTO getSaleDTO() {
		return new SaleDTO(cost.getCost(), cost.getVat(), cost.getDiscount(), itemList.getItems());
		
	}
}
