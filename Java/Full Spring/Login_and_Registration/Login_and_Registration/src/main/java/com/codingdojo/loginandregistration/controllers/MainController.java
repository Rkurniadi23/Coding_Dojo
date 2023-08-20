package com.codingdojo.loginandregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginandregistration.models.UserLogin;
import com.codingdojo.loginandregistration.models.UserRegistration;
import com.codingdojo.loginandregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	 
	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new UserRegistration());
        model.addAttribute("newLogin", new UserLogin());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") UserRegistration newUser, 
            BindingResult result, Model model, HttpSession session) {
    	
    	boolean isValid = userService.isValid(result, newUser);
        
        if(result.hasErrors() || isValid != true) {
            return "welcomepage.jsp";
        }
        
        userService.register(newUser);

        return "redirect:/welcome";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    	UserRegistration user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new UserRegistration());
            return "welcomepage.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", user.getId());
        return "redirect:/welcome";
    }
    
    @GetMapping("/welcome")
    public String welcome(Model model, HttpSession session) {
   	 	Long userId = (Long) session.getAttribute("userId");
   	 	if(userId==null) {
   	 		return "redirect:/";
   	 	}
   	 	UserRegistration user = userService.findById(userId);
   	 	model.addAttribute("user",user);
   	 	return "welcomepage.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.setAttribute("userId", null);
    	return "redirect:/";
    }
}
