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
@Profile("es")
@AllArgsConstructor
public class MyServiceESImplementation implements MyService {

	User user;
	
	/* (non-Javadoc)
	 * @see com.madhu.springboot.recap.service.MyService#greet()
	 */
	public String greet() {
		// TODO Auto-generated method stub
		return String.format("Hola, usuario de Spring, %s %s !!!", user.getFirstName(), user.getLastName() );
	}

}
