package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Brand;
import com.project.entity.Category;
import com.project.service.BrandService;
/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value = "/brands")
	public String brands(Model m) {
		m.addAttribute("properties",brandService.findAll());
		m.addAttribute("reqMap","Brand");
		return "properties";
	}
	@RequestMapping(value = "/brand/add")
	public String addForm(Model m) {
		m.addAttribute("property",new Brand());
		m.addAttribute("reqMap","Brand");
		return "addProperty";
	}
	
	@RequestMapping(value = "/brand/add",method = RequestMethod.POST)
	public String add(@ModelAttribute("property") Brand newBrand) {
		brandService.save(newBrand);
		return "redirect:/brands";
	}
	
	@RequestMapping(value = "/brand/delete")
	public String delete(@RequestParam("id") Integer id) {
		Brand brand=brandService.findById(id);
		if (brand==null) {
			return "redirect:/brands";
		}else {
			brandService.delete(brand);
			return "redirect:/brands";
		}
		
	}
}
