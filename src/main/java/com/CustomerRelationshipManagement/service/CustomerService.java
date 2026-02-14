package com.CustomerRelationshipManagement.service;

import java.util.List;

import com.CustomerRelationshipManagement.entity.Customer;

public interface CustomerService {
	
	public String insertCustomer(Customer customer);
	
	public  List<Customer> getCustomersList();
	
	public Customer getCustomerById(int id);
	
	public String customerUpdate(Customer customer);
	
	public String customerDeleteById(int id);
	
	public String insertMultiplyCustomer(List<Customer> customers);
	
	public List<Customer> getCustomerByFirstName(String firstName);
	
	public List<Customer> getCustomerByLastName(String lastName);

	public List<Customer> getCustomerByLessThanAge(int age);
	
	public List<Customer> getCustomerAge(int age);
	
	public String updateFirstName(int id, String firstName);
	
	public String updateLastName(int id, String lastName);

	public String updateEmailId(int id, String emailId);
	
	public String updateMobileNumber(int id, String emailId);
	
	public String updateAge(int id, int age);
	
	public List<String> getCustomerFirstName();
	
	





}
