package com.codingdojo.loginandregistration.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.loginandregistration.models.UserRegistration;

@Repository
public interface UserRepository extends CrudRepository<UserRegistration, Long>{
	public ArrayList<UserRegistration> findAll();
	
	public Optional<UserRegistration> findByEmail(String email);
}
