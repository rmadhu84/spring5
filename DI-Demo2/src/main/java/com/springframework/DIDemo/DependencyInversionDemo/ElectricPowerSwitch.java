package com.springframework.DIDemo.DependencyInversionDemo;

import org.springframework.stereotype.Component;

public class ElectricPowerSwitch implements Switch {

	public Switchable client;
	public Boolean on;

	public boolean isOn() {
        return this.on;
    }

	@Override
	public void press() {
		// TODO Auto-generated method stub
		boolean checkOn = isOn();
		if(checkOn) {
			client.turnOff();
			this.on = false;
		}else {
			client.turnOn();
			this.on = true;
		}
		
	}

	/**
	 * @param client
	 */
	public ElectricPowerSwitch(Switchable client) {
		super();
		this.client = client;
		this.on = false;
	}

	/**
	 * @return the client
	 */
	public Switchable getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Switchable client) {
		this.client = client;
	}

	/**
	 * @return the on
	 */
	public Boolean getOn() {
		return on;
	}

	/**
	 * @param on the on to set
	 */
	public void setOn(Boolean on) {
		this.on = on;
	}



	

}
