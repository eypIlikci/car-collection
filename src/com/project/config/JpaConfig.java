package com.project.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = { "com.project" }, 
	excludeFilters = { @Filter(type = FilterType.ANNOTATION, 
	value = Configuration.class) })
public class JpaConfig {
	@Bean
	public EntityManager manager() {
		
		return  Persistence.createEntityManagerFactory("postgres")
				 .createEntityManager();
	}
	@Bean
	public EntityTransaction transaction() {
		return manager().getTransaction();
	}
}
