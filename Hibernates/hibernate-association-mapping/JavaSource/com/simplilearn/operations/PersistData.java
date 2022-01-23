package com.simplilearn.operations;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.entity.Course;
import com.simplilearn.entity.Student;

public class PersistData {
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Course java = new Course("Learn Java", "Programming in Java");
		Course phython = new Course("Explore Phython", "Basics of phyton");
		Course javaScript = new Course("Ace javaScript", "Advacned JS Course");

		List<Course> courses1 = Arrays.asList(java, phython);
		List<Course> courses2 = Arrays.asList(java, javaScript);
		List<Course> courses3 = Arrays.asList(phython);

		Student student1 = new Student("Adam GilChrist", "adam@gmail.com", courses1);
		Student student2 = new Student("Rick Pointing", "ricky@gmail.com", courses2);
		Student student3 = new Student("Brian Lara", "brian@gmail.com", courses3);

		session.save(student1);
		session.save(student2);
		session.save(student3);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
