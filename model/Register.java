package model;

import dto.FinalizedSalesLog;
import dto.Payment;
import integration.Accounting;
import integration.Printer;

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
		// TODO Auto-generated method stub
		addMoneyToRegistry(finalSalesLog.getPayment());
		Receipt receipt = new Receipt(finalSalesLog, shopName, address);
		printer.print(receipt);
		accounting.recordSalesLog(finalSalesLog);
	}
	private void addMoneyToRegistry(Payment payment) {
		// TODO Auto-generated method stub
		presentMoney += payment.getAmount();
	}
}
