package com.prince.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prince.entity.StudentEntity;
import com.prince.repository.StudentRepository;

/**
 * This is the Service Layer implementation class.
 * It contains the business logic for handling Student operations.
 *
 * It uses the injected StudentRepository to perform database operations.
 */
@Service // Marks this class as a Spring service bean (picked up via @ComponentScan)
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository stdRepo; // Spring injects the repository implementation (proxy)

	/**
	 * Registers (saves) a new student record into the database.
	 *
	 * @param std The student entity to save.
	 * @return Success or failure message.
	 */
	@Override
	public String registerStudent(StudentEntity std) {
		StudentEntity saved = stdRepo.save(std); // save() handles both insert and update
		return saved != null ? "Registration Successful." : "Registration Failed.";
	}

	/**
	 * Fetches all student records from the database.
	 *
	 * @return List of students.
	 */
	@Override
	public List<StudentEntity> showStudents() {
		List<StudentEntity> students = stdRepo.findAll();
		return students; // findAll() never returns null, it returns empty list if no records
	}

	/**
	 * Updates the name of a student for the given ID.
	 *
	 * @param id The student's ID.
	 * @param name The new name to set.
	 * @return Outcome message.
	 */
	@Override
	public String editStudent(Long id, String name) {
		// findById returns Optional, orElseThrow throws exception if not found
		StudentEntity std = stdRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("No record with this ID found"));

		std.setName(name); // update name
		stdRepo.save(std); // save updated record
		return "Student Updated Successfully";
	}

	/**
	 * Deletes a student record by ID.
	 *
	 * @param id The student's ID.
	 * @return Outcome message.
	 */
	@Override
	public String removeStudent(Long id) {
		StudentEntity std = stdRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("No record with this ID found"));

		stdRepo.deleteById(id); // deletes the record
		return "Student deleted Successfully";
	}
}
