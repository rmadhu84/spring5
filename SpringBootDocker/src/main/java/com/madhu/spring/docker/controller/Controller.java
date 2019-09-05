/**
 * 
 */
package com.madhu.spring.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Madhu
 *
 */
@RestController
public class Controller {

	@RequestMapping(value="/hello")
	public String helloWorld() {
		return "Hello World";
	}
}
