package com.simplilearn.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.simplilearn.entity.Employee;

public class EmployeeDao {

	HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void saveEmployee(Employee employee) {
		hibernateTemplate.save(employee);
	}

	public void updateEmployee(Employee employee) {
		hibernateTemplate.update(employee);
	}

	public void deleteEmployee(Employee employee) {
		hibernateTemplate.delete(employee);
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = hibernateTemplate.loadAll(Employee.class);
		return employees;
	}

	public Employee getEmployeeById(int employeeId) {
		Employee employee = hibernateTemplate.get(Employee.class, employeeId);
		return employee;
	}
}
