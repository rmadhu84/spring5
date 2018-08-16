/**
 * 
 */
package com.springframework.DIDemo.ServiceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.DIDemo.Service.GreetingService;
import com.springframework.DIDemo.repository.GreetingRepository;

/**
 * @author Madhu
 *
 */
//@Service
//@Primary
//@Profile(value="de")
public class PrimaryGermanGreetingServiceImpl implements GreetingService {

	GreetingRepository greetingRepo;
	
	
	
	/**
	 * @param greetingRepo
	 */
	public PrimaryGermanGreetingServiceImpl(GreetingRepository greetingRepo) {
		super();
		this.greetingRepo = greetingRepo;
	}



	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
//		System.out.println("Hallo - Vom primären Begrüßungsdienst");
		return greetingRepo.greetInGerman();
		
	}

}
