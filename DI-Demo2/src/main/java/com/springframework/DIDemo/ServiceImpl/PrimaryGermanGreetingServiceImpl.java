/**
 * 
 */
package com.springframework.DIDemo.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.DIDemo.Service.GreetingService;
import com.springframework.DIDemo.repository.GreetingRepository;
import com.springframework.DIDemo.repository.GreetingRepository2;

/**
 * @author Madhu
 *
 */
//@Service
//@Primary
//@Profile(value="de")
public class PrimaryGermanGreetingServiceImpl implements GreetingService {

	GreetingRepository2 greetingRepo;

	private final static Logger logger = LoggerFactory.getLogger(PrimaryGermanGreetingServiceImpl.class);
	
	
	/**
	 * @param greetingRepo
	 */
	public PrimaryGermanGreetingServiceImpl(GreetingRepository2 greetingRepo) {
		super();
		this.greetingRepo = greetingRepo;
		logger.info("### We are in GERMAN Primary Greeting !!!");
	}



	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
//		System.out.println("Hallo - Vom primären Begrüßungsdienst");
		return greetingRepo.primaryGreet();
		
	}

}
