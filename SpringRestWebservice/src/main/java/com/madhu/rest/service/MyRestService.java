/**
 * 
 */
package com.madhu.rest.service;

import java.util.List;

import com.madhu.rest.Models.Student;
import com.madhu.rest.POJO.Word;
import com.madhu.rest.commands.StudentCommand;

/**
 * @author ramachandranm1
 *
 */
public interface MyRestService {
	
	public List<Word> findNoOfOccurance(String s);
	public StudentCommand save(StudentCommand student);
	public StudentCommand fetchStudent(String id);

}
