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
public class ProertyBasedInjection implements GreetingService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
//		System.out.println("Injected by Property Based Injection");
		return new String("Injected by Property Based Injection");
	}

}
