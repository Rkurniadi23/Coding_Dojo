package com.codingdojo.beltexam.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltexam.models.Guest;
import com.codingdojo.beltexam.models.Server;
import com.codingdojo.beltexam.repositories.GuestRepository;

@Service
public class GuestService {
	@Autowired
	private GuestRepository guestRepo;
	
	public ArrayList<Guest> findAll() {
		return guestRepo.findAll();
	}
	
	public Guest addGuest(Guest guest) {
		return guestRepo.save(guest);
	}
	
	public Guest findById(Long id){
		return guestRepo.findById(id).orElse(null);
	}
	
	public Guest editGuest(Guest guest) {
		return guestRepo.save(guest);
	}
	
	public ArrayList<Guest> getAssignedGuests(Server server){
		return guestRepo.findAllByServer(server);
	}
	
	public void deleteGuest(Guest guest) {
		guestRepo.delete(guest);
	}
}
