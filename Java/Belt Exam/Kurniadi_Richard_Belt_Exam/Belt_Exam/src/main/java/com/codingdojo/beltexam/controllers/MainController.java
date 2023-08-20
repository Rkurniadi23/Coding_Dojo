package com.codingdojo.beltexam.controllers;

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

import com.codingdojo.beltexam.models.Guest;
import com.codingdojo.beltexam.models.Server;
import com.codingdojo.beltexam.models.ServerLogin;
import com.codingdojo.beltexam.services.GuestService;
import com.codingdojo.beltexam.services.ServerService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private ServerService serverService;
	
	@Autowired
	private GuestService guestService;
	
	@GetMapping("/")
    public String index(Model model) {
    
        model.addAttribute("newServer", new Server());
        model.addAttribute("newLogin", new ServerLogin());
        return "index.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newServer") Server newServer, 
            BindingResult result, Model model, HttpSession session) {
        
    	Server server = serverService.createServer(newServer, result);
        
        if(result.hasErrors()) {
            
            model.addAttribute("newLogin", new ServerLogin());
            return "index.jsp";
        }
        
        session.setAttribute("userId", server.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") ServerLogin newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
    	Server server = serverService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newServer", new Server());
            return "index.jsp";
        }
    
        session.setAttribute("userId", server.getId());
        return "redirect:/home";
    }
    
    @GetMapping("/home")
	public String dashboard(Model model, HttpSession session) {
		
    	if(session.getAttribute("userId") == null){
    		return "redirect:/";
    	}

    	model.addAttribute("guests", guestService.findAll());
    	model.addAttribute("server", serverService.findById((Long)session.getAttribute("userId")));
    
    	return "dashboard.jsp";
	}
    
    @GetMapping("/tables/new")
	public String table(@ModelAttribute("guest") Guest guest,
			Model model, HttpSession session) {
    	
    	Server server = serverService.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("server", server);
		return "create.jsp";
	}
    
    @PostMapping("/tables/create")
	public String createTable(@Valid @ModelAttribute("guest") Guest guest,
			BindingResult result, HttpSession session) {
    	
    	Server server = serverService.findById((Long)session.getAttribute("userId"));
    	
    	if(result.hasErrors()) {
    		return "create.jsp";
    	}
    	
    	guest.setServer(server);
		guestService.addGuest(guest);
		return "redirect:/home";
	}
    
    @GetMapping("/tables")
	public String view(Model model,
			HttpSession session) {
    	if(session.getAttribute("userId") == null){
    			return "redirect:/books";
    	}
    	
    	model.addAttribute("guests", guestService.findAll());
    	model.addAttribute("server", serverService.findById((Long)session.getAttribute("userId")));
		return "table.jsp";
	}
    
    @GetMapping("/tables/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model,
			HttpSession session) {	
    	
    	if(session.getAttribute("userId") == null){
			return "redirect:/books";
	}
		model.addAttribute("guest", guestService.findById(id));
		return "edit.jsp";
	}
    
    @PutMapping("/tables/{id}/edit/edit")
	public String update(
			@PathVariable("id") Long id, 
			Model model, 
			@Valid @ModelAttribute("guest") Guest guest, 
			BindingResult result) {
    	
		if(result.hasErrors()) {
			model.addAttribute("guest", guestService.findById(id));
			return "redirect:/tables/{id}/edit";
		}else {
			guestService.editGuest(guest);
			return "redirect:/home";
		}
	}
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @RequestMapping("/tables/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		Guest guest = guestService.findById(id);
		guestService.deleteGuest(guest);
		return "redirect:/home";
		
	}
}
