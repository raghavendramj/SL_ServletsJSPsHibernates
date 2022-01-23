package com.simplilearn.operations;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.entity.Mobile;
import com.simplilearn.entity.User;

public class FetchData {

	public static void main(String[] args) {

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();

		TypedQuery<User> query = session.createQuery("from User");
		List<User> users =  query.getResultList();
		
		System.out.println("Users info : "+ users);
		
		TypedQuery<Mobile> query2 = session.createQuery("from Mobile");
		List<Mobile> mobiles =  query2.getResultList();
		
		System.out.println("Mobiles info : "+ mobiles);
		

		session.close();
		sessionFactory.close();
	}
}
