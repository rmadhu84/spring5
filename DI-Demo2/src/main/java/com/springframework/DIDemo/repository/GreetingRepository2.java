/**
 * 
 */
package com.springframework.DIDemo.repository;

/**
 * @author Madhu
 *
 */
public interface GreetingRepository2 {

	String primaryGreet();
	String contructorInjectedGreet();
	String setterInjectedGreet();
	String propertyInjectedGreet();
}
