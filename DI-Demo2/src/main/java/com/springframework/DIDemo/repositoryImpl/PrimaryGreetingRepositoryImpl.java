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
public class PrimaryGreetingRepositoryImpl implements GreetingRepository2 {


	@Override
	public String primaryGreet() {
		// TODO Auto-generated method stub
		return  new String("Hello - Primary Greeting in English !!! ");
	}

	@Override
	public String contructorInjectedGreet() {
		// TODO Auto-generated method stub
		return new String("Hello - Injected by Constructor Based DI !!! ");
	}

	@Override
	public String setterInjectedGreet() {
		// TODO Auto-generated method stub
		return new String("Hello - Injected by Setter Based DI !!! ");
	}

	@Override
	public String propertyInjectedGreet() {
		// TODO Auto-generated method stub
		return new String("Hello - Injected by Property Based DI !!! ");
	}


}
