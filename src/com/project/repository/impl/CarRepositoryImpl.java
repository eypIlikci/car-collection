package com.project.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.project.entity.Brand;
import com.project.entity.Car;
import com.project.entity.Category;
import com.project.repository.CarRepositoy;

@Repository
public class CarRepositoryImpl extends JpaSupportImpl implements CarRepositoy {

	@Override
	public void save(Car car) {
		getTransaction().begin();
			getManager().persist(car);
		getTransaction().commit();
	}

	@Override
	public void delete(Car car) {
		getTransaction().begin();
			getManager().remove(car);
		getTransaction().commit();
		
	}

	@Override
	public void update(Car car) {
		getTransaction().begin();
			getManager().merge(car);
		getTransaction().commit();
	}

	@Override
	public Car findById(Integer id) {
		getTransaction().begin();
			Car car=getManager().find(Car.class, id);
		getTransaction().commit();
		return car;
	}

	@Override
	public List<Car> findAll() {
		getTransaction().begin();
			TypedQuery<Car> query=getManager().createNamedQuery("Car.findAll", Car.class);
		getTransaction().commit();
		return query.getResultList();
	}

	@Override
	public List<Car> findByCategory(Category category) {
		getTransaction().begin();
			TypedQuery<Car> query=getManager().createNamedQuery("Car.findByCategory", Car.class);
			query.setParameter("category", category);
		getTransaction().commit();
		return query.getResultList();
	}

	@Override
	public List<Car> findByBrand(Brand brand) {
		getTransaction().begin();
		TypedQuery<Car> query=getManager().createNamedQuery("Car.findByBrand", Car.class);
			query.setParameter("brand", brand);
		getTransaction().commit();
		return query.getResultList();
	}

}
