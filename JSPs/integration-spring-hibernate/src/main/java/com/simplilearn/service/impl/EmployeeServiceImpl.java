package com.simplilearn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.simplilearn.entity.Employee;
import com.simplilearn.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	PlatformTransactionManager platformTransactionManager;

	public List<Employee> fetchAllEmployees() {
		Session session = sessionFactory.openSession();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		session.close();
		return employees;
	}

	public Employee fetchEmployeeById(Integer employeeId) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);
		session.close();
		return employee;
	}

	@Transactional
	public void createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Integer employeeId = (Integer) session.save(employee);
		if (employeeId > 0) {
			System.out.println("Employee is created with ID = " + employeeId);
		}
		trans.commit();
	}

	@Transactional
	public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		if (employee != null) {
			employee.setEmail(newEmail);
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
			System.out.println("Employee new email is updated..");
		}
		trans.commit();
		session.close();
	}

	public void deleteEmployeeById(Integer employeeId) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);
		if (employee != null) {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
			System.out.println("Employee is deleted with Id = " + employeeId);
		}
		session.close();
	}
}
