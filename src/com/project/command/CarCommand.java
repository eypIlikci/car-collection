package com.project.command;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
public class CarCommand {
	private Integer id;
	private String model;
	private int year;
	private Integer brandId;
	private List<Integer> catsId=new ArrayList<Integer>();
	
	
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public List<Integer> getCatsId() {
		return catsId;
	}
	public void setCatsId(List<Integer> catsId) {
		this.catsId = catsId;
	}
	
	
}
