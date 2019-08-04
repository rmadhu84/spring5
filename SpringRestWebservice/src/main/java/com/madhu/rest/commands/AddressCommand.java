/**
 * 
 */
package com.madhu.rest.commands;

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
public class AddressCommand {
	
	private Long id;
	private String address_line;
	private String city;
	private Integer zip;

}
