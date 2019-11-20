/**
 * 
 */
package com.madhu.springboot.recap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.springboot.recap.service.MyService;

import lombok.AllArgsConstructor;

/**
 * @author ramachandranm1
 *
 */
@RestController
@AllArgsConstructor
public class MyController {

	private MyService service;
	
	@RequestMapping("/")
	public String greet() {
		return service.greet();
	}

}
