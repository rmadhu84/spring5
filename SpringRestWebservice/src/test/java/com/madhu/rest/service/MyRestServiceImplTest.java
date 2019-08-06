/**
 * 
 */
package com.madhu.rest.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.madhu.rest.Models.Address;
import com.madhu.rest.Models.Student;
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

	private static final Long ID = null;

	private static final String NAME = null;

	private static final String ADDRESS_LINE = null;

	private static final String CITY = null;

	private static final Integer ZIP = null;

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
		Student command = new Student();
		Address addressCommand = new Address();
		command.setId(ID);
		command.setName(NAME);
		addressCommand.setAddress_line(ADDRESS_LINE);
		addressCommand.setCity(CITY);
		addressCommand.setId(ID);
		addressCommand.setZip(ZIP);
		command.addAddress(addressCommand);
		Optional<Student> student = Optional.of(command);
		// when
		when(repo.findById(ID)).thenReturn(student);
		// then
		
	}

}
