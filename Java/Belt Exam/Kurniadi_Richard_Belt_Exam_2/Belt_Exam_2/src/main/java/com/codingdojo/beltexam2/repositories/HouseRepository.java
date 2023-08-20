package com.codingdojo.beltexam2.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.beltexam2.models.House;
import com.codingdojo.beltexam2.models.User;

public interface HouseRepository extends CrudRepository<House, Long>{
	public ArrayList<House> findAll();
	public ArrayList<House> findAllByUser(User user);
}
