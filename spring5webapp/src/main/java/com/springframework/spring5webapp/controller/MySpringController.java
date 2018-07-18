package com.springframework.spring5webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.spring5webapp.dto.ContactDto;
import com.springframework.spring5webapp.dto.Greeting;
import com.springframework.spring5webapp.models.Contact;
import com.springframework.spring5webapp.models.repositories.ContactRepository;
import com.springframework.spring5webapp.service.ContactService;

@RestController
public class MySpringController {
	private static final String template = "Hello, %s !!!";

	@Autowired
	ContactRepository contactRepo;
	
	@Autowired
	ContactService contactService;

	@RequestMapping(value = "/addContact")
	public Contact addContact(@RequestBody ContactDto contactDto) {
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactDto, contact);
		return contactService.addContact(contact);
	}
	
	@GetMapping(value="/findByEmail")
	public ResponseEntity<List<ContactDto>> findByEmail(@RequestParam(value = "email") String email) {
		return new ResponseEntity<List<ContactDto>>(contactService.findByEmail(email), HttpStatus.OK);
	}
	
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
	

	public MySpringController() {
		// TODO Auto-generated constructor stub
	}

}
