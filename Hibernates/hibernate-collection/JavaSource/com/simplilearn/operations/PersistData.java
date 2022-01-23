package com.simplilearn.operations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.entity.Employee_Collection;
import com.simplilearn.entity.Skill;
import com.simplilearn.entity.User;

public class PersistData {

	public static void main(String[] args) {

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		 List<String> hobbies = new ArrayList<String>();
		 hobbies.add("Watcing Cricket!");
		 hobbies.add("Trekking");
		 hobbies.add("Solving Problems");
		
		 User user = new User("John Doe", hobbies);
		 session.save(user);

		List<Skill> skills = new ArrayList<Skill>();
		skills.add(new Skill("Java", "Programming Language"));
		skills.add(new Skill("Jenkins", "DevOps Tool"));
		skills.add(new Skill("Github", "CI CD Tool"));

		Employee_Collection emp = new Employee_Collection("Adam Vans", skills);
		session.save(emp);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
