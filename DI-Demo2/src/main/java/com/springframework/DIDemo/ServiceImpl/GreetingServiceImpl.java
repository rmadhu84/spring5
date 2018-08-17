package com.springframework.DIDemo.ServiceImpl;

import org.springframework.stereotype.Service;

import com.springframework.DIDemo.Service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
//		System.out.println("Greeting from first Impl: Injected by Constructor Based Injection !!!");
		return new String("Greeting from first Impl: Injected by Constructor Based Injection !!!");
	}

}
