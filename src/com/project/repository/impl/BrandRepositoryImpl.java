package com.project.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.project.entity.Brand;
import com.project.repository.BrandRepository;

@Repository
public class BrandRepositoryImpl extends JpaSupportImpl implements BrandRepository {

	@Override
	public void save(Brand brand) {
		getTransaction().begin();
			getManager().persist(brand);
		getTransaction().commit();
	}

	@Override
	public void delete(Brand brand) {
		getTransaction().begin();
			getManager().remove(brand);
		getTransaction().commit();
	}

	@Override
	public List<Brand> findAll() {
		getTransaction().begin();
			TypedQuery<Brand> query=getManager().createNamedQuery("Brand.findAll",Brand.class);
		getTransaction().commit();
		return query.getResultList();
	}

	@Override
	public Brand findId(Integer id) {
		getTransaction().begin();
			Brand brand=getManager().find(Brand.class, id);
		getTransaction().commit();
		return brand;
	}

}
