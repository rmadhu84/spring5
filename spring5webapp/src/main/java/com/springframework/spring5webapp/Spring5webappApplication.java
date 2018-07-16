package com.springframework.spring5webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
