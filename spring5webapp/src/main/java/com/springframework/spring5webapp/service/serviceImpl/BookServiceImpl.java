/**
 * 
 */
package com.springframework.spring5webapp.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.spring5webapp.dto.AuthorDto;
import com.springframework.spring5webapp.dto.BookDto;
import com.springframework.spring5webapp.models.Author;
import com.springframework.spring5webapp.models.Book;
import com.springframework.spring5webapp.models.repositories.BookRepository;
import com.springframework.spring5webapp.service.BookService;


/**
 * @author ramachandranm1
 *
 */
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRep;
 
	/**
	 * 
	 */
	public BookServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BookDto addBook(BookDto bookDto) {
		// TODO Auto-generated method stub
		Book book = new Book();
		BeanUtils.copyProperties(bookDto, book, "authors");
		
		Set<Author> setAuthors = new HashSet<Author>();
		
		for(AuthorDto authors : bookDto.getAuthors()) {
			Author author = new Author();
			BeanUtils.copyProperties(authors, author);
			
			setAuthors.add(author);
		}
		book.getAuthors().addAll(setAuthors);
		book = bookRep.save(book);
		BeanUtils.copyProperties(book, bookDto);		
		return bookDto;
	}

	@Override
	public List<BookDto> fetchAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<Book>();
		List<BookDto> list = new ArrayList<BookDto>();
		
		
		//bookRep.findAll().forEach(e -> books.add(e));
		books = (List<Book>) bookRep.findAll();
		for(Book b: books) {
			System.out.println(b.toString());
		}
		/*for(Book b: books) {
			BookDto bookDto = new BookDto();
			BeanUtils.copyProperties(b, bookDto);
			list.add(bookDto);
		}*/
		return null;
	}

}
