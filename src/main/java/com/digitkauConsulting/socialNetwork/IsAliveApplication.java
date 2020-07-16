package com.digitkauConsulting.socialNetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IsAliveApplication {

	@Autowired
	StringRedisTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(IsAliveApplication.class, args);
	}

	@RequestMapping("/")
  	public String home() {
		template.opsForValue().increment("test");
		String keyValue = template.opsForValue().get("test");
		return "Hello Docker World" + keyValue;
  	}
}