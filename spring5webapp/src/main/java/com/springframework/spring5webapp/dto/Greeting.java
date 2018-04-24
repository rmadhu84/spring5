package com.springframework.spring5webapp.dto;

public class Greeting {

	private String name;
	
	
	/**
	 * @param name
	 */
	public Greeting(String name) {
		super();
		this.name = name;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	public Greeting() {
		// TODO Auto-generated constructor stub
	}

}
