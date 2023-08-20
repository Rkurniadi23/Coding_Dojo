package com.codingdojo.beltexam.services;

import java.util.ArrayList;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.beltexam.models.Server;
import com.codingdojo.beltexam.models.ServerLogin;
import com.codingdojo.beltexam.repositories.ServerRepository;

@Service
public class ServerService {
	@Autowired
    private ServerRepository serverRepo;
	
	public ServerService(ServerRepository repo) {
		this.serverRepo = repo;
	}
	
	public ArrayList<Server> findAll() {
		return serverRepo.findAll();
	}
	
    public Server createServer(Server newServer, BindingResult result) {
    	
    	Optional<Server> potentialServer = serverRepo.findByEmail(newServer.getEmail());
    	
    	if(potentialServer.isPresent()) {
    		result.rejectValue("email", "Matches", "Account already exists");
    	}

    	if(!newServer.getPassword().equals(newServer.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}

        if(result.hasErrors()) {
        	return null;
        }
    
        String hashed = BCrypt.hashpw(newServer.getPassword(), BCrypt.gensalt());
        newServer.setPassword(hashed);
        return serverRepo.save(newServer);
    }
    
    public Server login(ServerLogin newLoginObject, BindingResult result) {
    	
    	Optional<Server> potentialServer = serverRepo.findByEmail(newLoginObject.getEmail());
    	
    	if(!potentialServer.isPresent()) {
    		result.rejectValue("email", "Matches", "Invalid User!");
    		return null;
    	}
    	
    	Server server = potentialServer.get();
        
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), server.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
        	return null;
        }

    	return server;
    }
    
    public Server findById(Long id) {
    	
    	Optional<Server> potentialServer = serverRepo.findById(id);
    	
    	if(potentialServer.isPresent()) {
    		return potentialServer.get();
    	}
    	return null;
    }
    
	public Server findByEmail(String email) {
			
			Optional<Server> potentialServer = serverRepo.findByEmail(email);
			if(potentialServer.isPresent()) {
				return potentialServer.get();
			}
			
			return null;
		}
}
