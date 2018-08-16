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
public class PropertyBasedInjectionController {

	@Autowired
	@Qualifier("proertyBasedInjection")
	private GreetingService proertyBasedInjection;
	
	public void sayHello() {
	
		System.out.println(proertyBasedInjection.sayHello());
	}
	
}
