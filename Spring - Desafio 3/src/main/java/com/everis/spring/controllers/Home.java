package com.everis.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.repository.EverisCustomerRepository;
import com.everis.spring.services.EverisCustomerManagementServiceI;

@Controller
public class Home {
	
	@Autowired
	EverisCustomerRepository everisCustomerRepository;
	
	
	
	@Autowired
	private EverisCustomerManagementServiceI customerService;
	
	public static String HOME_VIEW = "home";
	
	public static String CUSTOMER_AREA = "customerList";
	public static String ADD_CUSTOMER_VIEW = "addCustomer";
	public static String ADD_CUSTOMER_INSERT = "addCustomerInsert";
	
	
	@GetMapping("/homePage")
	public String homePage() { 
		return HOME_VIEW;
	}
	
	@GetMapping("/customerList")
	public String customerList(Model model) {
		List<EverisCustomer> customerList = customerService.searchAllCustomers();
		model.addAttribute("customerList",customerList);
		return CUSTOMER_AREA;
	}
	
	@GetMapping("/addCustomer")
	public String addCustomer() {
		
		return ADD_CUSTOMER_VIEW;
	}
	
	@PostMapping("/addCustomerInsert")
	public String addCustomer(@RequestBody EverisCustomer newCustomer) {
	
		customerService.insertNewCustomer(newCustomer);
	
		return ADD_CUSTOMER_INSERT;
	}
	

}
