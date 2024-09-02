package com.boot.sbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.EmployeeDAOI;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeDAOI dao;

	@Override
	public List<Employee> fetAllEmployyeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = dao.getEmployeeByDesgs(desg1, desg2, desg3);
		return list;
	}

}
