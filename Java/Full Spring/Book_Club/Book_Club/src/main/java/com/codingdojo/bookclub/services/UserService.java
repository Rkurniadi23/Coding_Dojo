package com.codingdojo.bookclub.services;

import java.util.ArrayList;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.models.UserLogin;
import com.codingdojo.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepo;
	
	public UserService(UserRepository repo) {
		this.userRepo = repo;
	}
	
	public ArrayList<User> findAll() {
		return userRepo.findAll();
	}
	
    public User createUser(User newUser, BindingResult result) {
    	
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Account already exists");
    	}

    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}

        if(result.hasErrors()) {
        	return null;
        }
    
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
    
    public User login(UserLogin newLoginObject, BindingResult result) {
    	
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Invalid User!");
    		return null;
    	}
    	
    	User user = potentialUser.get();
        
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
        	return null;
        }

    	return user;
    }
    
    public User findById(Long id) {
    	
    	Optional<User> potentialUser = userRepo.findById(id);
    	
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }
    
	public User findByEmail(String email) {
			
			Optional<User> potentialUser = userRepo.findByEmail(email);
			if(potentialUser.isPresent()) {
				return potentialUser.get();
			}
			
			return null;
		}
}
