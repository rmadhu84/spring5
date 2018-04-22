package com.springframework.spring5webapp.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.spring5webapp.POJO.Contact;
import com.springframework.spring5webapp.POJO.Greeting;
import com.springframework.spring5webapp.models.ContactDto;

@RestController
public class MySpringController {
	private static final String template = "Hello, %s !!!";

	@RequestMapping(value="/addContact", headers="Accept=application/json")
	public Greeting addContact(@RequestBody Contact contact) {

		return new Greeting(String.format(template, contact.getEmail()));
	}

	@RequestMapping("/greet")
	public Greeting greet(@RequestParam(value="name", defaultValue="World") String name) {

		return new Greeting(String.format(template, name));
	}

	public MySpringController() {
		// TODO Auto-generated constructor stub
	}

}
