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
public class SpanishGreetingRepositoryImpl implements GreetingRepository2 {


	@Override
	public String primaryGreet() {
		return  new String("Hola - saludo primario en español! ");
	}

	@Override
	public String contructorInjectedGreet() {
		return new String("Hola - Inyectado por Constructor Based DI !!!");
	}

	@Override
	public String setterInjectedGreet() {
		return new String("Hola - Inyectado por Setter Based DI !!! ");
	}

	@Override
	public String propertyInjectedGreet() {
		return new String("Hola: ¡inyectado por DI basado en la propiedad! ");
	}
}
