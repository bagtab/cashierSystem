package model;

import dto.FinalizedSalesLog;
import dto.Payment;
import integration.Accounting;

/**
 * Register finalizes the sale and stores the amount of money in the register.
 * 
 * @author mrjoh
 *
 */
public class Register {
	private Accounting accounting;
	private String shopName;
	private String address;
	private double presentMoney;
	/**
	 * initializes register
	 */
	public Register() {
		shopName = "Butiken";
		address = "gatgatan 3";
		presentMoney = 0;
		accounting = new Accounting();
	}

	/**
	 * logs relevant data, adds money to register and returns receipt
	 * 
	 * @param finalSalesLog
	 * @return
	 */
	public Receipt endSale(FinalizedSalesLog finalSalesLog) {
		addMoneyToRegistry(finalSalesLog.getPayment());
		Receipt receipt = new Receipt(finalSalesLog, shopName, address);
		accounting.recordSalesLog(finalSalesLog);
		return receipt;
	}

	private void addMoneyToRegistry(Payment payment) {
		presentMoney += payment.getAmount();
	}

	/**
	 * returns the money in the register
	 * 
	 * @return presentMoney
	 */
	public double getPresentMoney() {
		return presentMoney;
	}
}
