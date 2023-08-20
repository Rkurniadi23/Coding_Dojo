package com.codingdojo.loginandregistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.loginandregistration.models.UserRegistration;

@Repository
public interface UserRepository extends CrudRepository<UserRegistration, Long>{
	Optional<UserRegistration> findByEmail(String email);
}
