package com.project.repository;

import java.util.List;

import com.project.entity.Brand;
import com.project.entity.Car;
import com.project.entity.Category;
/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
public interface CarRepositoy extends JpaSupport {
	
	void save(Car car);
	void delete(Car car);
	void update(Car car);
	Car findById(Integer id);
	List<Car> findAll();
	List<Car> findByCategory(Category category);
	List<Car> findByBrand(Brand brand);
	
	
		
}
