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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * @author ramachandranm1
 *
 */
@Entity
public class Book {

	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	private String ISBN;
	private String title;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="publisher_id")
	private Publisher publisher;

	/**
	 * @param iSBN
	 * @param title
	 * @param publisher
	 * @param authors
	 */
	public Book(String iSBN, String title, Publisher publisher, Set<Author> authors) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
	}


	/**
	 * @param iSBN
	 * @param title
	 */
	public Book(String iSBN, String title) {
		super();
		ISBN = iSBN;
		this.title = title;
	}


	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
	private Set<Author> authors = new HashSet<Author>();


	/**
	 * @param iSBN
	 * @param title
	 * @param authors
	 */
	public Book(String title, String iSBN, Set<Author> authors) {
		ISBN = iSBN;
		this.title = title;
		this.authors = authors;
	}


	/**
	 * 
	 */
	public Book() {
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "Book [id=" + id + ", ISBN=" + ISBN + ", title=" + title + ", authors=" + authors + "]";
	}*/

	 @Override
	    public String toString() {
	        String result = String.format(
	                "Book [id=%d, ISBN='%s', Title='%s']%n",
	                id, ISBN, title);
	        if(authors != null) {	        	
	        	for(Author author : authors) {
				result += String.format("Author[id=%d, FirstName='%s', LastName='%s']%n", author.getId().intValue(),
						author.getFirstName(), author.getLastName());
	        	}
	        }
	        if(publisher != null) {
			result += String.format(
					"Publisher[id=%d, PublisherName='%s', AddressLine1='%s', AddressLine2='%s', City='%s', State='%s', Zipcode=%d]%n",
					publisher.getId(), publisher.getPublisherName(), publisher.getAddressLine1(),
					(publisher.getAddressLine2() != null) ? publisher.getAddressLine2() : "", publisher.getCity(),
					publisher.getState(), publisher.getZipcode());
	        }
	        return result;
	    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
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

	public Set<Author> getAuthors() {
		return authors;
	}


	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}


	public Publisher getPublisher() {
		return publisher;
	}


	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}
