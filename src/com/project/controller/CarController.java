package com.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.command.CarCommand;
import com.project.entity.Brand;
import com.project.entity.Car;
import com.project.entity.Category;
import com.project.service.BrandService;
import com.project.service.CarService;
import com.project.service.CategoryService;
/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
@Controller
public class CarController {
	@Autowired
	private CarService carService;	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private CategoryService catService;
	
	
	@RequestMapping(value ={"/","/index"})
	public String index(Model m) {
		m.addAttribute("cars",carService.findAll());
		return "index";
	}
	
	@RequestMapping(value ="/car/add")
	public String addForm(Model m) {
		
		m.addAttribute("car",new CarCommand());
		m.addAttribute("brands",brandService.findAll());
		m.addAttribute("categories",catService.findALL());
		m.addAttribute("reqMap","Add");
		
		return "carForm";
	}
	
	@RequestMapping(value ="/car/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("car") CarCommand newCar) {
				
		Car car=new Car();
		car.setModel(newCar.getModel());
		car.setYear(newCar.getYear());
		
		//--Set Dependency 
		car.setBrand(brandService.findById(newCar.getBrandId()));
		if ( newCar.getCatsId()!=null && newCar.getCatsId().size()>0) {
			for(Integer catId:newCar.getCatsId()) {
				car.getCategories().add(catService.findById(catId));
			}
		
		}
		carService.save(car);
		
		return "redirect:/index";
	}
	
	
	@RequestMapping(value = "/car/{modelAndBrand}/{carId}")
	public String detail(Model m,
					@PathVariable("carId") Integer carId) {
		Car car=carService.findById(carId);
		if (car==null) {
			//--false id value
			return "redirect:/index";
		}else {
			m.addAttribute("car",car);
			return "detail";
		}
		
	
	}
	
	@RequestMapping(value = "/car/edit")
	public String editForm(Model m,
				@RequestParam(value="carId") Integer carId) {
		Car car=carService.findById(carId);
		if (car==null) {
			//--false carId
			return "redirect:/index";
		}else {
			
			CarCommand carCmd=new CarCommand();
			carCmd.setId(carId);
			carCmd.setModel(car.getModel());
			carCmd.setYear(car.getYear());
			
			//--set dependency
			if (car.getBrand()!=null) {
				carCmd.setBrandId(car.getBrand().getId());
			}
			
			if ( car.getCategories()!=null && car.getCategories().size()>0) {
				for(Category cat: car.getCategories()) {
					carCmd.getCatsId().add(cat.getId());
				}
			}
			
			//--
			m.addAttribute("car", carCmd);
			m.addAttribute("brands",brandService.findAll());
			m.addAttribute("categories",catService.findALL());
			
			m.addAttribute("reqMap","Edit");
			System.out.println("-->"+carCmd.getId());
			return "carForm";
		}
		
	}
	
	@RequestMapping(value = "/car/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("car") CarCommand editCarCmd) {
		
		Car car=new Car();
		car.setId(editCarCmd.getId());
		car.setYear(editCarCmd.getYear());
		car.setModel(editCarCmd.getModel());
		car.setBrand(brandService.findById(editCarCmd.getBrandId()));
		if (editCarCmd.getCatsId().size()>0) {
			for (Integer catId: editCarCmd.getCatsId()) {
				car.getCategories().add(catService.findById(catId));
			}
		}
		
		carService.update(car);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/car/delete")
	public String delete(@RequestParam("carId") Integer id) {
		Car car=carService.findById(id);
		if (car!=null) {
			carService.delete(car);
			return "redirect:/index";
		}else {
			return "redirect:/index";
		}
		
	}
	
	@RequestMapping(value = "/cars/{property}/{propertyName}/{propertyId}")
	public String cars(Model m,
				@PathVariable("property") String property,
				@PathVariable("propertyId") Integer propertyId) {
		List<Car> cars=new ArrayList<Car>();
		switch (property) {
		case "brand":
			Brand b=brandService.findById(propertyId);
			m.addAttribute("cars",carService.findByBrand(b));
			return "index";

		case "category":
			Category cat=catService.findById(propertyId);
			m.addAttribute("cars",carService.findByCategory(cat));
			return "index";
		default: return "redirect:/index";
		}
		
		
	
	}
}






















