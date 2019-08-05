/**
 * 
 */
package com.madhu.rest.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.madhu.rest.Models.Student;
import com.madhu.rest.commands.StudentCommand;

import lombok.AllArgsConstructor;

/**
 * @author ramachandranm1
 *
 */
@Component
@AllArgsConstructor
public class StudentMdlToCmdConverter implements Converter<Student, StudentCommand> {

	AddressMdlToCmdConverter addressMdlToCmdConverter;
	
	@Override
	public StudentCommand convert(Student source) {
		StudentCommand command = new StudentCommand();
		command.setId(source.getId());
		command.setName(source.getName());
		source.getAddresses().forEach(address->{
			command.addAddress(addressMdlToCmdConverter.convert(address));
		});
		return command;
	}

}
