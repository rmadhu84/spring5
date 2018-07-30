/**
 * 
 */
package com.springframework.spring5webapp.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springframework.spring5webapp.dto.AuthorDto;
import com.springframework.spring5webapp.dto.BookDto;
import com.springframework.spring5webapp.models.Author;
import com.springframework.spring5webapp.models.Book;
import com.springframework.spring5webapp.models.repositories.AuthorRepository;
import com.springframework.spring5webapp.service.AuthorService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

/**
 * @author Madhu
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

	private AuthorRepository authorRep;
	

	/**
	 * @param authorRep
	 */
	public AuthorServiceImpl(AuthorRepository authorRep) {
		super();
		this.authorRep = authorRep;
	}


	@Override
	public List<AuthorDto> getAllAuthors() {

		List <AuthorDto> list = new ArrayList<AuthorDto>();
	      
		
		for(Author author: authorRep.findAll()) {
			AuthorDto dto = new AuthorDto(author.getId(), author.getFirstName(), author.getLastName());
			List<BookDto> bDto = new ArrayList<BookDto>();
			for(Book book:author.getBooks()) {
				BookDto bookDto = new BookDto(book.getId(), book.getTitle(), book.getISBN());
				bDto.add(bookDto);
			}
			dto.getBooks().addAll(bDto);
			list.add(dto);
		}
		
	       
		return list;
	}


	@Override
	public AuthorDto getAuthorByName(String firstName, String lastName) {

		AuthorDto authorDto = new AuthorDto();
		Author author = authorRep.findOneByFirstNameAndLastName(firstName, lastName);
		BeanUtils.copyProperties(author, authorDto);
		return authorDto;
	}

	@Override
	public List<AuthorDto> getAuthorByLastName(String lastName) {
		List<AuthorDto> list = new ArrayList<AuthorDto>();
		for(Author author : authorRep.findByLastName(lastName)) {
			AuthorDto dto = new AuthorDto(author.getId(), author.getFirstName(), author.getLastName());
			list.add(dto);
		}
		return list;
	}
}
