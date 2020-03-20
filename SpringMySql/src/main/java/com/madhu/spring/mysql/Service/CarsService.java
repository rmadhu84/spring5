/**
 * 
 */
package com.madhu.spring.mysql.Service;

import java.util.List;

import com.madhu.spring.mysql.Models.CarsModel;
/**
 * @author Madhu
 *
 */
public interface CarsService {

	public List<CarsModel> getAllCars();
	public CarsModel add(CarsModel model);
	public String generateReport(String format);
}
