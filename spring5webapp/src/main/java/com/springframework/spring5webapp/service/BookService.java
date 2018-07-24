/**
 * 
 */
package com.springframework.spring5webapp.service;

import java.util.List;

import com.springframework.spring5webapp.dto.BookDto;

/**
 * @author ramachandranm1
 *
 */
public interface BookService {
	public BookDto addBook(BookDto bookDto);
	public List<BookDto> fetchAllBooks();

}
