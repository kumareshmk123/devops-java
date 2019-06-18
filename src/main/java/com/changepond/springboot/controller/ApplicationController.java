package com.changepond.springboot.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.changepond.springboot.hbm.Employee;
import com.changepond.springboot.services.EmployeeServiceImpl;

import dto.EmployeeDTO;
import dto.PayrollDTO;
import dto.PayslipDTO;

@Controller
public class ApplicationController {

	@Autowired
	EmployeeServiceImpl employeeservice;

	@RequestMapping("/")

	public String home(Model model) {

		List<Employee> list = employeeservice.getEmployeeList();

		model.addAttribute("employee", list);

		return "home";
	}

	
	 @GetMapping("/display")
	 
	  public String adduser(EmployeeDTO employeeDTO) {
	  
	  return "display"; }
	 

	@GetMapping("/userDetail")

	public String userDetails() {
		return "userDetail";
	}

	@RequestMapping(value = "/insertemp", method = RequestMethod.POST)

	public String insert(@Valid EmployeeDTO employeeDTO, BindingResult result, Model model) {

		if (result.hasErrors()) {

			return "display";

		}
		employeeservice.insertEmployee(employeeDTO);

		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {

		employeeservice.delete(id);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable("id") int id, Model model) {

		EmployeeDTO emp = employeeservice.edit(id);

		model.addAttribute("employeeDTO", emp);

		return "edit";
	}

	@RequestMapping(value = "/insertpayroll/{id}", method = RequestMethod.GET)
	public String payroll(@PathVariable("id") int id, PayrollDTO payrollDTO, Model model) {
		model.addAttribute("empid", id);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(id);
		payrollDTO.setEmployeedto(employeeDTO);
		return "payroll";

	}

	@RequestMapping(value = "/payroll", method = RequestMethod.POST)

	public String insertPayroll(@Valid PayrollDTO payrollDTO, BindingResult result, Model model) {

		if (result.hasErrors()) {

			return "payroll";

		}
		employeeservice.insertPayroll(payrollDTO);

		return "redirect:/";
	}

	

	@RequestMapping(value = "/getpayslip{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<PayslipDTO> getPayslip(@PathVariable("id") int id) {

		PayslipDTO pdto = employeeservice.dispalyPayslip(id);

		return new ResponseEntity<PayslipDTO>(pdto, HttpStatus.OK);

	}

	@PostMapping("/editEmp/{id}")
	public String updateUser(@PathVariable("id") int id, @Valid EmployeeDTO employeeDTO, BindingResult result,
			Model model) {

		if (result.hasErrors()) {

			return "edit";
		}

		employeeservice.update(id, employeeDTO);

		return "redirect:/";
	}

}
