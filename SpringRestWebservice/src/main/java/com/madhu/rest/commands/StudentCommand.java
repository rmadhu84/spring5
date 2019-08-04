/**
 * 
 */
package com.madhu.rest.commands;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Madhu
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class StudentCommand {

	private Long id;
	private String name;
	private Set<AddressCommand> addresses = new HashSet<AddressCommand>();
	
	public StudentCommand addAddress(AddressCommand address) {
		this.addresses.add(address);
		return this;
	}
}
