package com.springframework.spring5webapp.RepositoryTests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.springframework.spring5webapp.models.Contact;
import com.springframework.spring5webapp.models.Phone;
import com.springframework.spring5webapp.models.repositories.ContactRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ContactRepository contactRepo;
	
	@Test
	public void addContactTest() {
		Contact contact = new Contact();
		Set<Phone> cp = new HashSet<>();

		Phone phone = new Phone();

		phone.setType("Mobile");
		phone.setNo("517-507-9422");
		cp.add(phone);

		phone = new Phone();
		phone.setType("Home");
		phone.setNo("517-879-0942");
		cp.add(phone);
		
		contact.setEmail("r.madhu.84@gmail.com");
		contact.setPhone(cp);
	}
	
	public ContactRepositoryTest() {
		// TODO Auto-generated constructor stub
	}

}
