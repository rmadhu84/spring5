/**
 * 
 */
package com.madhu.rest.bootStrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.madhu.rest.Models.Student;
import com.madhu.rest.repositories.StudentRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ramachandranm1
 *
 */
@Component
@Slf4j
public class Dataload implements ApplicationListener<ContextRefreshedEvent> {

	StudentRepository repo; 
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		log.info("Starting data load..");
		repo.saveAll(loaddata());
		log.info("Dataload complete !!");
		
	}
	
	
	private List<Student> loaddata() {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		Student s1 = new Student();
		s1.setName("John");
		students.add(s1);
		s1 = new Student();
		s1.setName("Jane");
		students.add(s1);
		return students;
	}


	


	public Dataload(StudentRepository repo) {
		this.repo = repo;
	}

}
