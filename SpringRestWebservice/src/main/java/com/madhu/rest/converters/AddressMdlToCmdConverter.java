/**
 * 
 */
package com.madhu.rest.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.madhu.rest.Models.Address;
import com.madhu.rest.commands.AddressCommand;

import lombok.AllArgsConstructor;

/**
 * @author ramachandranm1
 *
 */
@Component
@AllArgsConstructor
public class AddressMdlToCmdConverter implements Converter<Address, AddressCommand> {

	@Override
	public AddressCommand convert(Address source) {
		AddressCommand command = new AddressCommand();
		BeanUtils.copyProperties(source, command);
		return command;
	}

}
