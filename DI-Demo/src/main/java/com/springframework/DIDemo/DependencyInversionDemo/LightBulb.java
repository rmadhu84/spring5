package com.springframework.DIDemo.DependencyInversionDemo;

public class LightBulb implements Switchable {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Light Bulb : The Light Bulb is on !!! ");

	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub

		System.out.println("Light Bulb : The Light Bulb is off !!! ");
	}

}
