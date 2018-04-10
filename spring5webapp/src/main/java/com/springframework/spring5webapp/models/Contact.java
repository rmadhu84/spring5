package com.springframework.spring5webapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private Long id;
	
	private String email;
	
	private List<Phone> phone = new ArrayList();
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

}
