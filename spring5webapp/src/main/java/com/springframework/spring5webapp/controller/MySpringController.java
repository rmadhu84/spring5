package com.springframework.spring5webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.spring5webapp.dto.BookDto;
import com.springframework.spring5webapp.dto.ContactDto;
import com.springframework.spring5webapp.dto.Greeting;
import com.springframework.spring5webapp.models.Contact;
import com.springframework.spring5webapp.service.BookService;
import com.springframework.spring5webapp.service.ContactService;

@RestController
public class MySpringController {
	private static final String template = "Hello, %s !!!";

	@Autowired
	ContactService contactService;
	
	@Autowired
	BookService bookService;

	@RequestMapping(value = "/addContact")
	public ContactDto addContact(@RequestBody ContactDto contactDto) {
		return contactService.addContact(contactDto);
	}
	
	@GetMapping(value="/findByEmail")
	public ResponseEntity<List<ContactDto>> findByEmail(@RequestParam(value = "email") String email) {
		return new ResponseEntity<List<ContactDto>>(contactService.findByEmail(email), HttpStatus.OK);
	};
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping(value="/findById")
	public ResponseEntity<ContactDto> findById(@RequestParam("id") Integer id) {
		return new ResponseEntity<ContactDto>(contactService.findById(id), HttpStatus.OK);
	}

	@RequestMapping("/greet")
	public Greeting greet(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(String.format(template, name));
	}
	
	@RequestMapping("/getAll")
	public List<Contact> getAllContacts(){
		return contactService.getAllContacts();
	}
	
	@RequestMapping("/update")
	public String updateContact(@RequestBody ContactDto contactDto) {
		return contactService.updateContact(contactDto);
	}
	
	@RequestMapping("/addBook")
	public BookDto addBook(@RequestBody BookDto bookDto) {
		return bookService.addBook(bookDto);
		
	}
	
	@RequestMapping("/fetchAllBooks")
	public List<BookDto> fetchAllBooks(){
		return bookService.fetchAllBooks();
	}

	public MySpringController() {
	}
	
	
	



}
