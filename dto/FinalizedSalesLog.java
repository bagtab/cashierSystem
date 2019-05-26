package dto;

public class FinalizedSalesLog {
	SaleDTO salesLog;
	Payment payment;
	public FinalizedSalesLog(Payment inPayment, SaleDTO salesLog) {
		this.salesLog = salesLog;
		payment = inPayment;
	}
	/**
	 * @return the salesLog
	 */
	public SaleDTO getSalesLog() {
		return salesLog;
	}
	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}
	
	
}
