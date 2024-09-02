package com.boot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.sbean.Employee;

@Repository("edaoimp")
public class EmployeeDAOImpl implements EmployeeDAOI {

	private static final String GET_EMPS_QUERY = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMPLOYEE03 WHERE JOB IN(?,?,?) ORDER BY JOB";

	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = new ArrayList<Employee>();
		try (Connection con = ds.getConnection()) {
			PreparedStatement psmt = con.prepareStatement(GET_EMPS_QUERY);

			// set Values
			psmt.setString(1, desg1);
			psmt.setString(2, desg2);
			psmt.setString(3, desg3);

			// query execute
			try (ResultSet rs = psmt.executeQuery()) {
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEmpid(rs.getInt(1));
					emp.setEmpName(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setDeptno(rs.getInt(4));
					emp.setSalary(rs.getDouble(5));
					list.add(emp);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
