package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public String insertCustomer(Customer customer) {
        return customerDao.insertCustomer(customer);
    }

    public List<Customer> getCustomersList() {
        return customerDao.getCustomersList();
    }

    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    public String customerUpdate(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    public String customerDeleteById(int id) {
        return customerDao.deleteCustomerById(id);
    }

    public String insertMultiplyCustomer(List<Customer> customers) {
        return customerDao.insertMultipleCustomers(customers);
    }

    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerDao.getCustomersByFirstName(firstName);
    }

    public List<Customer> getCustomerByLastName(String lastName) {
        return customerDao.getCustomersByLastName(lastName);
    }

    public List<Customer> getCustomerByLessThanAge(int age) {
        return customerDao.getCustomersByLessThanAge(age);
    }

    public List<Customer> getCustomerAge(int age) {
        return customerDao.getCustomersByAge(age);
    }

    public String updateFirstName(int id, String firstName) {
        return customerDao.updateFirstName(id, firstName);
    }

    public String updateLastName(int id, String lastName) {
        return customerDao.updateLastName(id, lastName);
    }

    public String updateEmailId(int id, String emailId) {
        return customerDao.updateEmailId(id, emailId);
    }

    public String updateMobileNumber(int id, String mobileNumber) {
        return customerDao.updateMobileNumber(id, mobileNumber);
    }

    public String updateAge(int id, int age) {
        return customerDao.updateAge(id, age);
    }

    public List<String> getCustomerFirstName() {
        return customerDao.getCustomersFirstName();
    }
}
