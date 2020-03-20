/**
 * 
 */
package com.madhu.spring.mysql.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Madhu
 *
 */
@Entity
@Data
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String make;
	
	String model;
	
	String year;
	
}
