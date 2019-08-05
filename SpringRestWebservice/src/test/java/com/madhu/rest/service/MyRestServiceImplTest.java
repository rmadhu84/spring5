/**
 * 
 */
package com.madhu.rest.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.madhu.rest.converters.AddressCmdToMdlConverter;
import com.madhu.rest.converters.AddressMdlToCmdConverter;
import com.madhu.rest.converters.StudentCmdToMdlConverter;
import com.madhu.rest.converters.StudentMdlToCmdConverter;
import com.madhu.rest.repositories.StudentRepository;
import com.madhu.rest.service.impl.MyRestServiceImpl;

/**
 * @author ramachandranm1
 *
 */
public class MyRestServiceImplTest {

	MyRestService service;

	StudentCmdToMdlConverter studentCmdToMdlConverter;
	StudentMdlToCmdConverter studentMdlToCmdConverter;
	AddressMdlToCmdConverter addressMdlToCmdConverter;
	AddressCmdToMdlConverter addressCmdToMdlConverter;

	MockMvc mvc;

	@Mock
	StudentRepository repo;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		addressMdlToCmdConverter = new AddressMdlToCmdConverter();
		addressCmdToMdlConverter = new AddressCmdToMdlConverter();
		studentCmdToMdlConverter = new StudentCmdToMdlConverter(addressCmdToMdlConverter);
		studentMdlToCmdConverter = new StudentMdlToCmdConverter(addressMdlToCmdConverter);
		service = new MyRestServiceImpl(repo, studentCmdToMdlConverter, studentMdlToCmdConverter);

		MockitoAnnotations.initMocks(this);

	}

	/**
	 * Test method for
	 * {@link com.madhu.rest.service.impl.MyRestServiceImpl#findNoOfOccurance(java.lang.String)}.
	 */
	@Test
	public void testFindNoOfOccurance() {
		// given
		// when
		// then
	}

	/**
	 * Test method for
	 * {@link com.madhu.rest.service.impl.MyRestServiceImpl#save(com.madhu.rest.commands.StudentCommand)}.
	 */
	@Test
	public void testSave() {
		// given
		// when
		// then
	}

	/**
	 * Test method for
	 * {@link com.madhu.rest.service.impl.MyRestServiceImpl#fetchStudent(java.lang.String)}.
	 */
	@Test
	public void testFetchStudent() {
		// given
		// when
		// then
	}

}
