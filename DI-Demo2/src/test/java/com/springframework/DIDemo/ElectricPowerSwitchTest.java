/**
 * 
 */
package com.springframework.DIDemo;

import org.junit.Test;

import com.springframework.DIDemo.DependencyInversionDemo.ElectricPowerSwitch;
import com.springframework.DIDemo.DependencyInversionDemo.Fan;
import com.springframework.DIDemo.DependencyInversionDemo.LightBulb;
import com.springframework.DIDemo.DependencyInversionDemo.Switch;
import com.springframework.DIDemo.DependencyInversionDemo.Switchable;

/**
 * @author Madhu
 *
 */
public class ElectricPowerSwitchTest {

	@Test
	public void testPress() throws Exception{
		Switchable switchableBulb = new LightBulb();
		Switchable switchableFan = new Fan();
		
		Switch bulbPowerSwitch  = new ElectricPowerSwitch(switchableBulb);
		bulbPowerSwitch.press();
		bulbPowerSwitch.press();
		
		Switch fanPowerSwitch = new ElectricPowerSwitch(switchableFan);
		fanPowerSwitch.press();
		fanPowerSwitch.press();
	}
}
