/**
 * 
 */
package com.springframework.spring5webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.spring5webapp.dto.AuthorDto;
import com.springframework.spring5webapp.service.AuthorService;
import com.springframework.spring5webapp.service.BookService;

/**
 * @author Madhu
 *
 */
@RestController
public class MySpringController2 {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	@RequestMapping("/getAuthor")
	public AuthorDto getAuthorByName(String firstName, String lastName) {
		return authorService.getAuthorByName(firstName, lastName);
	}
	
	@RequestMapping("/getAuthorByLastName")
	public List<AuthorDto> getAuthorByLastName(String lastName) {
		return authorService.getAuthorByLastName(lastName);
	}
	public MySpringController2() {
		// TODO Auto-generated constructor stub
	}

}
