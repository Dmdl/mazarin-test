package com.test.mazarin.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger LOG=LoggerFactory.getLogger(getClass());

	@RequestMapping("/index")
	public String customers(Model model) {
		try{
			//retrive all departments and customers and pass them to view
			model.addAttribute("users", customerService.findAll());
			model.addAttribute("departments", departmentService.getAll());
			return "index";
		}catch(Exception e){
			LOG.error("Error occured while redirecting to customer page "+e.getMessage());
			//redirect to error page
			return "error";
		}		
	}
	
	@ModelAttribute("customer")
	public Customer construct() {
		return new Customer();
	}
	
	@RequestMapping(value = "/index",method = RequestMethod.POST)
	public String doSaveCustomer(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "index"; //return if we got errors
		}
		try{
			Department selectedDepartment = departmentService.getDepartment(customer.getCustomerDepartment().getId());
			customer.setCustomerDepartment(selectedDepartment);
			customerService.save(customer);
			LOG.info("Customer saved successfully");
			return "redirect:/index.html?success=true";
		}catch(Exception e){
			LOG.error("Error while saving customer "+e.getMessage());
			return "error";
		}		
	}
	
	@RequestMapping("/index/edit/{id}")
	public String editCustomer(Model model, @PathVariable int id) {
		try{
			model.addAttribute("customer", customerService.findCustomer(id));
			model.addAttribute("departments", departmentService.getAll());
			LOG.info("Redirect to edit customer with customer id "+id);
			return "edit-customer"; //redirect to edit customer view
		}catch(Exception e){
			LOG.error("Error redirecting customer with id "+id+" to edit page "+e.getMessage());
			//redirect to error page
			return "error";
		}		
	}
	
	@RequestMapping(value = "/index/edit",method = RequestMethod.POST)
	public String doEditCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result) {		
		if (result.hasErrors()) {
			return "index";
		}
		try{
			Department newDepartment = departmentService.getDepartment(customer.getCustomerDepartment().getId());
			customer.setCustomerDepartment(newDepartment);
			customerService.updateCustomer(customer);
			LOG.info("Customer updated successfully "+customer.getId());
			return "redirect:/index.html"; //after successfull riderect to index view back
		}catch(Exception ex){
			LOG.error("Error editing customer "+ex.getMessage());
			//redirect to error page
			return "error";
		}		
	}
	
	@RequestMapping("/index/delete/{id}")
	public String deleteCustomer(Model model, @PathVariable int id) {
		try{
			customerService.deleteCustomer(id);
			LOG.info("Customer with id "+ id+" deleted successfully");
			return "redirect:/index.html";
		}catch(Exception e){
			LOG.error("Error while deleting customer with id "+id+" "+e.getMessage());
			//redirect to error page
			return "error";
		}		
	}
}
