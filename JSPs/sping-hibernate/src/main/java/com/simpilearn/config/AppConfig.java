package com.simpilearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.simpilearn.model.Bank;
import com.simpilearn.model.Bike;
import com.simpilearn.model.Car;
import com.simpilearn.model.HDFCBank;
import com.simpilearn.model.ICICIBank;
import com.simpilearn.model.Profile;
import com.simpilearn.model.Student;
import com.simpilearn.model.Vehicle;

@Configuration
@ComponentScan("com")
public class AppConfig {

	@Bean
	public Bank iciciBank() {
		return new ICICIBank();
	}

	@Bean
	public Bank hdfcBank() {
		return new HDFCBank();
	}

	@Bean
	public Vehicle bike() {
		return new Bike();
	}

	@Bean
	public Vehicle car() {
		return new Car();
	}

	@Bean
	public Profile profile() {
		return new Profile();
	}

	@Bean
	@Primary
	public Student student1() {
		Student student = new Student();
		student.setAge(25);
		student.setName("Raghav");
		return student;
	}

	@Bean
	public Student student2() {
		Student student = new Student();
		student.setAge(25);
		student.setName("Keshav");
		return student;
	}
}
