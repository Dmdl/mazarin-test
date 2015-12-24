package com.test.mazarin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.mazarin.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
