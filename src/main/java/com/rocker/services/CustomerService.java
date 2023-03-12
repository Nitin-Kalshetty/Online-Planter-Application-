package com.rocker.services;

import java.util.List;

import com.rocker.exceptions.CustomerException;
import com.rocker.model.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer customer);
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException;
	public List<Customer> getAllCustomerDetails() throws CustomerException;
}
 

