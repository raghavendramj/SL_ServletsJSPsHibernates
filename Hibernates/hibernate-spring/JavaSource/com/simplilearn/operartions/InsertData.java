package com.simplilearn.operartions;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.simplilearn.dao.EmployeeDao;
import com.simplilearn.entity.Employee;

public class InsertData {

	public static void main(String[] args) {
		
//		Resource resource = new ClassPathResource("applicationContext.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDao employeeDAO = (EmployeeDao) context.getBean("employeeDao");
		
		//CREATE, READ, UPDATE, DELETE
		
		//Save the employee
		Employee employee1 = new Employee("Johs Haz", 25000);
		employeeDAO.saveEmployee(employee1);

		// Get All Employees
		List<Employee> employees = employeeDAO.getEmployees();
		
		System.out.println("Employees List "+ employees);

		// Get a specific employee
		Employee employee = employeeDAO.getEmployeeById(1);
		System.out.println("employee by id "+ employee);
		
		//Delete the employee
		employeeDAO.deleteEmployee(employee);

	}
}
