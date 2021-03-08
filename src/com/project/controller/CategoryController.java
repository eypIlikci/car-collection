package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Category;
import com.project.service.CategoryService;


/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
@Controller
public class CategoryController {
	@Autowired
	private CategoryService catService;
	
	@RequestMapping(value = "/categories")
	public String categories(Model m) {
		m.addAttribute("properties",catService.findALL());
		m.addAttribute("reqMap","Category");
		return "properties";
	}
	
	@RequestMapping(value = "/category/add")
	public String addForm(Model m) {
		m.addAttribute("property",new Category());
		m.addAttribute("reqMap","Category");
		return "addProperty";
	}
	
	@RequestMapping(value = "/category/add",method = RequestMethod.POST)
	public String add(@ModelAttribute("property") Category newCat) {
		catService.save(newCat);
		return "redirect:/categories";
	}
	
	@RequestMapping(value = "/category/delete")
	public String delete(@RequestParam("id") Integer id) {
		Category cat=catService.findById(id);
		if (cat==null) {
			return "redirect:/categories"; 
		}else {
			catService.delete(cat);
			return "redirect:/categories"; 
		}
		
	}
}
