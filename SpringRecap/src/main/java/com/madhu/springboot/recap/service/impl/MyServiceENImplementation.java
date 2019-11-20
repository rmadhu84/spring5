/**
 * 
 */
package com.madhu.springboot.recap.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.madhu.springboot.recap.customBeans.User;
import com.madhu.springboot.recap.service.MyService;

import lombok.AllArgsConstructor;

/**
 * @author ramachandranm1
 *
 */
@Service
@Profile("en")
@AllArgsConstructor
public class MyServiceENImplementation implements MyService {

	/* (non-Javadoc)
	 * @see com.madhu.springboot.recap.service.MyService#greet()
	 */
	
	User user;
	
	public String greet() {
		// TODO Auto-generated method stub
		return String.format("Hello Spring user, %s %s !!", user.getFirstName(), user.getLastName());
	}

}
