/**
 * 
 */
package com.madhu.rest.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.madhu.rest.Models.Student;
import com.madhu.rest.commands.AddressCommand;
import com.madhu.rest.commands.StudentCommand;

/**
 * @author ramachandranm1
 *
 */
public class StudentCmdToMdlConverterTest {

	
	StudentCmdToMdlConverter studentCmdToMdlConverter;
	AddressCmdToMdlConverter addressCmdToMdlConverter;
	private static final Long ID = 1L;
	private static final String NAME = "John";
	private static final String ADDRESS_LINE = "2350 Club Meridian Drive";
	private static final String CITY = "Okemos";
	private static final Integer ZIP = 1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		addressCmdToMdlConverter = new AddressCmdToMdlConverter();
		studentCmdToMdlConverter = new StudentCmdToMdlConverter(addressCmdToMdlConverter);
	}

	/**
	 * Test method for {@link com.madhu.rest.converters.StudentCmdToMdlConverter#convert(com.madhu.rest.commands.StudentCommand)}.
	 */
	@Test
	public void testConvert() {
		//given
		StudentCommand command = new StudentCommand();
		AddressCommand addressCommand = new AddressCommand();
		
		command.setId(ID);
		command.setName(NAME);
		addressCommand.setId(ID);
		addressCommand.setAddress_line(ADDRESS_LINE);
		addressCommand.setCity(CITY);
		addressCommand.setZip(ZIP);
		command.addAddress(addressCommand);
		
		//when
		Student model = studentCmdToMdlConverter.convert(command);
		
		//then
		assertEquals(ID, model.getId());
		assertEquals(NAME, model.getName());
		model.getAddresses().forEach(address ->{
			assertEquals(ID, address.getId());
			assertEquals(ADDRESS_LINE, address.getAddress_line());			
			assertEquals(CITY,address.getCity());
			assertEquals(ZIP, address.getZip());
		});
	}

}
