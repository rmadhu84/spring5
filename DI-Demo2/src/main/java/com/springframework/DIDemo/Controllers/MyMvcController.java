/**
 * 
 */
package com.springframework.DIDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.DIDemo.Service.GreetingService;

/**
 * @author ramachandranm1
 *
 */
@Controller
public class MyMvcController {
	
	private GreetingService primaryGreeting;
	private GreetingService constructorGreeting;
	private GreetingService setterGreeting;
	
	@Autowired
	@Qualifier("proertyBasedInjection")
	private GreetingService propertyGreeting;
	/**
	 * @param primaryGreeting
	 * @param constructorGreeting
	 */
	public MyMvcController(GreetingService primaryGreeting, @Qualifier("greetingServiceImpl") GreetingService constructorGreeting) {
		this.primaryGreeting = primaryGreeting;
		this.constructorGreeting = constructorGreeting;
	}
	
	/**
	 * @param setterGreeting the setterGreeting to set
	 */
	@Autowired
	public void setSetterGreeting(@Qualifier("setterGreetingServiceImpl") GreetingService setterGreeting) {
		this.setterGreeting = setterGreeting;
	}
	
	@RequestMapping({"/",""})
	public String getGreeting(Model model) {
		model.addAttribute("primaryGreet", primaryGreeting.sayHello());
		model.addAttribute("constructGreet", constructorGreeting.sayHello());
		model.addAttribute("setterGreet", setterGreeting.sayHello());
		model.addAttribute("propertyGreet", propertyGreeting.sayHello());
		return "greet";
	}
	

}
