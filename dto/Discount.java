package dto;

public class Discount {
	double vat6;
	double vat12;
	double vat25;
	double bigDiscount;
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
