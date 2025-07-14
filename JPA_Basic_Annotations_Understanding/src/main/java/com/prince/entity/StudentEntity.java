package com.prince.entity;

// JPA & Jakarta Persistence imports
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Lombok imports
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * This class represents a JPA Entity mapped to a database table.
 * It is a POJO (Plain Old Java Object) that Spring Data JPA / Hibernate
 * will use to persist data into the database.
 */
@Entity // Marks this class as a JPA entity, meaning it will be mapped to a database table
@Table(name = "Practice_Table_Student_JPA") // Specifies the name of the database table
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode automatically
@AllArgsConstructor // Lombok to generate constructor with all fields
@RequiredArgsConstructor // Lombok to generate constructor with required (final or @NonNull) fields
public class StudentEntity 
{
	/**
	 * This field will be used as the primary key column in the database table.
	 * - @Id marks it as the primary key.
	 * - @GeneratedValue with SEQUENCE strategy means the value will be generated
	 *   using a database sequence (auto increment like).
	 */
	@Id // Makes this field the primary key
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE) 
	private Long id;

	/**
	 * Maps this field to a database column named "std_name" with max length of 20 characters.
	 */
	@Column(name = "std_name", length = 20) 
	private String name;

	/**
	 * Maps this field to a database column named "std_class" with max length of 10 characters.
	 */
	@Column(name = "std_class", length = 10) 
	private String std_class;

	/*
	 * Note: Because of Lombok's @Data, you do NOT have to manually write:
	 * - getters/setters
	 * - toString()
	 * - equals() and hashCode()
	 * They are auto-generated at compile time.
	 *
	 * The @AllArgsConstructor and @RequiredArgsConstructor automatically generate constructors.
	 * This makes your code clean and maintainable.
	 */
}
