package com.changepond.springboot.repository;





import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.changepond.springboot.hbm.Employee;
import com.changepond.springboot.hbm.Payroll;
import com.changepond.springboot.hbm.Payslip;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{


	void save(Payroll payroll);

	void save(Payslip payslip);

	 
		  }
