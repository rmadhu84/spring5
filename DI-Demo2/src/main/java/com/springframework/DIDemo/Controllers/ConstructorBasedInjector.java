package com.springframework.DIDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

import com.springframework.DIDemo.Service.GreetingService;

@Controller
public class ConstructorBasedInjector {

	private GreetingService greet;

	private GreetingService greet2;

	public void sayHello() {
		System.out.println(greet.sayHello());
		System.out.println(greet2.sayHello());
	}

	/**
	 * @param greet
	 * @param greet2
	 */
	public ConstructorBasedInjector(@Qualifier("greetingServiceImpl") GreetingService greet,
			@Qualifier("anotherGreetingServiceImpl") GreetingService greet2) {
		super();
		this.greet = greet;
		this.greet2 = greet2;
	}

}
