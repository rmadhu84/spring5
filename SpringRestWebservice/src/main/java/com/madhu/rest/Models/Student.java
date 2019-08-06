/**
 * 
 */
package com.madhu.rest.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ramachandranm1
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="student")
	@JsonIgnoreProperties("student")
	Set<Address> addresses = new HashSet<Address>(); 
	
	public Student addAddress(Address address) {
		address.setStudent(this);
		this.addresses.add(address);
		return this;
	}
}
