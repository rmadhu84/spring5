package com.springframework.spring5webapp.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springframework.spring5webapp.dto.ContactDto;
import com.springframework.spring5webapp.dto.PhoneDto;
import com.springframework.spring5webapp.models.Contact;
import com.springframework.spring5webapp.models.Phone;
import com.springframework.spring5webapp.models.repositories.ContactRepository;

@Repository
public class ContactServiceImpl implements com.springframework.spring5webapp.service.ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	public ContactServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ContactDto addContact(ContactDto contactDto) {
		
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactDto, contact, "phone");
		
		Set<Phone> setp = new HashSet<Phone>();
		
		for(PhoneDto p : contactDto.getPhone()) {
			Phone phone = new Phone();
			phone.setNo(p.getNo());
			phone.setType(p.getType());
			setp.add(phone);
		
		}
		
		contact.getPhone().addAll(setp);
		//contactRepo.save(contact);
		BeanUtils.copyProperties(contactRepo.save(contact), contactDto);
		return contactDto;
	}

	@Override
	public List<ContactDto> findByEmail(String email) {
		ContactDto contactDto;
		List<ContactDto> list = new ArrayList<ContactDto>();
		for(Contact contact : contactRepo.findByEmail(email)) {
			contactDto  = new ContactDto();
			BeanUtils.copyProperties(contact, contactDto);
			list.add(contactDto);
		}
		return list;
	}

	@Override
	public ContactDto findById(Integer id) {
		ContactDto contactDto = new ContactDto();
		Optional<Contact> contact = contactRepo.findById(new Long(id));
		BeanUtils.copyProperties(contact.get(), contactDto);
		return contactDto;
	}



	@Override
	public List<Contact> getAllContacts() {
		List<Contact> list = new ArrayList<Contact>();
		contactRepo.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public String updateContact(ContactDto contactDto) {
		// TODO Auto-generated method stub
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactDto, contact, "phone");
		
		Set<Phone> setp = new HashSet<Phone>();
		
		for(PhoneDto p : contactDto.getPhone()) {
			Phone phone = new Phone();
			phone.setNo(p.getNo());
			phone.setType(p.getType());
			setp.add(phone);
		
		}
		
		contact.getPhone().addAll(setp);
		contactRepo.save(contact);
		return new String("Contact Saved");
	}
	

}
