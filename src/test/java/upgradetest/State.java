package upgradetest;

import java.math.BigDecimal;

public class State {

	private String label;
	private String abbreviation;
	private int minLoanAmount;
	private int minAge;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public int getMinLoanAmount() {
		return minLoanAmount;
	}

	public void setMinLoanAmount(int  minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	@Override
	public String toString() {
		return "State [label=" + label + ", abbreviation=" + abbreviation + ", minLoanAmount=" + minLoanAmount
				+ ", minAge=" + minAge + "]";
	}

}
