package com.codingdojo.beltexam.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.beltexam.models.Server;

public interface ServerRepository extends CrudRepository<Server, Long>{
	public ArrayList<Server> findAll();
	public Optional<Server> findByEmail(String email);

}
