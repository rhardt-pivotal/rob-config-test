package com.example.robconfigtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class RobConfigTestApplication {

	@Value("${rob.test:From_Local}")
	private String configString;

	public static void main(String[] args) {
		SpringApplication.run(RobConfigTestApplication.class, args);
	}


	@RequestMapping("/")
	public ResponseEntity<String> index(){
		return ResponseEntity.ok(configString);
	}

}
