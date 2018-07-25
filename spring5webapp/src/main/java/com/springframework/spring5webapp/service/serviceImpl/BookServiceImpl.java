/**
 * 
 */
package com.springframework.spring5webapp.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.spring5webapp.dto.AuthorDto;
import com.springframework.spring5webapp.dto.BookDto;
import com.springframework.spring5webapp.models.Author;
import com.springframework.spring5webapp.models.Book;
import com.springframework.spring5webapp.models.repositories.AuthorRepository;
import com.springframework.spring5webapp.models.repositories.BookRepository;
import com.springframework.spring5webapp.service.BookService;


/**
 * @author ramachandranm1
 *
 */
@Service
public class BookServiceImpl implements BookService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	 
	@Autowired
	private BookRepository bookRep;
	
	@Autowired
	private AuthorRepository authorRep;
 
	/**
	 * 
	 */
	public BookServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BookDto addBook(BookDto bookDto) {
		// TODO Auto-generated method stub
		/* Incorrect way of setting Books
		 * Book book = new Book();
		BeanUtils.copyProperties(bookDto, book, "authors");

		Set<Author> setAuthors = new HashSet<Author>();

		for(AuthorDto authors : bookDto.getAuthors()) {
			Author author = new Author();
			BeanUtils.copyProperties(authors, author);

			setAuthors.add(author);
		}
		book.getAuthors().addAll(setAuthors);
		book = bookRep.save(book);*/


		Set<Author> authors = new HashSet<Author>();

		for(AuthorDto authorDto : bookDto.getAuthors()) {
			Author author = new Author();
			BeanUtils.copyProperties(authorDto, author);
			authors.add(author);
		}
		
		Book book = new Book(bookDto.getTitle(), bookDto.getISBN(), authors);
		
		/*Author AuthorA = new Author("John", "Doe");
		Author AuthorB = new Author("Jane", "Doe");
		Author AuthorC = new Author("Bob", "Doe");

		Book book1 = new Book("Book A", "123-456-789", new HashSet<Author>(){{
			add(AuthorA);
			add(AuthorB);
		}});*/

		bookRep.save(book);
		/*bookRep.save(book1);*/


		BeanUtils.copyProperties(book, bookDto);		
		return bookDto;
	}

	@Override
	public List<BookDto> fetchAllBooks() {
		 // fetch all books
		List<BookDto> list = new ArrayList<BookDto>();
		
        for(Book book : bookRep.findAll()) {
            logger.info(book.toString());
                 
            List<AuthorDto> authors = new ArrayList<AuthorDto>();

    		for(Author author : book.getAuthors()) {
    			AuthorDto authorDto = new AuthorDto();
    			BeanUtils.copyProperties(author, authorDto);
    			authors.add(authorDto);
    		}
    		
    		BookDto bookDto = new BookDto(book.getId(), book.getTitle(), book.getISBN(), authors);
    		list.add(bookDto);
            
        }
        
        //Fetch all authors
        for(Author author: authorRep.findAll()) {
        	logger.info(author.toString());
        }
        
        
        
		return list;
	}

}
