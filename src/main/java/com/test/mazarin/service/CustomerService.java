package com.test.mazarin.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mazarin.entity.Customer;
import com.test.mazarin.entity.Department;
import com.test.mazarin.repository.CustomerRepository;
import com.test.mazarin.repository.DepartmentRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	@PostConstruct
	public void test() {
		Customer customer = new Customer();
		customer.setCustomerName("test");
		Department dep = new Department();
		dep.setDepartmentName("Test dep");
		customer.setCustomerDepartment(dep);
		departmentRepository.save(dep);
		customerRepository.save(customer);
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
