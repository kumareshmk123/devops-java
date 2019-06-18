package dto;

public class PayslipDTO {

	private double grossSalary,incomeTax,netPay;
	private int id;

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	}

