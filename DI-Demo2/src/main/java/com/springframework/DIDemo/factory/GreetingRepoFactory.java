package com.springframework.DIDemo.factory;

import com.springframework.DIDemo.repository.GreetingRepository2;
import com.springframework.DIDemo.repositoryImpl.DeutschGreetingRepositoryImpl;
import com.springframework.DIDemo.repositoryImpl.PrimaryGreetingRepositoryImpl;
import com.springframework.DIDemo.repositoryImpl.SpanishGreetingRepositoryImpl;

public class GreetingRepoFactory {


	public GreetingRepository2 createRepository(String lang) {
		switch(lang) {
		case "en":
			return new PrimaryGreetingRepositoryImpl();
		case "es":
			return new SpanishGreetingRepositoryImpl();
		case "de":
			return new DeutschGreetingRepositoryImpl();
		default:
			return new PrimaryGreetingRepositoryImpl();
		}
	}

	public GreetingRepoFactory() {

	}

}
