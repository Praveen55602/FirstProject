package com.first.springboot.FirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

	// without spring boot we'll have to create a seperate configuration file for
	// telling the spring how to create a bean and which classes are part of it but
	// with spring boot we can just mark them with annotations and don't have to do
	// any configuration
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstProjectApplication.class, args);
		// Employee e = new employee(context.getBean(EmpCreator.class));
		// e.runExaple();

		Employee e = context.getBean(Employee.class); // asking spring to create an object of employee which will be by
														// default a singleton
		e.runExaple();

	}

}
