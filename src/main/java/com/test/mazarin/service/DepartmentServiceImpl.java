package com.test.mazarin.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mazarin.entity.Department;
import com.test.mazarin.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostConstruct
	public void intit(){
		List<Department> departmentList = this.getAll();
		if(null== departmentList || departmentList.size()==0){
			List<Department> departments = new ArrayList<>(0);
			Department dep1 = new Department();
			dep1.setDepartmentName("Promotions");
			departments.add(dep1);
			Department dep2 = new Department();
			dep2.setDepartmentName("Administration");
			departments.add(dep2);
			Department dep3 = new Department();
			dep3.setDepartmentName("Engineering");
			departments.add(dep3);
			Department dep4 = new Department();
			dep4.setDepartmentName("Sales");
			departments.add(dep4);
			Department dep5 = new Department();
			dep5.setDepartmentName("Transport");
			departments.add(dep5);
			departmentRepository.save(departments);
		}		
	}
	
	public List<Department> getAll(){
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartment(int id) {
		return departmentRepository.findOne(id);
	}
}
