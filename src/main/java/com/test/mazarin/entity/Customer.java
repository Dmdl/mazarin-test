package com.test.mazarin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	@Size(min = 1, message = "Invalid Customer Name")
	@Column(name="customer_name")
	private String customerName;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department customerDepartment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Department getCustomerDepartment() {
		return customerDepartment;
	}

	public void setCustomerDepartment(Department customerDepartment) {
		this.customerDepartment = customerDepartment;
	}

}
