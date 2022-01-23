package com.simplilearn.operations;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.entity.Mobile;

public class StoreDataMapExample {

	public static void main(String[] args) {

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Map<String, String> features1 = new HashMap<String, String>();
		features1.put("ROM", "256 GB");
		features1.put("RAM", "12 GB");
		features1.put("Company", "OnePlus");
		Mobile mobile1 = new Mobile("10 Pro", features1);
		session.save(mobile1);

		Map<String, String> features2 = new HashMap<String, String>();
		features2.put("ROM", "1024 GB");
		features2.put("RAM", "16 GB");
		features2.put("Company", "Apple");
		Mobile mobile2 = new Mobile("14 Pro", features2);
		
		
		session.save(mobile2);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
