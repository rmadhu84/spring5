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
public class AnotherGreetingServiceImpl implements GreetingService {

	private GreetingRepository2 greet;
	
	/**
	 * @param greet
	 */
	public AnotherGreetingServiceImpl(GreetingRepository2 greet) {
		this.greet = greet;
	}

	@Override
	public String sayHello() {
		return greet.contructorInjectedGreet();
	}

}
