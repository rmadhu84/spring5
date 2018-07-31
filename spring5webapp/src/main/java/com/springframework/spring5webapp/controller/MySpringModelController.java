package com.springframework.spring5webapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.spring5webapp.service.BookService;

@RestController
public class MySpringModelController {

	private BookService books;
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", books.fetchAllBooks());
		
		return "books";
		
	}

	/**
	 * @param books
	 */
	public MySpringModelController(BookService books) {
		super();
		this.books = books;
	}
	

}
