/**
 * 
 */
package com.madhu.springboot.recap.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.madhu.springboot.recap.customBeans.User;

/**
 * @author ramachandranm1
 *
 */
@Configuration
public class PropertyConfiguration {

	@Autowired
	Environment env;
	
	@Value("${com.madhu.springboot.recap.firstName}")
	String firstName;
	
	@Value("${com.madhu.springboot.recap.lastName}")
	String lastName;
	
	@Bean
	public User user() {
		User user = new User(firstName, lastName);
		return user;
	}
	
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
