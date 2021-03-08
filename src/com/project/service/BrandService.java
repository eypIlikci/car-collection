package com.project.service;

import java.util.List;

import com.project.entity.Brand;
/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
public interface BrandService {
	void save(Brand brand);
	void delete(Brand brand);
	List<Brand> findAll();
	Brand findById(Integer id);
	
}
