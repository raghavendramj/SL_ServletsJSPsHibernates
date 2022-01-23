package com.simplilearn.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.entity.Address;
import com.simplilearn.entity.Employee;

public class PersistData {
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Address bangalore = new Address("BN", "KA", 565656);
		Address mysore = new Address("MYS", "KA", 523121);

		Employee john = new Employee("John Doe", bangalore);
		Employee adam = new Employee("Paul Adams", mysore);

		session.save(john);
		session.save(adam);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
