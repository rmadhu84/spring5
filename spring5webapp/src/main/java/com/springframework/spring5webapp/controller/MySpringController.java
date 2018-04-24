package com.springframework.spring5webapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.spring5webapp.POJO.Contact;
import com.springframework.spring5webapp.POJO.Greeting;
import com.springframework.spring5webapp.models.ContactDto;
import com.springframework.spring5webapp.models.repositories.ContactRepository;

@RestController
public class MySpringController {
	private static final String template = "Hello, %s !!!";
	
	@Autowired
	ContactRepository contactRepo;
	
	@RequestMapping(value="/addContact")
	public ContactDto addContact(@RequestBody ContactDto contact) {
		
		ContactDto contactDto = new ContactDto();
		//BeanUtils.copyProperties(contact, contactDto);
		contactRepo.save(contactDto);

		return contactDto;
	}

	@RequestMapping(value="/addContactTest")
	public Contact addContactTest(@RequestBody Contact contact) {
	
		return contact;
	}
	@RequestMapping("/greet")
	public Greeting greet(@RequestParam(value="name", defaultValue="World") String name) {

		return new Greeting(String.format(template, name));
	}

	public MySpringController() {
		// TODO Auto-generated constructor stub
	}

}
