/**
 * 
 */
package com.springframework.spring5webapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Madhu
 *
 */
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull private String publisherName;
	
	@NonNull private String addressLine1;
	private String addressLine2;
	@NonNull private String city;
	@NonNull private String state;
	@NonNull private Integer zipcode;
	private Integer zip4;
	
/*	@OneToOne(mappedBy="publisher", cascade=CascadeType.ALL)
	private Book book;
	*/
	
}
