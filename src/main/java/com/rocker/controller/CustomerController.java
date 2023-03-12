package com.rocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rocker.model.Customer;
import com.rocker.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		Customer registeredCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(registeredCustomer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customer/{email}")
	public ResponseEntity<Customer> getCustomerHandler(@PathVariable("email") String email){
		return new ResponseEntity<Customer>(customerService.getCustomerDetailsByEmail(email),HttpStatus.OK);
	}
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler(){
		
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomerDetails(),HttpStatus.OK);
	}
}
