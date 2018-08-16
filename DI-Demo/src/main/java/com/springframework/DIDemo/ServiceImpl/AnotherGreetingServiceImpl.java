/**
 * 
 */
package com.springframework.DIDemo.ServiceImpl;

import org.springframework.stereotype.Service;

import com.springframework.DIDemo.Service.GreetingService;

/**
 * @author Madhu
 *
 */
@Service
public class AnotherGreetingServiceImpl implements GreetingService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
//		System.out.println("Injected by Another Constructor Greeting Service");
		return new String("Injected by Another Constructor Greeting Service"); 
	}

}
