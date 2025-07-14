package com.prince.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prince.entity.StudentEntity;
import com.prince.service.IStudentService;

/**
 * This class implements CommandLineRunner which makes it a special
 * Spring Boot component that runs automatically at application startup.
 *
 * It is very useful for testing, initializing data, or triggering tasks
 * after the Spring context has been fully loaded.
 */
@Component // Marks this as a Spring component so it gets picked up and managed by Spring container
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IStudentService stdServ; // Injects your student service bean

	/**
	 * This method runs automatically after the Spring Boot app starts.
	 * The 'args' are command line arguments passed to the app (not used here).
	 */
	@Override
	public void run(String... args) throws Exception {

		/*
		 * Register new Student
		 * - Creates a new StudentEntity object with name & class
		 * - Passes it to the service which saves it in the database
		 */
//		 StudentEntity std = new StudentEntity(null, "Ravi", "11th");
//		 System.out.println(stdServ.registerStudent(std));

		/*
		 * Find all Students
		 * - Calls the service to fetch all student records from the DB
		 * - Prints each student record to console
		 */
//		 stdServ.showStudents().forEach(System.out::println);

		/*
		 * Edit student name by id
		 * - Changes the student name for given id and prints confirmation message
		 */
//		 String msg = stdServ.editStudent(2L, "Pappu");
//		 System.out.println(msg);

		/*
		 * Remove student by id
		 * - Deletes the student record with the given id
		 */
		String msg = stdServ.removeStudent(2L);
		System.out.println(msg);
	}
}
