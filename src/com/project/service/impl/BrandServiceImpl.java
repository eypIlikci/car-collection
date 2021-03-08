package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Brand;
import com.project.entity.Car;
import com.project.repository.BrandRepository;
import com.project.repository.CarRepositoy;
import com.project.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepo;
	@Autowired
	private CarRepositoy carRepo;
	@Override
	public void save(Brand brand) {
		try {
			brandRepo.save(brand);
		} catch (Exception e) {
		}
		
	}
	@Override
	public void delete(Brand brand) {
		try {
			List<Car> cars=carRepo.findByBrand(brand);
			for (Car car : cars) {
				car.setBrand(null);
				carRepo.update(car);
			}
			
			brandRepo.delete(brand);
			brandRepo.clear();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public List<Brand> findAll() {
		try {
			
		 	List<Brand> list=brandRepo.findAll();
		 	return list;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Brand findById(Integer id) {
		try {
			Brand brand=brandRepo.findId(id);
			return brand;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
