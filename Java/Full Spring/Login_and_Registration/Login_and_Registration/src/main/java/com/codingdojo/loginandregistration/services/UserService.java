package com.codingdojo.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.loginandregistration.models.UserLogin;
import com.codingdojo.loginandregistration.models.UserRegistration;
import com.codingdojo.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepo;
    
    public UserRegistration register(UserRegistration newUser) {
        
        return userRepo.save(newUser);
    }
    
    public boolean isValid(BindingResult result, UserRegistration newUser) {
    	
    	
    	if (!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "Password must match confirm password");
    		return false;
    	}
    	
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return true;
    }
    
    public UserRegistration login(UserLogin newLoginObject, BindingResult result) {
        
    	Optional<UserRegistration> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Invalid User!");
    		return null;
    	}
    	
    	UserRegistration user = potentialUser.get();
        
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
        	return null;
        }

    	return user;
    }
    
    public UserRegistration findById(Long id) {
    	Optional<UserRegistration> potentialUser = userRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }
}
