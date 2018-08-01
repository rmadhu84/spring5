/**
 * 
 */
package com.springframework.spring5webapp.models;

import static org.junit.Assert.assertFalse;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
