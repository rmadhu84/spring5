/**
 * 
 */
package com.springframework.DIDemo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.DIDemo.Service.GreetingService;

/**
 * @author Madhu
 *
 */
@Controller
public class MyController {

	private GreetingService greetingService;
	
	/**
	 * @param greetingService
	 */
	public MyController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}
	
	public String hello() {
		System.out.println(greetingService.sayHello());
		return null;
	}
	

}
