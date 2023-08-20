package com.codingdojo.omikujiForm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/omikuji")
	public String indexOmikuji() {
		return "index.jsp";
	}
	
	@PostMapping(value="/process")
	public String process(
			@RequestParam(value="num") int num,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="comment") String comment,
			HttpSession session){
		String omikujiText = String.format(
				"In %s years you will live in %s with %s as your roommate, %s. "
						+ "The next time you see a %s, you will have good luck. Also, %s.",
						num, city, person, hobby, thing, comment);
		
		session.setAttribute("omikujiText", omikujiText);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		
		String text = (String) session.getAttribute("omikujiText");
		model.addAttribute("text", text);
		
		return "show.jsp";
	}
	
}
