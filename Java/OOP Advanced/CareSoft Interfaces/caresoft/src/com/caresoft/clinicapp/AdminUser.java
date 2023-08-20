package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		securityIncidents = new ArrayList<>();
	}
    @Override
    public boolean assignPin(int pin) {
    	if(pin>99999 && pin<1000000) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    @Override
    public boolean accessAuthorized(Integer id) {
    	if(this.id == id) {
    		return true;
    	}
    	authIncident();
    	return false;
    }
    
    @Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
}

// I seriously couldn't figure this out, I am confused where I got this wrong
// Would you be able to explain this to me? Thank you!
