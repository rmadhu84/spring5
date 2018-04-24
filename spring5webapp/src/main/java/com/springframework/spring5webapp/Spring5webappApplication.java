package com.springframework.spring5webapp;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springframework.spring5webapp.models.Contact;
import com.springframework.spring5webapp.models.Phone;
import com.springframework.spring5webapp.models.repositories.ContactRepository;

@SpringBootApplication
@EnableJpaRepositories
public class Spring5webappApplication {
	private static final Logger log =  LoggerFactory.getLogger(Spring5webappApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(Spring5webappApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo(ContactRepository repo) {
//		Contact contact = new Contact();
//		return(args) ->{
//			Set<Phone> cp = new HashSet<>();
//
//			Phone phone = new Phone();
//
//			phone.setType("Mobile");
//			phone.setNo("517-507-9422");
//			cp.add(phone);
//
//			phone = new Phone();
//			phone.setType("Home");
//			phone.setNo("517-879-0942");
//			cp.add(phone);
//			contact.setEmail("r.madhu.84@gmail.com");
//			contact.setPhone(cp);
//			repo.save(contact);
//			log.info("Finding all contacts ---> ");
//			log.info("--------------------------");
//			for(Contact c: repo.findAll()) {
//				log.info(c.toString());
//			}
//
//		};
//	}
}
