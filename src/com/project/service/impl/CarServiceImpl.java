package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Brand;
import com.project.entity.Car;
import com.project.entity.Category;
import com.project.repository.CarRepositoy;
import com.project.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepositoy carRepo;
	@Override
	public void save(Car car) {
		try {
			carRepo.save(car);
		} catch (Exception e) {
		}
	}

	@Override
	public void delete(Car car) {
		try {
			
			carRepo.delete(car);
			carRepo.clear();
		} catch (Exception e) {
		}
	}

	@Override
	public void update(Car car) {
			try {
				carRepo.update(car);
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	@Override
	public Car findById(Integer id) {
		try {
			Car car=carRepo.findById(id);
			return car;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Car> findAll() {
		try {
			List<Car> list=carRepo.findAll();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Car> findByCategory(Category category) {
		try {
			List<Car> list=carRepo.findByCategory(category);
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Car> findByBrand(Brand brand) {
		try {
			List<Car> list=carRepo.findByBrand(brand);
			return list;
		} catch (Exception e) {
			return null;
		}
	}

}
