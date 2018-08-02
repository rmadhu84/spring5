/**
 * 
 */
package com.springframework.spring5webapp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author ramachandranm1
 *
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class ,property="id", scope = AuthorDto.class)
public class AuthorDto implements Serializable{

	
	private static final long serialVersionUID = 1171007862458306973L;

	private Long id;
	private String firstName;
	private String lastName;
	
	private List<BookDto> books = new ArrayList<BookDto>();

	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param books
	 */
	public AuthorDto(Long id, String firstName, String lastName, List<BookDto> books) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public AuthorDto(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the books
	 */
	public List<BookDto> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<BookDto> books) {
		this.books = books;
	}

	/**
	 * 
	 */
	public AuthorDto() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param books
	 */
	public AuthorDto(String firstName, String lastName, List<BookDto> books) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	

}
