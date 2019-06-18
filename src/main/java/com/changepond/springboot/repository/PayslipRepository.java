package com.changepond.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.changepond.springboot.hbm.Payslip;

	@Repository
	public interface PayslipRepository extends CrudRepository<Payslip, Integer>{

}
