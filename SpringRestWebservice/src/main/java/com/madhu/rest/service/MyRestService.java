/**
 * 
 */
package com.madhu.rest.service;

import java.util.List;

import com.madhu.rest.Models.Student;
import com.madhu.rest.POJO.Word;

/**
 * @author ramachandranm1
 *
 */
public interface MyRestService {
	
	public List<Word> findNoOfOccurance(String s);
	public Student save(Student student);
	public Student fetchStudent(String id);

}
