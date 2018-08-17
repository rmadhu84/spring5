package com.springframework.DIDemo.ServiceImpl;

import org.springframework.stereotype.Service;

import com.springframework.DIDemo.Service.GreetingService;

@Service
public class SetterGreetingServiceImpl implements GreetingService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub

//		System.out.println("Injected by Setter Based Injection");
		return new String("Injected by Setter Based Injection");
	}

}
