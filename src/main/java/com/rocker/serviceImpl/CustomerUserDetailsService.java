package com.rocker.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rocker.model.Customer;
import com.rocker.repository.CustomerRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> opt = customerRepo.findByEmail(username);
		if(opt.isEmpty()) {
			throw new BadCredentialsException("User Details not found with this email : "+username);
		}
		Customer customer = opt.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(customer.getRole());
		authorities.add(sga);
		return new User(customer.getEmail(),customer.getPassword(),authorities);
//		return new CustomerUserDetails(customer);
	}

}
