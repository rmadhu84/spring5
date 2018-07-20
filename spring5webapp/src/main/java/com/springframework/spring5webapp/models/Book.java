/**
 * 
 */
package com.springframework.spring5webapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.springframework.spring5webapp.dto.AuthorDto;

/**
 * @author ramachandranm1
 *
 */
public class Book {

	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	private String ISBN;
	private String title;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	private Set<AuthorDto> author = new HashSet<AuthorDto>(); 
	
	
	/**
	 * 
	 */
	public Book() {
		// TODO Auto-generated constructor stub
	}

}
