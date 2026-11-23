package com.wipro.security.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@
@SpringBootApplication
public class SecurityControllerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SecurityControllerApplication.class, args);
	}

}
