package dto;


public class PayrollDTO {

	  private int id,year;
	  private double basicSalary,hra,da;
	  private String month;
	  private EmployeeDTO employeedto;
	  private PayslipDTO payslips;
	  
	  public PayslipDTO getPayslips() {
		return payslips;
	}
	public void setPayslips(PayslipDTO payslips) {
		this.payslips = payslips;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getDa() {
		return da;
	}
	public void setDa(double da) {
		this.da = da;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public EmployeeDTO getEmployeedto() {
		return employeedto;
	}
	public void setEmployeedto(EmployeeDTO employeedto) {
		this.employeedto = employeedto;
	}
	  
	  
}
