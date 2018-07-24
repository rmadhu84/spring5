package com.springframework.spring5webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Spring5webappApplication {
	private static final Logger log =  LoggerFactory.getLogger(Spring5webappApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(Spring5webappApplication.class, args);
	}
}
