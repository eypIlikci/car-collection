package com.project.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.project.entity.Brand;
import com.project.entity.Category;
import com.project.repository.CategoryRepository;

@Repository
public class CategoryRepositoryImpl extends JpaSupportImpl implements CategoryRepository {

	@Override
	public void save(Category category) {
		getTransaction().begin();
			getManager().persist(category);
		getTransaction().commit();
	}

	@Override
	public void delete(Category category) {
		getTransaction().begin();
			getManager().remove(category);
		getTransaction().commit();
		}

	@Override
	public List<Category> findALL() {
		getTransaction().begin();
			TypedQuery<Category> query=getManager().createNamedQuery("Category.findAll",Category.class);
		getTransaction().commit();
		return query.getResultList();
	}

	@Override
	public Category findId(Integer id) {
		getTransaction().begin();
		Category cat=getManager().find(Category.class, id);
		getTransaction().commit();
		return cat;
	}

}
