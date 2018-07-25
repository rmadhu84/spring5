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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class ,property="id", scope = BookDto.class)
public class BookDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 829057773981122011L;
	/**
	 * 
	 */
	
	private Long id;
	private String ISBN;
	private String title;
	private List<AuthorDto> authors = new ArrayList<AuthorDto>();
	/**
	 * 
	 */
	public BookDto() {
	}
	/**
	 * @param iSBN
	 * @param title
	 * @param authors
	 */
	public BookDto(String iSBN, String title, List<AuthorDto> authors) {
		ISBN = iSBN;
		this.title = title;
		this.authors = authors;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id
	 * @param iSBN
	 * @param title
	 * @param authors
	 */
	public BookDto(Long id, String iSBN, String title, List<AuthorDto> authors) {
		this.id = id;
		ISBN = iSBN;
		this.title = title;
		this.authors = authors;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the authors
	 */
	public List<AuthorDto> getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<AuthorDto> authors) {
		this.authors = authors;
	}
	
	

	}
