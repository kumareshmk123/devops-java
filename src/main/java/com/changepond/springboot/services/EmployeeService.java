package com.changepond.springboot.services;

import java.util.List;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.changepond.springboot.hbm.Employee;

import dto.EmployeeDTO;
import dto.PayslipDTO;

public interface EmployeeService {

    public List<Employee> getEmployeeList();
	public EmployeeDTO insertEmployee(EmployeeDTO employeeDTO);
	 public EmployeeDTO edit(int id);
	   public Employee delete(int id);
		public EmployeeDTO update(int id,EmployeeDTO employeeDTO);
		public PayslipDTO dispalyPayslip(int id);
	

}
