package com.boot.dao;

import java.util.List;

import com.boot.sbean.Employee;


public interface EmployeeDAOI {

	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception;
}