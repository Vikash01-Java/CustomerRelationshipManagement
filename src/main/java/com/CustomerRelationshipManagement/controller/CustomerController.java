package com.CustomerRelationshipManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;


@RestController
@RequestMapping("api/customers")
public class CustomerController {
	
	private CustomerService costomerService;
	

	
	
public CustomerController(CustomerService costomerService) {
		super();
		this.costomerService = costomerService;
}


@PostMapping("/insert")  //ok
	public String insertCustomer(@RequestBody Customer customer) {
		String msg =costomerService.insertCustomer(customer);     
		return msg;
		
	}
	
@GetMapping   //ok
public List<Customer> getCustomersList(){
	List<Customer> list = costomerService.getCustomersList();
	return list;
	
}

@GetMapping("/{id}")  //ok
public Customer getCustomerById(@PathVariable int id){
	Customer customer = costomerService.getCustomerById(id);
	return customer;
	
}
@PutMapping    // ok
public String customerUpdate(@RequestBody Customer customer) {
	return costomerService.customerUpdate(customer);
}

@DeleteMapping("/{id}")  //ok
public String customerDeleteById(@PathVariable int id) {
	return costomerService.customerDeleteById(id);
	
}

@PostMapping    //ok
public String insertMultiplyCustomer(@RequestBody List<Customer> customers) {
	return costomerService.insertMultiplyCustomer(customers);
	
}

@GetMapping("/byfirstname/{firstName}")  //ok
public List<Customer> getCustomerByFirstName(@PathVariable String firstName){
	return costomerService.getCustomerByFirstName(firstName);
	
}

@GetMapping("/bylastname/{lastName}")  //ok
public List<Customer> getCustomerByLastName(@PathVariable String lastName){
	return costomerService.getCustomerByLastName(lastName);
	
}
	
@GetMapping("/bylessthanage/{age}")   //ok
public List<Customer> getCustomerByLessThanAge(@PathVariable  int age){
	return costomerService.getCustomerByLessThanAge(age);
	
}

@GetMapping("/byage/{age}")   //ok
public List<Customer> getCustomerByAge(@PathVariable int age){
	return costomerService.getCustomerAge(age);
	
}
@PutMapping("/fname/{id}")   //ok
public String updateFirstName(@PathVariable int id,@RequestBody Map<String, String> request ) {
	   String firstName = request.get("firstName");
	   return costomerService.updateFirstName(id, firstName);
	   
	   
}

@PutMapping("/lname/{id}")   //ok
public String updateLastName(@PathVariable int id,@RequestBody Map<String, String> request ) {
	   String lastName = request.get("lastName");
	   return costomerService.updateLastName(id, lastName);
	   
	   
}

@PutMapping("/email/{id}")  //ok
public String updateEmailId(@PathVariable int id , @RequestBody Map<String, String> request) {
	String emailId = request.get("emailId");
	return costomerService.updateEmailId(id, emailId);
}

@PutMapping("/mobile/{id}")  //ok
public String updateMobileNumber(@PathVariable int id , @RequestBody Map<String , String> request) {
	String mobileNumber = request.get("mobileNumber");
	return costomerService.updateMobileNumber(id, mobileNumber);
	
}


@PutMapping("/age/{id}")  //ok
public String updateAge(@PathVariable int id , @RequestBody Map<String , Integer> request) {
    Integer age = request.get("age");
    return costomerService.updateAge(id , age);
}

@GetMapping("/firstNames")
public List<String> getCustomerFirstName(){
	return costomerService.getCustomerFirstName();
	
}




}


