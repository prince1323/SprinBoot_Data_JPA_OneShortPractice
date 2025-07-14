package com.prince.service;

import java.util.List;
import com.prince.entity.StudentEntity;

/**
 * This is the Service Layer Interface for StudentEntity operations.
 * 
 * - It defines the business operations (contract) related to Student.
 * - The implementation class (like StudentServiceImpl) will provide
 *   the actual logic for each of these methods.
 * 
 * Why have a service interface?
 * - It helps to decouple the controller/runner from the data access layer.
 * - Makes the code easier to maintain, test, and replace implementations if needed.
 */
public interface IStudentService {

	/**
	 * Registers (saves) a new student into the database.
	 *
	 * @param std - The student entity to be saved.
	 * @return A confirmation message.
	 */
	public String registerStudent(StudentEntity std);

	/**
	 * Fetches all student records from the database.
	 *
	 * @return List of StudentEntity objects.
	 */
	public List<StudentEntity> showStudents();

	/**
	 * Deletes a student from the database based on their ID.
	 *
	 * @param id - The primary key (ID) of the student to delete.
	 * @return A message indicating success or failure.
	 */
	public String removeStudent(Long id);

	/**
	 * Updates the name of a student with the given ID.
	 *
	 * @param id - The ID of the student to update.
	 * @param name - The new name to set.
	 * @return A message indicating the outcome.
	 */
	public String editStudent(Long id, String name);
}
