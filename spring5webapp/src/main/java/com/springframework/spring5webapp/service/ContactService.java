/**
 * 
 */
package com.springframework.spring5webapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.springframework.spring5webapp.dto.ContactDto;
import com.springframework.spring5webapp.dto.Greeting;
import com.springframework.spring5webapp.models.Contact;

/**
 * @author ramachandranm1
 *
 */

public interface ContactService {
	public ContactDto addContact(ContactDto contactDto);
	public List<ContactDto> findByEmail(String email);
	public ContactDto findById(Integer id);
	public List<Contact> getAllContacts();
	public String updateContact(ContactDto contactDto);
	
}
