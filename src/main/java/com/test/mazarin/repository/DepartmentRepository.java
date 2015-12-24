package com.test.mazarin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.mazarin.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
