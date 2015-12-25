package com.test.mazarin.service;

import java.util.List;

import com.test.mazarin.entity.Department;
/**
 * 
 * @author lakmal
 * Department related operations
 */
public interface DepartmentService {

	/**
	 * Get all the departments
	 * @return All the departments
	 */
	public List<Department> getAll();
	
	/**
	 * Get the departmant that match with department id
	 * @param id department id
	 * @return return matching department
	 */
	public Department getDepartment(int id);
}
