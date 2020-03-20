/**
 * 
 */
package com.madhu.spring.mysql.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.spring.mysql.Models.CarsModel;
import com.madhu.spring.mysql.Service.CarsService;

/**
 * @author Madhu
 *
 */
@RestController
@RequestMapping(value ="/mySql")
public class MyRestController {
	
	CarsService service;
	
	public MyRestController(CarsService service) {
		super();
		this.service = service;
	}

	@GetMapping(value="/fetchAllCars")
	public ResponseEntity<Object> getAllCars(){
		List<CarsModel> model = new ArrayList<CarsModel>();
		model = service.getAllCars();
		return ResponseEntity.status(HttpStatus.OK).body(model);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<Object> add(@Valid @RequestBody  CarsModel car){
		return  ResponseEntity.status(HttpStatus.OK).body(service.add(car));
	}
	
	@GetMapping(value = "/generate/{format}")
	public ResponseEntity<Object> generateReport(@PathVariable String format){
		System.out.println(String.format("Format = %s", format));
		service.generateReport(format);
		return ResponseEntity.status(HttpStatus.OK).body("Report Generated");
	}
}
