package com.digitkauConsulting.socialNetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IsAliveApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsAliveApplication.class, args);
	}

	@RequestMapping("/")
  	public String home() {
    	return "Hello Docker World";
  	}
}