/**
 * 
 */
package com.springframework.DIDemo.ServiceImpl;

import org.springframework.stereotype.Service;

import com.springframework.DIDemo.Service.GreetingService;
import com.springframework.DIDemo.repository.GreetingRepository2;

/**
 * @author Madhu
 *
 */
@Service
public class ProertyBasedInjection implements GreetingService {

	private GreetingRepository2 greet;
	
	/**
	 * @param greet
	 */
	public ProertyBasedInjection(GreetingRepository2 greet) {
		this.greet = greet;
	}

	@Override
	public String sayHello() {
		return greet.propertyInjectedGreet();
		
	}

}
