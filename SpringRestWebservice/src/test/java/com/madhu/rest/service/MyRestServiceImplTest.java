/**
 * 
 */
package com.madhu.rest.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.madhu.rest.Models.Address;
import com.madhu.rest.Models.Student;
import com.madhu.rest.POJO.Word;
import com.madhu.rest.commands.AddressCommand;
import com.madhu.rest.commands.StudentCommand;
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

	private static final Long ID = 1L;

	private static final String NAME = "John";

	private static final String ADDRESS_LINE = "2350 Club Meridian Dr";

	private static final String CITY = "Okemos";

	private static final Integer ZIP = 48864;

	private static final String UNSORTED_STRING = "a e d e b c g h f";

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
		MockitoAnnotations.initMocks(this);
		addressMdlToCmdConverter = new AddressMdlToCmdConverter();
		addressCmdToMdlConverter = new AddressCmdToMdlConverter();
		studentCmdToMdlConverter = new StudentCmdToMdlConverter(addressCmdToMdlConverter);
		studentMdlToCmdConverter = new StudentMdlToCmdConverter(addressMdlToCmdConverter);
		service = new MyRestServiceImpl(repo, studentCmdToMdlConverter, studentMdlToCmdConverter);
	}

	/**
	 * Test method for
	 * {@link com.madhu.rest.service.impl.MyRestServiceImpl#findNoOfOccurance(java.lang.String)}.
	 */
	@Test
	public void testFindNoOfOccurance() {
		// given
		List<Word> words = new ArrayList<Word>();
		words.add(new Word("a", 1));
		words.add(new Word("b", 1));
		words.add(new Word("c", 1));
		words.add(new Word("d", 1));
		words.add(new Word("e", 2));
		words.add(new Word("f", 1));
		words.add(new Word("g", 1));
		words.add(new Word("h", 1));
		// when
		// then
		List<Word> result = service.findNoOfOccurance(UNSORTED_STRING);
		assertEquals(words.size(), result.size());
		for(int i = 0; i<words.size();i++) {
			assertEquals(words.get(i).getW(), result.get(i).getW());
			assertEquals(words.get(i).getN(), result.get(i).getN());
		}

	}

	/**
	 * Test method for
	 * {@link com.madhu.rest.service.impl.MyRestServiceImpl#save(com.madhu.rest.commands.StudentCommand)}.
	 */
	@Test
	public void testSave() {
		// given
		Student studentModel = new Student();
		Address addressModel = new Address();
		studentModel.setId(ID);
		studentModel.setName(NAME);
		addressModel.setAddress_line(ADDRESS_LINE);
		addressModel.setCity(CITY);
		addressModel.setId(ID);
		addressModel.setZip(ZIP);
		studentModel.addAddress(addressModel);
		
		StudentCommand studentCommand = new StudentCommand();
		AddressCommand addressCommand = new AddressCommand();
		studentCommand.setId(ID);
		studentCommand.setName(NAME);
		addressCommand.setAddress_line(ADDRESS_LINE);
		addressCommand.setCity(CITY);
		addressCommand.setId(ID);
		addressCommand.setZip(ZIP);
		studentCommand.addAddress(addressCommand);
		// when
		when(repo.save(Mockito.any())).thenReturn(studentModel);
		StudentCommand result = service.save(studentCommand);
		// then
		assertEquals(ID, result.getId());
		assertEquals(NAME, result.getName());
		result.getAddresses().forEach(address->{
			assertEquals(ID, address.getId());
			assertEquals(ADDRESS_LINE, address.getAddress_line());
			assertEquals(CITY, address.getCity());
			assertEquals(ZIP, address.getZip());
		});
	}

	/**
	 * Test method for
	 * {@link com.madhu.rest.service.impl.MyRestServiceImpl#fetchStudent(java.lang.String)}.
	 */
	@Test
	public void testFetchStudent() {
		// given
		Student studentModel = new Student();
		Address addressModel = new Address();
		studentModel.setId(ID);
		studentModel.setName(NAME);
		addressModel.setAddress_line(ADDRESS_LINE);
		addressModel.setCity(CITY);
		addressModel.setId(ID);
		addressModel.setZip(ZIP);
		studentModel.addAddress(addressModel);
		Optional<Student> student = Optional.of(studentModel);
		// when
		when(repo.findById(ID)).thenReturn(student);
		StudentCommand studentCommand = service.fetchStudent(ID.toString());
		// then
		assertEquals(ID, studentCommand.getId());
		assertEquals(NAME, studentCommand.getName());
		studentCommand.getAddresses().forEach(address->{
			assertEquals(ID, address.getId());
			assertEquals(ADDRESS_LINE, address.getAddress_line());
			assertEquals(CITY, address.getCity());
			assertEquals(ZIP, address.getZip());
		});		
		
		verify(repo, times(1)).findById(ID);
	}

}
