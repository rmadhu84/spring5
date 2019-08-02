/**
 * 
 */
package com.madhu.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.rest.Models.Student;
import com.madhu.rest.POJO.Word;
import com.madhu.rest.service.MyRestService;

/**
 * @author ramachandranm1
 *
 */
@RestController
public class MyController {

	private MyRestService service;

	
	@RequestMapping(value = "/process")
	public List<Word> process(@RequestParam(value = "para") String para) {
		return service.findNoOfOccurance(para);
	}
	
	@RequestMapping
	public Student save(@RequestParam(value = "name")String name) {
		Student s = new Student(name);
		return service.save(s);
	}

	public MyController(MyRestService service) {
		this.service = service;
	}
}

 
