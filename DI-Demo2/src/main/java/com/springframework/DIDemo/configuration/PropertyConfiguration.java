/**
 * 
 */
package com.springframework.DIDemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.springframework.DIDemo.customBeans.FakeDataSource;
import com.springframework.DIDemo.customBeans.FakeJmsBroker;

/**
 * @author Madhu
 *
 */
@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:JmsProperties.properties"})
@PropertySources({
	//@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:JmsProperties.properties")
})
public class PropertyConfiguration {

	@Autowired
	Environment env;
	
	@Value("${com.username}")
	String user;
	
	@Value("${com.password}")
	String pwd;
	
	@Value("${com.dburl}")
	String URL;
	
	@Value("${com.jms.username}")
	String jmsUser;
	
	@Value("${com.jms.password}")
	String jmsPwd;
	
	@Value("${com.jms.url}")
	String jsmURL;
	
	@Value("${com.app.prp.username}")
	String defaultProp;
	
	@Bean
	public FakeDataSource FakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUserName(user);
		fakeDataSource.setPassword(pwd);
		fakeDataSource.setDbURL(URL);
		return fakeDataSource;
	}
	
	@Bean
	public FakeJmsBroker FakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUsername(jmsUser);
		fakeJmsBroker.setPwd(jmsPwd);
		fakeJmsBroker.setURL(jsmURL);
		fakeJmsBroker.setDefaultProp(defaultProp);
		return fakeJmsBroker;
		
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
