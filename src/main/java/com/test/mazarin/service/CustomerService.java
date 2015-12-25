package com.test.mazarin.service;

import java.util.List;

import com.test.mazarin.entity.Customer;

/**
 * @author lakmal
 * 
 * Customer related operations
 */
public interface CustomerService {

	/**
	 * Returns all the customers currently in database
	 * 
	 * @return all the customers
	 */
	public List<Customer> findAll();
	
	/**
	 * Save the Customer object
	 * 
	 * @param customer Customer object need to persist
	 */
	public void save(Customer customer);
	
	/**
	 * find the customer for matching customer id if not found return null.
	 * 
	 * @param id Customer id
	 * @return return the matching Customer object
	 */
	public Customer findCustomer(int id);
	
	/**
	 * Update Customer object
	 * 
	 * @param customer Customer object to update
	 */
	public void updateCustomer(Customer customer);
	
	/**
	 * Delete matching customer object
	 * 
	 * @param id Customer id
	 */
	public void deleteCustomer(int id);
}
