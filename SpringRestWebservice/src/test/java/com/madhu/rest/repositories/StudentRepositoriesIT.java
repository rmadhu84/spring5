/**
 * 
 */
package com.madhu.rest.repositories;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.madhu.rest.Models.Student;

/**
 * @author Madhu
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoriesIT {

	@Autowired
	StudentRepository repo;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		Optional<Student> st = repo.findById((long) 1);
		assertNotNull(st);
	}

}
