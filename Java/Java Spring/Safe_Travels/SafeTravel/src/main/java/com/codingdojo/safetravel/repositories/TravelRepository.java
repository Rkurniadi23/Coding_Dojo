package com.codingdojo.safetravel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.safetravel.models.Travels;

@Repository
public interface TravelRepository extends CrudRepository<Travels, Long>{
	// this method retrieves all the travels from the database
    List<Travels> findAll();
}
