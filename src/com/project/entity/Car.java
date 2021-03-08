package com.project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
@Entity
@NamedQueries({
	@NamedQuery(name="Car.findAll",query = "select c from Car c"),
	@NamedQuery(name="Car.findByBrand",query = "select c from Car c where c.brand=:brand"),
	@NamedQuery(name="Car.findByCategory",query = "select c from Car c join c.categories cat where cat=:category")
})
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String model;
	private int year;
	
	@ManyToOne
	private Brand brand;
	
	@ManyToMany
	@JoinTable(name="car_cats",
				joinColumns = @JoinColumn(name = "car_id")
				,inverseJoinColumns = @JoinColumn(name = "cat_id"))
	private List<Category> categories=new ArrayList<Category>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
