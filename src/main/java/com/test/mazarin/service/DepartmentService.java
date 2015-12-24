package com.test.mazarin.service;

import java.util.List;

import com.test.mazarin.entity.Department;

public interface DepartmentService {

	public List<Department> getAll();
	
	public Department getDepartment(int id);
}
