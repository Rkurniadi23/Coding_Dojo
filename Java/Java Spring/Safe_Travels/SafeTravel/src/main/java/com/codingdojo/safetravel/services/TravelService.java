package com.codingdojo.safetravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.safetravel.models.Travels;
import com.codingdojo.safetravel.repositories.TravelRepository;

@Service
public class TravelService {
	// adding the travel repository as a dependency
    private final TravelRepository travelRepository;
    
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
    // returns all the books
    public List<Travels> allTravels() {
        return travelRepository.findAll();
    }
    // creates a book
    public Travels createTravel(Travels travel) {
        return travelRepository.save(travel);
    }
    // retrieves a book
    public Travels findTravel(Long id) {
        Optional<Travels> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    public Travels updateTravel(Travels travel) {
        return travelRepository.save(travel);
    }
    public void deleteTravel(Travels travel) {
		travelRepository.delete(travel);
	}
}
