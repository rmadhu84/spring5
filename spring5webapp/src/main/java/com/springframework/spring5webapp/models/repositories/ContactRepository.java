package com.springframework.spring5webapp.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springframework.spring5webapp.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	
	Optional<Contact> findById(Long id);
	Contact findByEmail(String email);

}
