package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.boot.sbean.Employee;
import com.boot.sbean.EmployeeServiceI;

@Controller("Payroll")
public class PayrollController {
	
	@Autowired
	private EmployeeServiceI service;
	
	public List<Employee> showAllEmployeesByDesgn(String desg1, String desg2, String desg3) throws Exception{
		
		List<Employee>list=service.fetAllEmployyeeByDesg(desg1, desg2, desg3);
		return list;
	}

}
