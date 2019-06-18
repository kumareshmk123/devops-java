package com.changepond.springboot.hbm;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "payslip")
public class Payslip {
	
	
	
	
	 @Column(name = "GS", nullable=true)
	 private double grossSalary;
	
	 @Column(name = "income_tax", nullable=true)
	 private double incomeTax;
	
	 @Column(name = "net_salary", nullable=true)
	 private double netPay;
	

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Payroll payroll;
	
	 @GenericGenerator(name = "generator", strategy = "foreign", 
	 parameters = @Parameter(name = "property", value = "payroll"))
	
	 @GeneratedValue(generator = "generator")
		@Column(name = "pid", nullable=false,unique =true)
		@Id
		private int id;
	

	public double getGrossSalary() {
		return grossSalary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Payroll getPayroll() {
		return payroll;
	}
	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}
	
}
