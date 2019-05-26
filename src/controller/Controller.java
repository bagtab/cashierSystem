	package controller;

import dto.FinalizedSalesLog;
import dto.ItemDTO;
import dto.Payment;
import dto.QuantifiedItemDTO;
import dto.SaleDTO;
import dto.UpdateDTO;
import integration.Inventory;
import model.Register;
import model.Sale;

public class Controller {
	private Inventory itemRegistry;
	private Register register;
	private Sale sale;
	private int quantity;
	public Controller() {
		itemRegistry = new Inventory();
		register = new Register();
		quantity = 1;
	}
	public void startNewSale() {
		// TODO Auto-generated method stub
		sale = new Sale();
	}
	public void scanManyItems(int quantity) {
		// TODO Auto-generated method stub
		this.quantity = quantity;
	}
	public UpdateDTO scanItem(int itemID) {
		QuantifiedItemDTO item = generateQuantifiedItem(itemID);
		return sale.addItem(item);
	}
	public Payment payAndEndSale(double payment) {
		Payment inPayment = new Payment(payment);
		SaleDTO salesLog = sale.getSaleDTO();
		Payment change = new Payment(inPayment.getAmount() - salesLog.getCost());
		FinalizedSalesLog finalSalesLog = new FinalizedSalesLog(inPayment, salesLog);
		register.endSale(finalSalesLog);
		return change;
	}
	
	
	/**
	 * @param itemID
	 * @return
	 */
	private QuantifiedItemDTO generateQuantifiedItem(int itemID) {
		ItemDTO itemData = itemRegistry.findItem(itemID);
		QuantifiedItemDTO item = new QuantifiedItemDTO(itemData, quantity);
		quantity = 1;
		return item;
	}
	public double applyDiscount(String customerID) {
		return sale.applyDiscount(customerID);
	}
}
