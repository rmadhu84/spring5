/**
 * 
 */
package com.springframework.spring5webapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(mappedBy="authors", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Book> books = new HashSet<Book>();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + "]";
	}*/
	
	  @Override
	    public String toString() {
	        String result = String.format(
	                "Author [id=%d, firstName='%s', lastName='%s']%n",
	                id, firstName, lastName);
	        if (books != null) {
	            for(Book book : books) {
	                result += String.format(
	                        "Book[id=%d, ISBN='%s', Title='%s']%n",
	                        book.getId(), book.getISBN(), book.getTitle());
	            }
	        }

	        return result;
	    }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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
	
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}


	
	/**
	 * 
	 */
	public Author() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param books
	 */
	public Author(String firstName, String lastName, Set<Book> books) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	public Author(String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		 this.firstName = firstName;
		 this.lastName = lastName;
	}

}
