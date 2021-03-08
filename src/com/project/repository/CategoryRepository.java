package com.project.repository;

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
public interface CategoryRepository extends JpaSupport {
	
	void save(Category category);
	void delete(Category category);
	List<Category> findALL();
	Category findId(Integer id);
	
}
