package dto;

public class Payment {
	private double amount;
	public Payment(double amount) {
		this.amount = amount;
	}
	/**
	 * 
	 * @return the payment amount
	 */
	public double getAmount() {
		return amount;
	}
}
