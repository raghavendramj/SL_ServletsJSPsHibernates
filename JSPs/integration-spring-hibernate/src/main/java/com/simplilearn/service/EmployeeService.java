package com.simplilearn.service;

import java.util.List;

import com.simplilearn.entity.Employee;

public interface EmployeeService {
	//CREATE
	void createEmployee(Employee employee);

	//READ By ID
	Employee fetchEmployeeById(Integer employeeId);

	//READ ALL
	List<Employee> fetchAllEmployees();

	//Update
	void updateEmployeeEmailById(String newEmail, Integer employeeId);

	//Delete
	void deleteEmployeeById(Integer employeeId);
}
