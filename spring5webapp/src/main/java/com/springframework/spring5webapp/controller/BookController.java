package com.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.spring5webapp.service.BookService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

	@NonNull private BookService books;
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", books.fetchAllBooks());
		return "books";
	}

	

}
