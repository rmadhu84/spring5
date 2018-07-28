/**
 * 
 */
package com.springframework.spring5webapp.bootStrap;

import java.util.HashSet;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springframework.spring5webapp.models.Author;
import com.springframework.spring5webapp.models.Book;
import com.springframework.spring5webapp.models.repositories.AuthorRepository;
import com.springframework.spring5webapp.models.repositories.BookRepository;

/**
 * @author Madhu
 *
 */
@Component
public class devBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	/**
	 * 
	 */
	private AuthorRepository authorRepo;
	private BookRepository bookRepo;
	
	
	/**
	 * @param authorRepo
	 * @param bookRepo
	 */
	public devBootStrap(AuthorRepository authorRepo, BookRepository bookRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		initData();
		
	}
	
	private void initData() { //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepo.save(rod);
        bookRepo.save(noEJB);}
	

}
