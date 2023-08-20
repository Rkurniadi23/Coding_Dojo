package com.codingdojo.dojosandninjas.services;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository repo) {
		this.ninjaRepo = repo;
	}
	
	public ArrayList<Ninja> findAll() {
		return ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja findByID(Long id){
		return ninjaRepo.findById(id).orElse(null);
	}
	
	public ArrayList<Ninja> byDojo(Dojo dojo){
		return ninjaRepo.findAllByDojo(dojo);
	}
}
