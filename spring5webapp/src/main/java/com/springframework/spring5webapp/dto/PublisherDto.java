/**
 * 
 */
package com.springframework.spring5webapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Madhu
 *
 */
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class PublisherDto {

private Long id;
	
	@NonNull private String publisherName;
	
	@NonNull private String addressLine1;
	private String addressLine2;
	@NonNull private String city;
	@NonNull private String state;
	@NonNull private Integer zipcode;
	


}
