package com.rocker.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocker.exceptions.CustomerException;
import com.rocker.model.Customer;
import com.rocker.repository.CustomerRepository;
import com.rocker.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer registerCustomer(Customer customer) {

		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {

		return customerRepo.findByEmail(email).orElseThrow(() -> new CustomerException("Customer Not Found With Email : "+email));
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		List<Customer> list = customerRepo.findAll();
		if(list.isEmpty()) {
			throw new CustomerException("No Customer found");
		}
			return list;
		
	}

}
