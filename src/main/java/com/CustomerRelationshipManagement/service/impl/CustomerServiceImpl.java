package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

import jakarta.transaction.Transactional;

@Service

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
	
	
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}



	@Override
	public String insertCustomer(Customer customer) {
		
		String msg = customerDao.insertCustomer(customer);
		return msg;
	}



	@Override
	public List<Customer> getCustomersList() {
		List<Customer> list = customerDao.getCustomersList();
		return list;
	}



	@Override
	public Customer getCustomerById(int id) {
		Customer customer = customerDao.getCustomerById(id);
		return customer;
	}



	@Override
	public String customerUpdate(Customer customer) {
		return  customerDao.updateCustomer(customer);
	
	}



	@Override
	public String customerDeleteById(int id) {
		return  customerDao.deleteCustomerById(id);
	}



	@Override
	public String insertMultiplyCustomer(List<Customer> customers) {
		
		return customerDao.insertMultipleCustomers(customers);
	}



	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
		return customerDao.getCustomerByFirstName(firstName);
	}
	
	
	@Override
	public List<Customer> getCustomerByLastName(String lastName) {
		return customerDao.getCustomerByLastName(lastName);
	}



	@Override
	public List<Customer> getCustomerByLessThanAge(int age) {
		
		return customerDao.getCustomerByLessThanAge(age);
	}



	@Override
	public List<Customer> getCustomerAge(int age) {
		return customerDao.getCustomerByAge(age);
	}



	@Override
	public String updateFirstName(int id, String firstName) {
		return customerDao.updateFirstName(id, firstName);
	}



	@Override
	public String updateLastName(int id, String lastName) {
		return customerDao.updateLatName(id, lastName);
	}



	@Override
	public String updateEmailId(int id, String emailId) {
		return customerDao.updateEmailId(id, emailId);
	}



	@Override
	public String updateMobileNumber(int id, String emailId) {
		
		return customerDao.updateMobileNumber(id, emailId);
	}



	@Override
	public String updateAge(int id, int age) {
		return customerDao.updateAge(id, age);
	}



	@Override
	public List<String> getCustomerFirstName() {
		return customerDao.getCustomersFirstName();
	}




	
	
	
	

}
