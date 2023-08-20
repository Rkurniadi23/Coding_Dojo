package com.codingdojo.dojosandninjas.controllers;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;


@Controller
public class MainControllers {

	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/dojos/new")
	public String dojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojosnew.jsp";
	}
	
	@PostMapping("/dojos/create")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		dojoService.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/ninjas/new")
	public String ninja(
			Model model,
			@ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.findAll());
		return "ninjasnew.jsp";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(
			@ModelAttribute("ninja") Ninja ninja) {
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	
	@GetMapping("/dojos/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findById(id));
		return "show.jsp";
	}
}
