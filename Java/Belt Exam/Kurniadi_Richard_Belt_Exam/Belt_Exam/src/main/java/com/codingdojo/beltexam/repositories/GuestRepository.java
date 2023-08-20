package com.codingdojo.beltexam.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.beltexam.models.Guest;
import com.codingdojo.beltexam.models.Server;

public interface GuestRepository extends CrudRepository<Guest, Long>{
	public ArrayList<Guest> findAll();
	public ArrayList<Guest> findAllByServer(Server server);
}
