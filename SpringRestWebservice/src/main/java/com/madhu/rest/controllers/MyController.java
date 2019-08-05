/**
 * 
 */
package com.madhu.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.rest.Models.Student;
import com.madhu.rest.commands.StudentCommand;
import com.madhu.rest.service.MyRestService;

/**
 * @author ramachandranm1
 *
 */
@RestController
public class MyController {

	private MyRestService service;
	Logger log = LoggerFactory.getLogger(MyController.class); 
	
	@RequestMapping(value = "/process")
	public ResponseEntity<Object> process(@RequestParam(value = "para") String para) {
		log.info("Processing paragraph !!");
		if(para == null || para.length() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("String is empty");
		else
			return ResponseEntity.status(HttpStatus.OK).body(service.findNoOfOccurance(para));
	}
	
	@GetMapping(path = "/fetchStudent")
	public ResponseEntity<StudentCommand> FetchStudent(@RequestParam(value = "id") String id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchStudent(id));
	}
	
	@PostMapping(path ="/save")
	public ResponseEntity<StudentCommand> save(@RequestBody StudentCommand student) {
		return ResponseEntity.status(HttpStatus.OK).header("save", "http://locolhost:8080/save").body(service.save(student));
	}

	public MyController(MyRestService service) {
		this.service = service;
	}
}

 
