/**
 * 
 */
package com.springframework.DIDemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.DIDemo.Service.GreetingService;
import com.springframework.DIDemo.factory.GreetingServiceFactory;
import com.springframework.DIDemo.repository.GreetingRepository;

/**
 * @author Madhu
 *
 */
@Configuration
public class GreetingConfiguration {

	@Bean
	GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepo) {
		return new GreetingServiceFactory(greetingRepo);
	}
	
	@Bean
	@Primary
	@Profile({"default", "en"})
	public GreetingService primaryGreetingServiceImpl(GreetingServiceFactory factory) {
		return factory.createGreetingService("en");
	}
	
	@Bean
	@Primary
	@Profile("es")
	public GreetingService primarySpanishGreetingServiceImpl(GreetingServiceFactory factory) {
		return factory.createGreetingService("es");
	}
	
	@Bean
	@Primary
	@Profile("de")
	public GreetingService primaryGermanGreetingServiceImpl(GreetingServiceFactory factory) {
		return factory.createGreetingService("de");
	}
}
