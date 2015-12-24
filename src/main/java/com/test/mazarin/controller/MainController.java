package com.test.mazarin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mazarin.entity.Customer;
import com.test.mazarin.entity.Department;
import com.test.mazarin.service.CustomerService;
import com.test.mazarin.service.DepartmentService;

@Controller
public class MainController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/index")
	public String customers(Model model) {
		model.addAttribute("users", customerService.findAll());
		model.addAttribute("departments", departmentService.getAll());
		return "index";
	}
	
	@ModelAttribute("customer")
	public Customer construct() {
		return new Customer();
	}
	
	@RequestMapping(value = "/index",method = RequestMethod.POST)
	public String doSaveCustomer(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}
		Department selectedDepartment = departmentService.getDepartment(customer.getCustomerDepartment().getId());
		customer.setCustomerDepartment(selectedDepartment);
		customerService.save(customer);
		return "redirect:/index.html?success=true";
	}
	
	@RequestMapping("/index/edit/{id}")
	public String editCustomer(Model model, @PathVariable int id) {
		model.addAttribute("customer", customerService.findCustomer(id));
		model.addAttribute("departments", departmentService.getAll());
		return "edit-customer";
	}
	
	@RequestMapping(value = "/index/edit",method = RequestMethod.POST)
	public String doEditCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result) {
		System.out.println("in edit method "+customer.getId()+" dep "+customer.getCustomerDepartment().getId()+" name "+customer.getCustomerName());
		if (result.hasErrors()) {
			return "index";
		}
		try{
			Department newDepartment = departmentService.getDepartment(customer.getCustomerDepartment().getId());
			customer.setCustomerDepartment(newDepartment);
			customerService.updateCustomer(customer);
			return "redirect:/index.html";
		}catch(Exception ex){
			ex.printStackTrace();
			return "error";
		}		
	}
}
