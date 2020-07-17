package com.digitkauConsulting.socialNetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.AliveResponsePojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@RestController
public class IsAliveApplication {

	@Autowired
	StringRedisTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(IsAliveApplication.class, args);
	}

	@RequestMapping
	public String index(){
		return "Welcome to activity registry aplication";
	}

	@PostMapping("/alive")
	@ResponseBody
  	public ResponseEntity<AliveResponsePojo> alive(@RequestParam(name="userId") Integer userId) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		template.opsForValue().set(userId.toString(), currentDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		AliveResponsePojo returnValue = new AliveResponsePojo();
		returnValue.setUserId(userId);
		returnValue.setLastAccess(currentDateTime);

		return new ResponseEntity(returnValue, HttpStatus.OK);
	}
}