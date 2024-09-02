package com.boot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.boot.controller.PayrollController;
import com.boot.sbean.Employee;

@SpringBootApplication
public class BootProject05EmployeeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProject05EmployeeApplication.class, args);

		PayrollController cont = ctx.getBean("Payroll", PayrollController.class);

		// call b.method
		try {
			List<Employee> list = cont.showAllEmployeesByDesgn("MANAGER", "SALEMAN", "CLEAK");
			list.forEach(emp -> {
				System.out.println(emp);
			});

		} catch (Exception e) {

		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
