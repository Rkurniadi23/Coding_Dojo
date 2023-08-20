package com.codingdojo.safetravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.safetravel.models.Travels;
import com.codingdojo.safetravel.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	@Autowired
	TravelService travelService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("travel") Travels travel, Model model) {
		List<Travels> travels = travelService.allTravels();
		model.addAttribute("travels", travels);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String index(@Valid @ModelAttribute("travel") Travels travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Travels> travels = travelService.allTravels();
			model.addAttribute("travels", travels);
			return "index.jsp";
		}else {
			travelService.createTravel(travel);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("travel", travelService.findTravel(id));
		return "edit.jsp";
	}
	
	@PostMapping("/expenses/edit/{id}")
	public String update(
			@PathVariable("id") Long id, 
			Model model, 
			@Valid @ModelAttribute("travel") Travels travel, 
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("travel", travelService.findTravel(id));
			return "redirect:/edit/{id}";
		}else {
			travelService.updateTravel(travel);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/{id}")
	public String showExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("travel", travelService.findTravel(id));
		return "view.jsp";
	}
	
	@RequestMapping("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		Travels travels = travelService.findTravel(id);
		travelService.deleteTravel(travels);
		return "redirect:/expenses";
	}
}
