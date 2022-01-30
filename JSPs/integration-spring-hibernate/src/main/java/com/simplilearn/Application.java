package com.simplilearn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simplilearn.config.AppConfig;
import com.simplilearn.entity.Employee;
import com.simplilearn.service.EmployeeService;

public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		
		
//		Employee vikas = new Employee("Vikas", "Panwar", "vikas.panwar@gmail.com");
//		employeeService.createEmployee(vikas);
		
		Employee kumar = new Employee("Kumar", "Kushagara", "Kumar.Kushagara@gmail.com");
		employeeService.createEmployee(kumar);
		
		
		List<Employee> employees = employeeService.fetchAllEmployees();
		for (Employee employee : employees) {
			System.out.println("Each Employee : " + employee);
		}
	}
}
