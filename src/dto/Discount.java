package dto;

public class Discount {
	private double vat6;
	private double vat12;
	private double vat25;
	private double bigDiscount;
	/**
	 * Creates a discount
	 * @param bigDiscount percentage discount applied to the price
	 * @param vat25 discount on vat25 values
	 * @param vat12 discount on vat12 values
	 * @param vat6 discount on vat6 values
	 */
	public Discount(double vat6, double vat12, double vat25, double bigDiscount) {
		this.vat6 = vat6;
		this.vat12 = vat12;
		this.vat25 = vat25;
		this.bigDiscount = bigDiscount;
	}
	/**
	 * @return the vat6
	 */
	public double getDiscountVat6() {
		return vat6;
	}
	/**
	 * @return the vat12
	 */
	public double getDiscountVat12() {
		return vat12;
	}
	/**
	 * @return the vat25
	 */
	public double getDiscountVat25() {
		return vat25;
	}
	/**
	 * @return the bigDiscount
	 */
	public double getBigDiscount() {
		return bigDiscount;
	}
}
