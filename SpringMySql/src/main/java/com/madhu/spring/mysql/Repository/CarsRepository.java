/**
 * 
 */
package com.madhu.spring.mysql.Repository;

import org.springframework.data.repository.CrudRepository;

import com.madhu.spring.mysql.Entity.Cars;

/**
 * @author Madhu
 *
 */
public interface CarsRepository extends CrudRepository<Cars, Long> {

}
