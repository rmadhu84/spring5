package com.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.spring5webapp.service.AuthorService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthorController {

	@NonNull private AuthorService authors;
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("writers", authors.getAllAuthors());
		return "authors";
	}
	

}
