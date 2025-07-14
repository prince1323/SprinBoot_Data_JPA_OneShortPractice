package com.prince.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prince.entity.StudentEntity;

/**
 * This interface is the Repository layer for the StudentEntity.
 * It extends JpaRepository which provides a complete set of
 * CRUD operations and query methods out-of-the-box.
 */
@Repository // Marks it as a Spring Repository (optional, because JpaRepository already does it internally)
public interface StudentRepository extends JpaRepository<StudentEntity, Long> 
{
    /*
     * Explanation of this interface:
     * 
     * 1) Extends JpaRepository<StudentEntity, Long>:
     *    - StudentEntity -> This is the Entity class that maps to your database table.
     *    - Long -> This is the type of the primary key (id) of StudentEntity.
     * 
     * 2) By extending JpaRepository, Spring Data JPA automatically provides:
     *    - save(entity) -> insert or update
     *    - findById(id)
     *    - findAll()
     *    - deleteById(id)
     *    - count()
     *    - and many more
     * 
     * 3) You can also define your own methods by following Spring Data JPA's
     *    method naming conventions, like:
     * 
     *      List<StudentEntity> findByName(String name);
     *      List<StudentEntity> findByStdClass(String stdClass);
     * 
     *    Spring Data JPA will automatically implement these at runtime!
     *
     * 4) @Repository annotation is technically optional here because
     *    Spring Data JPA automatically detects interfaces that extend JpaRepository
     *    and creates proxies for them as Spring beans.
     *
     * This interface will be injected into your Service classes to
     * perform DB operations without writing any SQL or JPQL.
     */
}
