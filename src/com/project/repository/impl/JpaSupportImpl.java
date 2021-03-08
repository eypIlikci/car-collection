package com.project.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.repository.JpaSupport;

public abstract class JpaSupportImpl implements JpaSupport {

	@Autowired
	private EntityManager manager;
	@Autowired
	private EntityTransaction transaction;
	
	@Override
	public EntityManager getManager() {
		
		return this.manager;
	}

	@Override
	public EntityTransaction getTransaction() {
		
		return this.transaction;
	}

	@Override
	public void clear() {
		this.transaction.begin();
			this.manager.clear();
		this.transaction.commit();
	}
	
	

}
