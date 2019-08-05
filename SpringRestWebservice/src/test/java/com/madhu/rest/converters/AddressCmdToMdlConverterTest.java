package com.madhu.rest.converters;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.madhu.rest.Models.Address;
import com.madhu.rest.commands.AddressCommand;


public class AddressCmdToMdlConverterTest {

	AddressCmdToMdlConverter addressCmdToMdlConverter;
	private static final Long ID = 1L;
	private static final String ADDRESS_LINE = "2350 CLUB MERIDIAN DRIVE";
	private static final String CITY = "OKEMOS";
	private static final Integer ZIP = 48864;
	
	@Before
	public void setUp() throws Exception {
		addressCmdToMdlConverter = new AddressCmdToMdlConverter();
	}

	@Test
	public void testTestConvert() {
		//given
		AddressCommand command = new AddressCommand();
		
		command.setId(ID);
		command.setAddress_line(ADDRESS_LINE);
		command.setCity(CITY);
		command.setZip(ZIP);
		//when
		Address model = addressCmdToMdlConverter.convert(command);
		//then
		assertEquals(ADDRESS_LINE, model.getAddress_line());
		assertEquals(CITY, model.getCity());
		assertEquals(ZIP, model.getZip());
		
	}

}
