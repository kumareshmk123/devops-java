package com.changepond.springboot.hbm;

import javax.persistence.*;

@Entity
@Table(name = "payroll")
public class Payroll {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "pid", nullable=false,unique =true)
     private int id;
	
	 @Column(name = "basic_salary", nullable=true)
     private double basicSalary;
	
	 @Column(name = "HRA", nullable=true)
     private double hra;
	 
	 @Column(name = "DA", nullable=true)
     private double da;
	
	 @Column(name = "month", nullable=true)
     private String month;
	
	 @Column(name = "year", nullable=true)
     private int year;
	 
	
	 @ManyToOne
	 @JoinColumn(name="emp_id", nullable=false)
      private Employee employee;
	 
	 @OneToOne(mappedBy="payroll", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	 private Payslip payslip;
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Payslip getPayslip() {
		return payslip;
	}
	public void setPayslip(Payslip payslip) {
		this.payslip = payslip;
	}
	
}
