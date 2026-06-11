package com.CustomerRelationshipManagement.service;

import java.util.List;

import com.CustomerRelationshipManagement.entity.Customer;

public interface CustomerService {
	
//	insert
	public String insertCustomer(Customer customer);
	
	public String insertMultiplyCustomer(List<Customer> customers);
	
//	update
	public String customerUpdate(Customer customer);
	
    public String updateFirstName(Integer id, String firstName);
	
	public String updateLastName(Integer id, String lastName);

	public String updateEmailId(Integer id, String emailId);
	
	public String updateMobileNumber(Integer id, String mobileNumber);
	
	public String updateAge(Integer id, Integer age);
	
	
//  delete	
	public String customerDeleteById(Integer id);
	
	
//  get	
	public  List<Customer> getCustomersList();
	
	public Customer getCustomerById(Integer id);
	
	public List<Customer> getCustomerByFirstName(String firstName);
	
	public List<Customer> getCustomerByLastName(String lastName);

	public List<Customer> getCustomerByLessThanAge(Integer age);
	
	public List<Customer> getCustomerAge(Integer age);
	
	
	
	public List<String> getCustomerFirstName();
	
	





}
