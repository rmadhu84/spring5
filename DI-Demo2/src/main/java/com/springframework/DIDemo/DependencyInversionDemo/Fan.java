package com.springframework.DIDemo.DependencyInversionDemo;

public class Fan implements Switchable {

	/* (non-Javadoc)
	 * @see com.springframework.DIDemo.DependencyInversionDemo.Switchable#turnOn()
	 */
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Fan : The fan is turned on !!! ");
	}

	/* (non-Javadoc)
	 * @see com.springframework.DIDemo.DependencyInversionDemo.Switchable#turnOff()
	 */
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Fan : The fan is turned off !!!");
	}

}
