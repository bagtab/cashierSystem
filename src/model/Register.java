package model;

import dto.FinalizedSalesLog;
import dto.Payment;
import integration.Accounting;
import integration.Printer;
/**
 * Register finalizes the sale and stores the amount of money in the register.
 * @author mrjoh
 *
 */
public class Register {
	private Printer printer;
	private Accounting accounting;
	private String shopName;
	private String address;
	private double presentMoney;
	public Register() {
		presentMoney = 0;
		printer = new Printer();
		accounting = new Accounting();
	}
	public void endSale(FinalizedSalesLog finalSalesLog) {
		addMoneyToRegistry(finalSalesLog.getPayment());
		Receipt receipt = new Receipt(finalSalesLog, shopName, address);
		printer.print(receipt);
		accounting.recordSalesLog(finalSalesLog);
	}
	private void addMoneyToRegistry(Payment payment) {
		presentMoney += payment.getAmount();
	}
	/**
	 * returns the money in the register
	 * @return presentMoney
	 */
	public double getPresentMoney() {
		return presentMoney;
	}
}
