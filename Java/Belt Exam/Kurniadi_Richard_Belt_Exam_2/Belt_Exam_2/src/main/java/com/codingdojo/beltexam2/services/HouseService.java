package com.codingdojo.beltexam2.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltexam2.models.House;
import com.codingdojo.beltexam2.repositories.HouseRepository;

@Service
public class HouseService {
	@Autowired
	private HouseRepository houseRepo;
	
	public ArrayList<House> findAll() {
		return houseRepo.findAll();
	}
	
	public House addHouse(House house) {
		return houseRepo.save(house);
	}
	
	public House findById(Long id){
		return houseRepo.findById(id).orElse(null);
	}
	
	public House editHouse(House house) {
		return houseRepo.save(house);
	}
	
	public void deleteHouse(House house) {
		houseRepo.delete(house);
	}
}
