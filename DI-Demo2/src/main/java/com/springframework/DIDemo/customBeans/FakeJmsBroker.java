/**
 * 
 */
package com.springframework.DIDemo.customBeans;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Madhu
 *
 */
@Getter
@Setter
public class FakeJmsBroker {
	
	private String username;
	private String pwd;
	private String URL;
	private String defaultProp;
	
}
