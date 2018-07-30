/**
 * 
 */
package com.springframework.spring5webapp.bootStrap;

import java.util.HashSet;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springframework.spring5webapp.models.Author;
import com.springframework.spring5webapp.models.Book;
import com.springframework.spring5webapp.models.Publisher;
import com.springframework.spring5webapp.models.repositories.AuthorRepository;
import com.springframework.spring5webapp.models.repositories.BookRepository;
import com.springframework.spring5webapp.models.repositories.PublisherRepository;

/**
 * @author Madhu
 *
 */
@Component
@Transactional
public class devBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	/**
	 * 
	 */
	private AuthorRepository authorRepo;
	private BookRepository bookRepo;
	private PublisherRepository publishRepo;
	


	/**
	 * @param authorRepo
	 * @param bookRepo
	 * @param publishRepo
	 */
	public devBootStrap(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publishRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publishRepo = publishRepo;
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
		bookRepo.save(noEJB);
		
		Author john = new Author("John", "Dow");
		Author jane = new Author("Jane", "Doe");
		Publisher publish = new Publisher("Mcgraw Hill", "1 Main St", "Lansing", "MI", 48864);
	    Book  hfj = new Book("Head First Java", "123-456-789", publish, new HashSet<Author>(){{
			add(john);
			add(jane);
			add(eric);
		}});
	    
	   bookRepo.save(hfj);
	   for(Book book : bookRepo.findAll()) {
		   System.out.println(book.toString());
	   }
	}
	
	
	
	
	
	

}
