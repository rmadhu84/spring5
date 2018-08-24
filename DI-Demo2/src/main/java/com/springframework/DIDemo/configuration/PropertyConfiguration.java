/**
 * 
 */
package com.springframework.DIDemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.springframework.DIDemo.customBeans.FakeDataSource;

/**
 * @author Madhu
 *
 */
@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfiguration {

	@Autowired
	Environment env;
	
	@Value("${com.usernanme}")
	String user;
	
	@Value("${com.password}")
	String pwd;
	
	@Value("${com.dburl}")
	String URL;
	
	@Bean
	public FakeDataSource FakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUserName(user);
		fakeDataSource.setPassword(pwd);
		fakeDataSource.setDbURL(URL);
		return fakeDataSource;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
