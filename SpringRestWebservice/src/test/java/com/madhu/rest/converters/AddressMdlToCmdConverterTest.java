package com.madhu.rest.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.madhu.rest.Models.Address;
import com.madhu.rest.commands.AddressCommand;

public class AddressMdlToCmdConverterTest {

	private static final String ADDRESS_LINE = "2350 Club Meridian Drive";
	private static final String CITY = "Okemos";
	private static final Integer ZIP = 48864;
	private static final Long ID = 1L;
	private AddressMdlToCmdConverter addressMdlToCmdConverter;
	
	@Before
	public void setUp() throws Exception {
		addressMdlToCmdConverter = new AddressMdlToCmdConverter();
	}

	@Test
	public void testConvert() {
		//given
		Address model = new Address();
		model.setId(ID);
		model.setAddress_line(ADDRESS_LINE);
		model.setCity(CITY);
		model.setZip(ZIP);
		
		//when
		AddressCommand command = addressMdlToCmdConverter.convert(model);
		
		//Then
		assertEquals(ID, command.getId());
		assertEquals(ADDRESS_LINE, command.getAddress_line());
		assertEquals(ZIP, command.getZip());
		assertEquals(CITY, command.getCity());
	}

}
