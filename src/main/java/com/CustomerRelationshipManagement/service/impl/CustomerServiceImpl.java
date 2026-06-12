package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;


@Service

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
	
	
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


////insert
	@Override
	public String insertCustomer(Customer customer) {
		
		String msg = customerDao.insertCustomer(customer);
		return msg;
	}
	
	@Override
	public String insertMultiplyCustomer(List<Customer> customers) {
		
		return customerDao.insertMultipleCustomers(customers);
	}
////update
	@Override
	public String customerUpdate(Customer customer) {
		return  customerDao.updateCustomer(customer);	
	}
	
	@Override
	public String updateFirstName(Integer id, String firstName) {
		return customerDao.updateFirstName(id, firstName);
	}

	@Override
	public String updateLastName(Integer id, String lastName) {
		return customerDao.updateLatName(id, lastName);
	}

	@Override
	public String updateEmailId(Integer id, String emailId) {
		return customerDao.updateEmailId(id, emailId);
	}

	@Override
	public String updateMobileNumber(Integer id, String MobileNumber) {
		
		return customerDao.updateMobileNumber(id, MobileNumber);
	}
	
	@Override
	public String updateAge(Integer id, Integer age) {
		return customerDao.updateAge(id, age);
	}
	
	//delete
	@Override
	public String customerDeleteById(Integer id) {
		return  customerDao.deleteCustomerById(id);
	}

	////get
	@Override
	public List<Customer> getCustomersList() {
		List<Customer> list = customerDao.getCustomersList();
		return list;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Customer customer = customerDao.getCustomerById(id);
		return customer;
	}

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
		return customerDao.getCustomersByFirstName(firstName);
	}
		
	@Override
	public List<Customer> getCustomerByLastName(String lastName) {
		return customerDao.getCustomersByLastName(lastName);
	}

	@Override
	public List<Customer> getCustomerByLessThanAge(Integer age) {
		
		return customerDao.getCustomersByLessThanAge(age);
	}

	@Override
	public List<Customer> getCustomerAge(Integer age) {
		return customerDao.getCustomersByAge(age);
	}


<<<<<<< Updated upstream
=======
    public String updateLastName(int id, String lastName) {
        return customerDao.updateLatName(id, lastName);
    }
>>>>>>> Stashed changes

	@Override
	public List<String> getCustomerFirstName() {
		return customerDao.getCustomersFirstName();
	}




	
	
	
	

}
