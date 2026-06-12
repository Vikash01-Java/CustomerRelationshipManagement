package com.CustomerRelationshipManagement.service;

import java.util.List;
import com.CustomerRelationshipManagement.entity.Customer;

public interface CustomerService {

    String insertCustomer(Customer customer);

    List<Customer> getCustomersList();

    Customer getCustomerById(int id);

    String customerUpdate(Customer customer);

    String customerDeleteById(int id);

    String insertMultipleCustomer(List<Customer> customers);

    List<Customer> getCustomerByFirstName(String firstName);

    List<Customer> getCustomerByLastName(String lastName);

    List<Customer> getCustomerByAge(int age);

    List<Customer> getCustomerByAgeLessThan(int age);

    String updateFirstName(int id, String firstName);

    String updateLastName(int id, String lastName);

    String updateEmailId(int id, String emailId);

    String updateMobileNumber(int id, String mobileNumber);

    String updateAge(int id, int age);

    List<String> getCustomerFirstName();
}
