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

	/**
	 * Initializes a new sale
	 */
	public void startNewSale() {
		sale = new Sale();
	}

	/**
	 * prepares to add multiple items
	 * 
	 * @param quantity
	 *            amount of scanned items
	 */
	public void scanManyItems(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param itemID
	 *            integer representation of an itemID
	 * @return UpdateDTO consisting of last added item and current price
	 */
	public UpdateDTO scanItem(int itemID) {
		QuantifiedItemDTO item = generateQuantifiedItem(itemID);
		return sale.addItem(item);
	}

	/**
	 * pays for the current sale and returns the change
	 * 
	 * @param payment
	 *            money that customer pays for sale
	 * @return Change to give to customer in a PaymentObject
	 */
	public double payAndEndSale(double payment) {
		Payment inPayment = new Payment(payment);
		SaleDTO salesLog = sale.getSaleDTO();
		FinalizedSalesLog finalSalesLog = new FinalizedSalesLog(inPayment, salesLog);
		register.endSale(finalSalesLog);
		return inPayment.getAmount() - getCost();
	}

	/**
	 * @param itemID
	 *            integer identification for a specific item
	 * @return QuantifiedItem with quantity of item and ItemDTO
	 */
	private QuantifiedItemDTO generateQuantifiedItem(int itemID) {
		ItemDTO itemData = itemRegistry.findItem(itemID);
		QuantifiedItemDTO item = new QuantifiedItemDTO(itemData, quantity);
		quantity = 1;
		return item;
	}

	/**
	 * applies the discount and returns new cost
	 * 
	 * @param customerID
	 * @return cost after discounts
	 */
	public double applyDiscount(String customerID) {
		sale.applyDiscount(customerID);
		return getCost();
	}

	/**
	 * returns the current cost
	 * 
	 * @return cost of current sale
	 */
	private double getCost() {
		return sale.getSaleDTO().getCost();
	}
}
