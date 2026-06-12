package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    // ------------------ INSERT ------------------
    @Override
    public String insertCustomer(Customer customer) {
        return customerDao.insertCustomer(customer);
    }

    // ------------------ GET ALL ------------------
    @Override
    public List<Customer> getCustomersList() {
        return customerDao.getCustomersList();
    }

    // ------------------ GET BY ID ------------------
    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    // ------------------ UPDATE ------------------
    @Override
    public String customerUpdate(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    // ------------------ DELETE ------------------
    @Override
    public String customerDeleteById(int id) {
        return customerDao.deleteCustomerById(id);
    }

    // ------------------ INSERT MULTIPLE ------------------
    @Override
    public String insertMultipleCustomer(List<Customer> customers) {
        return customerDao.insertMultipleCustomers(customers);
    }

    // ------------------ SEARCH ------------------

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerDao.getCustomersByFirstName(firstName);
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName) {
        return customerDao.getCustomersByLastName(lastName);
    }

    @Override
    public List<Customer> getCustomerByAge(int age) {
        return customerDao.getCustomersByAge(age);
    }

    @Override
    public List<Customer> getCustomerByAgeLessThan(int age) {
        return customerDao.getCustomersByLessThanAge(age);
    }

    // ------------------ PARTIAL UPDATE ------------------

    @Override
    public String updateFirstName(int id, String firstName) {
        return customerDao.updateFirstName(id, firstName);
    }

    @Override
    public String updateLastName(int id, String lastName) {
        return customerDao.updateLastName(id, lastName);
    }

    @Override
    public String updateEmailId(int id, String emailId) {
        return customerDao.updateEmailId(id, emailId);
    }

    @Override
    public String updateMobileNumber(int id, String mobileNumber) {
        return customerDao.updateMobileNumber(id, mobileNumber);
    }

    @Override
    public String updateAge(int id, int age) {
        return customerDao.updateAge(id, age);
    }

    // ------------------ GET ONLY FIRST NAMES ------------------
    @Override
    public List<String> getCustomerFirstName() {
        return customerDao.getCustomersFirstName();
    }
}
