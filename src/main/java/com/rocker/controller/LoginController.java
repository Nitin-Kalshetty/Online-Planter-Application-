package com.rocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocker.model.Customer;
import com.rocker.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
		Customer customer = customerRepo.findByEmail(auth.getUsername()).orElseThrow(() -> new BadCredentialsException("Wrong Credentials"));
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}
}
