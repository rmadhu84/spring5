/**
 * 
 */
package com.madhu.springboot.REST.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ramachandranm1
 *
 */
@JsonIgnoreProperties
@Data
public class Greet {
	String message;
}
