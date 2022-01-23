package com.simplilearn.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.entity.Student;

public class PersistData {

	public static void main(String[] args) {

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Student kumar = new Student("Kumar", "IN001", "Delhi");
		Student romero = new Student("Romero", "IN002", "France");

		session.save(kumar);
		session.save(romero);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
