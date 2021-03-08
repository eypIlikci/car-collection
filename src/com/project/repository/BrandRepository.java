package com.project.repository;

import java.util.List;

import com.project.entity.Brand;

/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
public interface BrandRepository extends JpaSupport {
	void save(Brand brand);
	void delete(Brand brand);
	List<Brand> findAll();
	Brand findId(Integer id);
}
