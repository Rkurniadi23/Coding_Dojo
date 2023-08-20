package com.codingdojo.bookclub.controllers;

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


import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.models.UserLogin;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
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
        return "redirect:/books";
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
        return "redirect:/books";
    }
    
    @GetMapping("/books")
	public String dashboard(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		
    	if(session.getAttribute("userId") == null){
    		return "redirect:/";
    	}
    	
    	model.addAttribute("books", bookService.findAll());
    	model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
    	return "dashboard.jsp";
	}
    
    @GetMapping("/books/new")
	public String book(@ModelAttribute("book") Book book,
			Model model, HttpSession session) {
    	
    	User user = userService.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
		return "create.jsp";
	}
    
    @PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
    	
    	if(result.hasErrors()) {
    		return "create.jsp";
    	}
    	
		bookService.addBook(book);
		return "redirect:/books";
	}
    
    @GetMapping("/books/{id}")
	public String view(@PathVariable("id") Long id, Model model,
			HttpSession session) {
    	if(session.getAttribute("userId") == null){
    			return "redirect:/books";
    	}
    	
		model.addAttribute("book", bookService.findById(id));
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		return "show.jsp";
	}
    
    @GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model,
			HttpSession session) {	
    	
    	if(session.getAttribute("userId") == null){
			return "redirect:/books";
	}
		model.addAttribute("book", bookService.findById(id));
		return "edit.jsp";
	}
    
    @PutMapping("/books/{id}/edit/edit")
	public String update(
			@PathVariable("id") Long id, 
			Model model, 
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result) {
    	
		if(result.hasErrors()) {
			model.addAttribute("book", bookService.findById(id));
			return "redirect:/books/{id}/edit";
		}else {
			bookService.editBook(book);
			return "redirect:/books/{id}";
		}
	}
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @RequestMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		Book book = bookService.findById(id);
		bookService.deleteBook(book);
		return "redirect:/books";
	}
}
