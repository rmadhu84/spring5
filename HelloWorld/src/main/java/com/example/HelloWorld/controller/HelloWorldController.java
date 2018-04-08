package com.example.HelloWorld.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController 
public class HelloWorldController {
	
	
    @RequestMapping("/")
	public String index() {
     return "Greetings from Spring !!!";
    }
	
	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}

}
