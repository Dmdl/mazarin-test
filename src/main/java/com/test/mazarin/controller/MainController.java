package com.test.mazarin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.mazarin.service.CustomerService;

@Controller
public class MainController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/index")
	public String users(Model model) {
		model.addAttribute("users", customerService.findAll());
		return "index";
	}
}
