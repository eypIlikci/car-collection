package com.project.service;

import java.util.List;

import com.project.entity.Brand;
import com.project.entity.Category;
/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
public interface CategoryService {
	void save(Category category);
	void delete(Category category);
	List<Category> findALL();
	Category findById(Integer id);
}
