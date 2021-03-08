package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Brand;
import com.project.entity.Car;
import com.project.entity.Category;
import com.project.repository.CarRepositoy;
import com.project.repository.CategoryRepository;
import com.project.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private CarRepositoy carRepo;
	
	@Override
	public void save(Category category) {
		try {
			catRepo.save(category);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(Category category) {
		try {
			List<Car> cars=carRepo.findByCategory(category);
			for (Car car : cars) {
				car.setCategories(null);
				carRepo.update(car);
			}
			catRepo.delete(category);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public List<Category> findALL() {
		try {
			List<Category> list=catRepo.findALL();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Category findById(Integer id) {
		try {
			Category cat=catRepo.findId(id);
			return cat;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	

}
