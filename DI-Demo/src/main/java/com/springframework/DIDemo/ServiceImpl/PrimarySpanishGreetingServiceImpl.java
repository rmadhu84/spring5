/**
 * 
 */
package com.springframework.DIDemo.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.DIDemo.Service.GreetingService;
import com.springframework.DIDemo.repository.GreetingRepository;

/**
 * @author Madhu
 *
 */
//@Service
//@Primary
//@Profile(value="es")
public class PrimarySpanishGreetingServiceImpl implements GreetingService {

	private GreetingRepository greetingRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(PrimarySpanishGreetingServiceImpl.class);


	/**
	 * @param greetingRepo
	 */
	public PrimarySpanishGreetingServiceImpl(GreetingRepository greetingRepo) {
		super();
		this.greetingRepo = greetingRepo;
		logger.info("#### We are in Primary Spanish Greeting Service !!! ");
	}



	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		//		System.out.println("Hola: desde el servicio de saludo primario");
		return greetingRepo.greetInSpanish();	
	}

}
