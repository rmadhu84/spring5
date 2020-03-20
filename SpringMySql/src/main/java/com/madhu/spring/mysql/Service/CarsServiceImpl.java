/**
 * 
 */
package com.madhu.spring.mysql.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.madhu.spring.mysql.Converters.CarsEntityToModelConverter;
import com.madhu.spring.mysql.Converters.CarsModelToEntityConverter;
import com.madhu.spring.mysql.Entity.Cars;
import com.madhu.spring.mysql.Models.CarsModel;
import com.madhu.spring.mysql.Repository.CarsRepository;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Madhu
 *
 */
@Service
public class CarsServiceImpl implements CarsService {
	
	String PATH = "/Users/Madhu/GitProjects/SpringMySql/src/main/resources/GeneratedDocs/";

	CarsRepository carRepo;
	CarsEntityToModelConverter entityToMdl;
	CarsModelToEntityConverter mdlToEntity;

	@Autowired
	public CarsServiceImpl(CarsRepository carRepo, CarsEntityToModelConverter entityToMdl,
			CarsModelToEntityConverter mdlToEntity) {
		super();
		this.carRepo = carRepo;
		this.entityToMdl = entityToMdl;
		this.mdlToEntity = mdlToEntity;
	}

	@Override
	public List<CarsModel> getAllCars() {
		// TODO Auto-generated method stub
		List<CarsModel> cars = new ArrayList<CarsModel>();
		carRepo.findAll().iterator().forEachRemaining(car -> cars.add(entityToMdl.convert(car)));

		return cars;
	}

	@Override
	public CarsModel add(CarsModel model) {
		// TODO Auto-generated method stub
		Cars entity = carRepo.save(mdlToEntity.convert(model));
		return entityToMdl.convert(entity);
	}

	@Override
	public String generateReport(String format) {
		List<CarsModel> cars = this.getAllCars();
		// Load file and compile
		try {
			File file = ResourceUtils.getFile("classpath:Reports/Inventory.jrxml");
			JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(cars);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Created By", "Madhu Ram");
			JasperPrint jp = JasperFillManager.fillReport(jr, params, datasource);
			switch (format) {
			case "html":
				JasperExportManager.exportReportToHtmlFile(jp, PATH+"Invertory.html");
				break;
			case "pdf":
				JasperExportManager.exportReportToPdfFile(jp, PATH+"Invertory.pdf");
				break;
			default:
				break;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

}
