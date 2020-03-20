/**
 * 
 */
package com.madhu.spring.mysql.Converters;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.madhu.spring.mysql.Entity.Cars;
import com.madhu.spring.mysql.Models.CarsModel;

/**
 * @author Madhu
 *
 */
@Component
public class CarsEntityToModelConverter {
	
	public CarsModel convert(Cars car) {
		CarsModel model = new CarsModel();
		BeanUtils.copyProperties(car, model);
		return model;
	}

}
