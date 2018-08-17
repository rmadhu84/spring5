/**
 * 
 */
package com.springframework.DIDemo.repositoryImpl;

import org.springframework.stereotype.Component;

import com.springframework.DIDemo.repository.GreetingRepository;
import com.springframework.DIDemo.repository.GreetingRepository2;

/**
 * @author Madhu
 *
 */
@Component
public class DeutschGreetingRepositoryImpl implements GreetingRepository2 {


	@Override
	public String primaryGreet() {
		// TODO Auto-generated method stub
		return  new String("Hallo - Primäre Begrüßung auf Deutsch !!!");
	}

	@Override
	public String contructorInjectedGreet() {
		// TODO Auto-generated method stub
		return new String("Hallo - Injiziert von Konstruktor-basierten DI !!! ");
	}

	@Override
	public String setterInjectedGreet() {
		// TODO Auto-generated method stub
		return new String("Hallo - Injiziert von Setter Based DI !!! ");
	}

	@Override
	public String propertyInjectedGreet() {
		// TODO Auto-generated method stub
		return new String("Hallo - Injiziert von Property Based DI !!! ");
	}

}
