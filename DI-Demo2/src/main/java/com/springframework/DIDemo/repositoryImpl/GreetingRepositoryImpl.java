/**
 * 
 */
package com.springframework.DIDemo.repositoryImpl;

import org.springframework.stereotype.Component;

import com.springframework.DIDemo.repository.GreetingRepository;

/**
 * @author Madhu
 *
 */
@Component
public class GreetingRepositoryImpl implements GreetingRepository {

	@Override
	public String greetInEnglish() {
		// TODO Auto-generated method stub
		return new String("Hello - Primary Greeting in English !!! ");
	}

	@Override
	public String greetInSpanish() {
		// TODO Auto-generated method stub
		return new String("Hola - Saludo principal en inglés!");
	}

	@Override
	public String greetInGerman() {
		// TODO Auto-generated method stub
		return new String("Hallo - Primäre Begrüßung in Englisch !!!");
	}

}
