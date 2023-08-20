package com.codingdojo.dojosandninjas.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository repo) {
		this.dojoRepo = repo;
	}
	
	public ArrayList<Dojo> findAll() {
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo findById(Long id){
		return dojoRepo.findById(id).orElse(null);
	}
}
