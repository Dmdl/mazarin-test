package com.test.mazarin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mazarin.entity.Customer;
import com.test.mazarin.repository.CustomerRepository;
import com.test.mazarin.repository.DepartmentRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customer findCustomer(int id) {
		return customerRepository.findOne(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer fethCustomer = customerRepository.findOne(customer.getId());
		fethCustomer.setCustomerName(customer.getCustomerName());
		fethCustomer.setCustomerDepartment(customer.getCustomerDepartment());
	}
}
