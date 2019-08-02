/**
 * 
 */
package com.madhu.rest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.madhu.rest.Models.Student;

/**
 * @author ramachandranm1
 *
 */
public interface StudentRepository extends CrudRepository<Student, Long> {

}
