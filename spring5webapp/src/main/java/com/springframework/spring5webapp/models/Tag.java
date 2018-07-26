/**
 * 
 */
package com.springframework.spring5webapp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ramachandranm1
 *
 */
@Data
public class Tag {
	private Integer tagId;
	private String tagName;

	/**
	 * 
	 */
	public Tag() {
		// TODO Auto-generated constructor stub
	}

}
