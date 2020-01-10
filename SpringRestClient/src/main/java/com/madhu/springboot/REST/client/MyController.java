/**
 * 
 */
package com.madhu.springboot.REST.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ramachandranm1
 *
 */
@Controller
@Slf4j
public class MyController {

	RestTemplate restTemplate;
	
	
	public MyController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@RequestMapping("/greet")
	public String greet(Model model) {
		Greet greet = restTemplate.getForObject("http://localhost:8090/hello", Greet.class);
		model.addAttribute("greeting", greet);
		log.info(greet.toString());
		return "index";
	}
}
