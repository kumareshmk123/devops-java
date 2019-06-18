package com.changepond.springboot.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changepond.springboot.hbm.Employee;
import com.changepond.springboot.hbm.Payroll;
import com.changepond.springboot.hbm.Payslip;
import com.changepond.springboot.repository.EmployeeRepository;
import com.changepond.springboot.repository.PayslipRepository;

import dto.EmployeeDTO;
import dto.PayrollDTO;
import dto.PayslipDTO;

@Service
public   class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PayslipRepository payslipRepository;

	public List<Employee> getEmployeeList() {

		List<Employee> empList = new ArrayList<Employee>();

		Iterable<Employee> list = employeeRepository.findAll();

		for (Employee employee : list) {

			empList.add(employee);

		}
		return empList;

	}

	public EmployeeDTO insertEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		
		try {
			BeanUtils.copyProperties(employeeDTO, employee);
			employeeRepository.save(employee);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeDTO;

	}

	public EmployeeDTO edit(int id) {
		
		Optional<Employee> employee = employeeRepository.findById(Integer.valueOf(id));
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		List<PayrollDTO> payrollDTOs = new ArrayList<PayrollDTO>();
		
		try {
		
			BeanUtils.copyProperties(employee.get(),employeeDTO);

		
		    List<Payroll> payrolls = employee.get().getPayroll();
		    
		
		    for (Payroll payroll : payrolls) {
		    	
		    	PayrollDTO pdto = new PayrollDTO();
		    	
		    	BeanUtils.copyProperties(payroll,pdto);
		    	
				payrollDTOs.add(pdto);
				
				PayslipDTO payslipDTO = new PayslipDTO();

				if (payroll.getPayslip() != null) {

					BeanUtils.copyProperties(payroll.getPayslip(),payslipDTO);

				}
				pdto.setPayslips(payslipDTO);
			}

		      employeeDTO.setPayRoll(payrollDTOs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeDTO;

		}
	
	
	
	public EmployeeDTO update(int id,EmployeeDTO employeeDTO) {
		Employee employee = new Employee();

		try {
			BeanUtils.copyProperties(employeeDTO, employee);
			employeeRepository.save(employee);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeDTO;
		    
	}
	@Transactional
	public PayrollDTO insertPayroll(PayrollDTO payrollDTO) {
		Double ba = payrollDTO.getBasicSalary();
		

		double hra=(0.1*ba);
		double da=(0.9*ba);
		payrollDTO.setHra(hra);
		payrollDTO.setDa(da);
		

		Payroll payroll = new Payroll();
		try {
			BeanUtils.copyProperties(payrollDTO, payroll);
			
			Employee employee=employeeRepository.findById(payrollDTO.getEmployeedto().getId()).get();
			payroll.setEmployee(employee);
			employeeRepository.save(payroll);


			double grossPay = payroll.getDa() + payroll.getBasicSalary() + payroll.getHra();
			double incometax = (0.3 * grossPay);
			double netSalary = grossPay - incometax;

			Payslip payslip = new Payslip();
			payslip.setGrossSalary(grossPay);
			payslip.setIncomeTax(incometax);
			payslip.setNetPay(netSalary);
			payslip.setPayroll(payroll);
			employeeRepository.save(payslip);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollDTO;

	}
	
public PayslipDTO dispalyPayslip(int id) {
		
		Optional<Payslip> payslip = payslipRepository.findById(Integer.valueOf(id));
		
		PayslipDTO payslipDTO=new PayslipDTO();
		
		BeanUtils.copyProperties(payslip.get(),payslipDTO);

		return payslipDTO;
}
		
	public Employee delete(int id) {

		employeeRepository.deleteById(Integer.valueOf(id));
		
		return null;
				
	}
	
	
	
}
