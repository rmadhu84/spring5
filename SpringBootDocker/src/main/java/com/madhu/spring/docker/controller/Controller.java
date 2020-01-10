/**
 * 
 */
package com.madhu.spring.docker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Madhu
 *
 */
@RestController
public class Controller {

	@RequestMapping(value="/hello")
	public ResponseEntity<Object> helloWorld() {
		Greet greet = new Greet();
		greet.setMessage("Hello World from SpringDocker!!!");
		
		return ResponseEntity.status(HttpStatus.OK).body(greet);
	}
}
