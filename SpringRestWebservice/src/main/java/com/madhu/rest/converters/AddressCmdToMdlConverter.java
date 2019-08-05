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
public class AddressCmdToMdlConverter implements Converter<AddressCommand, Address>{

	@Override
	public Address convert(AddressCommand source) {
		// TODO Auto-generated method stub
		Address model = new Address();
		BeanUtils.copyProperties(source, model);
		return model;
	}

}
