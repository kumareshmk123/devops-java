package dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;




public class EmployeeDTO {
	
	private int id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	private Date dob;
	private Date doj;
	private double salary;
	private String designation;
	private int empType;
	
  
    private DesignationDTO designations; 

	private List<PayrollDTO> payRoll;

		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public int getEmpType() {
		return empType;
	}
	public void setEmpType(int empType) {
		this.empType = empType;
	}
	public List<PayrollDTO> getPayRoll() {
		return payRoll;
	}
	public void setPayRoll(List<PayrollDTO> payRoll) {
		this.payRoll = payRoll;
	}
	
	 public DesignationDTO getDesignations() {
			return designations;
		}
		public void setDesignations(DesignationDTO designations) {
			this.designations = designations;
		}
}
