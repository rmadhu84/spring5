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

@RestController
public class MySpringController {
	private static final String template = "Hello, %s !!!";

	@Autowired
	ContactRepository contactRepo;

	@RequestMapping(value = "/addContact")
	public Contact addContact(@RequestBody Contact contact) {

		Contact contactDto = new Contact();
		BeanUtils.copyProperties(contact, contactDto);
		contactRepo.save(contactDto);

		return contact;
	}
	
	@GetMapping(value="/findByEmail")
	public ResponseEntity<List> findByEmail(@RequestParam(value = "email") String email) {
		System.out.println("Find by Email1");
		ContactDto contactDto;
		List<ContactDto> list = new ArrayList<ContactDto>();
		for(Contact contact : contactRepo.findByEmail(email)) {
			contactDto  = new ContactDto();
			BeanUtils.copyProperties(contact, contactDto);
			list.add(contactDto);
		}
		
		System.out.println("Find by Email");
		return new ResponseEntity<List>(list, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/findById")
	public ResponseEntity<ContactDto> findById(@RequestParam("id") Integer id) {
		System.out.println("Find by Id");
		ContactDto contactDto = new ContactDto();
		Optional<Contact> contact = contactRepo.findById(new Long(id));
		BeanUtils.copyProperties(contact.get(), contactDto);
		
		
		return new ResponseEntity<ContactDto>(contactDto, HttpStatus.OK);
		
	}

	@RequestMapping("/greet")
	public Greeting greet(@RequestParam(value = "name", defaultValue = "World") String name) {

		return new Greeting(String.format(template, name));
	}
	
	@RequestMapping("/getAll")
	public List<Contact> getAllContacts(){
		List<Contact> list = new ArrayList<Contact>();
		contactRepo.findAll().forEach(e -> list.add(e));
		return list;
	}
	

	public MySpringController() {
		// TODO Auto-generated constructor stub
	}

}
