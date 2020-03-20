/**
 * 
 */
package com.madhu.spring.mysql.Converters;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.madhu.spring.mysql.Entity.Cars;
import com.madhu.spring.mysql.Models.CarsModel;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

/**
 * @author Madhu
 *
 */
@Component
public class CarsModelToEntityConverter {

	public Cars convert(CarsModel model) {
		Cars car = new Cars();
		BeanUtils.copyProperties(model, car);
		return car;
		
	}
}
