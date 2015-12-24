package com.test.mazarin.service;

import java.util.List;

import com.test.mazarin.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public void save(Customer customer);
	
	public Customer findCustomer(int id);
	
	public void updateCustomer(Customer customer);
}
