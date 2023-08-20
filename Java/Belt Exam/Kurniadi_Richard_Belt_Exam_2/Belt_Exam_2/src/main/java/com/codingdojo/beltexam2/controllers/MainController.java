package com.codingdojo.beltexam2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.beltexam2.models.House;
import com.codingdojo.beltexam2.models.User;
import com.codingdojo.beltexam2.models.UserLogin;
import com.codingdojo.beltexam2.services.HouseService;
import com.codingdojo.beltexam2.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private HouseService houseService;
	
	@GetMapping("/")
    public String index(Model model) {
    
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new UserLogin());
        return "index.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	User user = userService.createUser(newUser, result);
        
        if(result.hasErrors()) {
            
            model.addAttribute("newLogin", new UserLogin());
            return "index.jsp";
        }
        
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
    	User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }
    
    @GetMapping("/home")
	public String dashboard(Model model, HttpSession session) {
		
    	if(session.getAttribute("userId") == null){
    		return "redirect:/";
    	}

    	model.addAttribute("house", houseService.findAll());
    	model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
    
    	return "dashboard.jsp";
	}
    
    @GetMapping("/listings/new")
	public String table(@ModelAttribute("house") House house,
			Model model, HttpSession session) {
    	
    	User user = userService.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
		return "create.jsp";
	}
    
    @PostMapping("/listings/create")
	public String createTable(@Valid @ModelAttribute("house") House house,
			BindingResult result, HttpSession session) {
    	
    	User user = userService.findById((Long)session.getAttribute("userId"));
    	
    	if(result.hasErrors()) {
    		return "create.jsp";
    	}

    	house.setUser(user);
		houseService.addHouse(house);
		return "redirect:/home";
	}
    
    @GetMapping("/listings/{id}")
	public String view(@PathVariable("id") Long id, Model model,
			HttpSession session) {
    	if(session.getAttribute("userId") == null){
    			return "redirect:/books";
    	}
    	
		model.addAttribute("house", houseService.findById(id));
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		return "listings.jsp";
	}
    
    @GetMapping("/listings/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model,
			HttpSession session) {	
    	
    	if(session.getAttribute("userId") == null){
			return "redirect:/books";
	}
		model.addAttribute("house", houseService.findById(id));
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		return "edit.jsp";
	}
    
    @PutMapping("/listings/{id}/edit/edit")
	public String update(
			@PathVariable("id") Long id, 
			Model model, 
			@Valid @ModelAttribute("house") House house, 
			BindingResult result, HttpSession session) {
    	
    	User user = userService.findById((Long)session.getAttribute("userId"));
    	
		if(result.hasErrors()) {
			model.addAttribute("house", houseService.findById(id));
			return "redirect:/tables/{id}/edit";
		}else {
			
			house.setUser(user);
			houseService.editHouse(house);
			return "redirect:/home";
		}
	}
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @RequestMapping("/house/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		House house = houseService.findById(id);
		houseService.deleteHouse(house);
		return "redirect:/home";
		
	}
}
