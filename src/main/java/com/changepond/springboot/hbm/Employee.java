package com.changepond.springboot.hbm;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id", nullable = false, unique = true)
	private int id;

	@Column(name = "emp_name", nullable = false, length = 100)
	private String name;

	@Column(name = "emp_dob", nullable = false)
	private Date dob;

	@Column(name = "emp_doj", nullable = false)
	private Date doj;

	@Column(name = "emp_salary", nullable = true)
	private double salary;

	@Column(name = "emp_des", nullable = false)
	private String designation;

	@Column(name = "emp_type", nullable = false)
	private int empType;
	
	 @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="employee")
	    private List<Payroll> payroll;
	 
	/* @OneToOne(mappedBy="employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	 private Designation designation;
	 */
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public int getEmpType() {
		return empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

	public List<Payroll> getPayroll() {
		return payroll;
	}

	public void setPayroll(List<Payroll> payroll) {
		this.payroll = payroll;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/*public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}*/
	


}
