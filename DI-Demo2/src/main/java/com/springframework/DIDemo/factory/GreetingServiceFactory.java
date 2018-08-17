/**
 * 
 */
package com.springframework.DIDemo.factory;

import com.springframework.DIDemo.Service.GreetingService;
import com.springframework.DIDemo.ServiceImpl.PrimaryGermanGreetingServiceImpl;
import com.springframework.DIDemo.ServiceImpl.PrimaryGreetingServiceImpl;
import com.springframework.DIDemo.ServiceImpl.PrimarySpanishGreetingServiceImpl;
import com.springframework.DIDemo.repository.GreetingRepository;
import com.springframework.DIDemo.repository.GreetingRepository2;

/**
 * @author Madhu
 *
 */
public class GreetingServiceFactory {

	private GreetingRepository2 greetingRepo;

	
	/**
	 * @param greetingRepo
	 * @param greetinRepo2
	 */
	public GreetingServiceFactory(GreetingRepository2 greetingRepo) {
		super();
		this.greetingRepo = greetingRepo;
	}

	public GreetingService createGreetingService(String lang) {

		switch(lang) {
		case "en":
			return new PrimaryGreetingServiceImpl(greetingRepo);
		case"es":
			return new PrimarySpanishGreetingServiceImpl(greetingRepo);
		case"de":
			return new PrimaryGermanGreetingServiceImpl(greetingRepo);
		default:
			return new PrimaryGreetingServiceImpl(greetingRepo);
		}
	}

}
