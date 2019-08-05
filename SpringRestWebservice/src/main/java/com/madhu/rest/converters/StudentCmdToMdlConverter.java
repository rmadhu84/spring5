/**
 * 
 */
package com.madhu.rest.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.madhu.rest.Models.Student;
import com.madhu.rest.commands.StudentCommand;

import lombok.AllArgsConstructor;
import lombok.Synchronized;

/**
 * @author ramachandranm1
 *
 */
@Component
@AllArgsConstructor
public class StudentCmdToMdlConverter implements Converter<StudentCommand, Student> {

	private final AddressCmdToMdlConverter addressCmdToMdlConverter;
	
	@Override
	@Synchronized
	public Student convert(StudentCommand source) {
		// TODO Auto-generated method stub
		Student model = new Student();
		model.setId(source.getId());
		model.setName(source.getName());
		source.getAddresses().forEach(address->{
			model.addAddress(addressCmdToMdlConverter.convert(address));
		});
		return model;
	}
}
