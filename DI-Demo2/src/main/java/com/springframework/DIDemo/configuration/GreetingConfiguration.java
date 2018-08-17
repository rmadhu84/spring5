/**
 * 
 */
package com.springframework.DIDemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.DIDemo.Service.GreetingService;
import com.springframework.DIDemo.factory.GreetingRepoFactory;
import com.springframework.DIDemo.factory.GreetingServiceFactory;
import com.springframework.DIDemo.repository.GreetingRepository;
import com.springframework.DIDemo.repository.GreetingRepository2;

/**
 * @author Madhu
 *
 */
@Configuration
public class GreetingConfiguration {
	
	@Bean
	GreetingRepoFactory greetingRepoFactory() {
		return new GreetingRepoFactory();
	}
	

	@Bean
	GreetingServiceFactory greetingServiceFactory(GreetingRepository2 greetingRepo) {
		return new GreetingServiceFactory(greetingRepo);
	}
	
	@Bean
	@Primary
	@Profile({"default", "en"})
	public GreetingService primaryGreetingService(GreetingServiceFactory factory) {
		return factory.createGreetingService("en");
	}
	
	@Bean
	@Primary
	@Profile("es")
	public GreetingService primarySpanishGreetingService(GreetingServiceFactory factory) {
		return factory.createGreetingService("es");
	}
	
	@Bean
	@Primary
	@Profile("de")
	public GreetingService primaryGermanGreetingService(GreetingServiceFactory factory) {
		return factory.createGreetingService("de");
	}
}
