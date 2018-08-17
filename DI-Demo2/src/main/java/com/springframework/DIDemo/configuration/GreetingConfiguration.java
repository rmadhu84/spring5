/**
 * 
 */
package com.springframework.DIDemo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingConfiguration.class);
	
			
	@Bean
	@Primary
	@Profile({"default", "en"})
	public GreetingRepository2 greetingRepo() {
		logger.info("### Default Repository bean created");
		return new GreetingRepoFactory().createRepository("en");
	}

	@Bean
	@Primary
	@Profile({"es"})
	public GreetingRepository2 spanishGreetingRepo() {
		logger.info("### Spanish Repository bean created");
		return new GreetingRepoFactory().createRepository("es");
	}
	
	@Bean
	@Primary
	@Profile({"de"})
	public GreetingRepository2 deutschGreetingRepo() {
		logger.info("### German Repository bean created");
		return new GreetingRepoFactory().createRepository("de");
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
