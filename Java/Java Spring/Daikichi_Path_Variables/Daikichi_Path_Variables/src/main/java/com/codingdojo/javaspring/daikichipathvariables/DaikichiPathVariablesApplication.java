package com.codingdojo.javaspring.daikichipathvariables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/daikichi")
@SpringBootApplication
public class DaikichiPathVariablesApplication {

	public static void main(String[] args) {
        SpringApplication.run(DaikichiPathVariablesApplication.class, args);
	}
	
	@RequestMapping("/travel/{searchQuery}")
	public String travel(@PathVariable("searchQuery") String searchQuery) {
		return "Congratulations! You will soon travel to " + searchQuery;
	}
	
	@RequestMapping("/lotto/{num}")
	public String travel(@PathVariable("num") int num) {
		if(num % 2 == 0 ) {
			return "You will take a grand journey in the near future, but be wary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}
	}

}
