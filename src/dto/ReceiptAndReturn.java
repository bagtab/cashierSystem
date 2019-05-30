package dto;

import model.Receipt;

public class ReceiptAndReturn {
	private Receipt receipt;
	private double cashReturn;
	/**
	 * initializes a ReceiptAndReturn
	 * @param receipt
	 * @param cashReturn
	 */
	public ReceiptAndReturn(Receipt receipt, double cashReturn) {
		this.receipt = receipt;
		this.cashReturn = cashReturn;
	}
	/**
	 * @return the receipt
	 */
	public Receipt getReceipt() {
		return receipt;
	}
	/**
	 * @return the cashReturn
	 */
	public double getCashReturn() {
		return cashReturn;
	}
	
}
