/**
 * 
 */
package com.springframework.spring5webapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ramachandranm1
 *
 */
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	/**
	 * 
	 */
	public Author() {
		// TODO Auto-generated constructor stub
	}

}
