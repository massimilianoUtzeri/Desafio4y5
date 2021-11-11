package com.everis.spring.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.services.EverisCustomerManagementServiceI;

@RestController 
@RequestMapping("/customers")
public class EverisCustomerRestController {
	
	@Autowired
	EverisCustomerManagementServiceI customerService;
	
	
	
	@GetMapping(value="/{dni}")
	public EverisCustomer  getCustomerByDni(final @PathVariable String dni){
		EverisCustomer customer = customerService.searchByIdentityDocNumber(dni);
		return customer;
	}
	
	@GetMapping(value="/{nameAndSurname")
	public EverisCustomer getCustomerByNameAndSurname(final @PathVariable String name,final @PathVariable String surname1,final @PathVariable String surname2) {
		return customerService.searchByFullName(name, surname1, surname2);
	}
	
	@GetMapping(value="/{todos}")
	public List<EverisCustomer> getCustomers(){
		return customerService.searchAllCustomers();
	}
	
	@PostMapping()
	public List<EverisCustomer> addCustomer(@RequestBody EverisCustomer newCustomer) {
		customerService.insertNewCustomer(newCustomer);
		return customerService.searchAllCustomers();
	}
	
	

}
