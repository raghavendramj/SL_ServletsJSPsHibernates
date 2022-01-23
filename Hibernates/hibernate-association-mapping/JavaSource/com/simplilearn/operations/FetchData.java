package com.simplilearn.operations;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.entity.Course;
import com.simplilearn.entity.Student;

public class FetchData {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();

		TypedQuery<Student> query = session.createQuery("from Student");
		List<Student> students = query.getResultList();

		System.out.println("Students info : " + students);

		TypedQuery<Course> query2 = session.createQuery("from Course c INNER JOIN on c.student_course");
		List<Course> courses = query2.getResultList();

		System.out.println("Course info : " + courses);
		
		
		

		session.close();
		sessionFactory.close();
	}

}
