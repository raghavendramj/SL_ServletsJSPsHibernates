package com.simplilearn.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.entity.Product;

public class PersistData {

	public static void main(String[] args) {

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Employee employee1 = new Employee("Raghav", "M J", "raghav@gmail.com");
		// Employee employee2 = new Employee("Keshav", "Anand", "keshav@gmail.com");
		// session.save(employee1);
		// session.save(employee2);

		Product dalThadka = new Product("Dal Thadka", "10", "2.00");
		Product idlySambar = new Product("Idly Sambar ", "2", "1.00");

		session.save(dalThadka);
		session.save(idlySambar);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
