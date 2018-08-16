/**
 * 
 */
package com.springframework.DIDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframework.DIDemo.Service.GreetingService;

/**
 * @author Madhu
 *
 */
@Controller
public class SetterBasedInjecter {

	private GreetingService greet;

	public void sayHello() {
		System.out.println(greet.sayHello());
	}


	/**
	 * @param greet the greet to set
	 */
	@Autowired
	public void setGreet(@Qualifier("setterGreetingServiceImpl") GreetingService greet) {
		this.greet = greet;
	}
	
	
	
}
