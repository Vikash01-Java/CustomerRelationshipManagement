package com.CustomerRelationshipManagement.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.entity.Customer;

@Repository
public class CustomerDao {

    private HibernateTemplate hibernateTemplate;

    public CustomerDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    // INSERT
    public String insertCustomer(Customer customer) {
        hibernateTemplate.save(customer);
        return "Customer inserted successfully";
    }

    // GET ALL
    public List<Customer> getCustomersList() {
        return hibernateTemplate.loadAll(Customer.class);
    }

    // GET BY ID
    public Customer getCustomerById(int id) {
        return hibernateTemplate.get(Customer.class, id);
    }

    // UPDATE
    public String updateCustomer(Customer customer) {
        hibernateTemplate.update(customer);
        return "Customer updated successfully";
    }

    // DELETE
    public String deleteCustomerById(int id) {
        Customer customer = hibernateTemplate.get(Customer.class, id);
        if (customer != null) {
            hibernateTemplate.delete(customer);
            return "Customer deleted successfully";
        }
        return "Customer not found";
    }

    // BULK INSERT
    public String insertMultipleCustomers(List<Customer> customers) {
        for (Customer c : customers) {
            hibernateTemplate.save(c);
        }
        return "Customers inserted successfully";
    }

    // QUERIES
    public List<Customer> getCustomersByFirstName(String firstName) {
        return (List<Customer>) hibernateTemplate.find(
                "from Customer c where c.firstName = ?", firstName);
    }

    public List<Customer> getCustomersByLastName(String lastName) {
        return (List<Customer>) hibernateTemplate.find(
                "from Customer c where c.lastName = ?", lastName);
    }

    public List<Customer> getCustomersByLessThanAge(int age) {
        return (List<Customer>) hibernateTemplate.find(
                "from Customer c where c.age < ?", age);
    }

    public List<Customer> getCustomersByAge(int age) {
        return (List<Customer>) hibernateTemplate.find(
                "from Customer c where c.age = ?", age);
    }

    // UPDATE FIELDS
    public String updateFirstName(int id, String firstName) {
        Customer customer = hibernateTemplate.get(Customer.class, id);
        if (customer != null) {
            customer.setFirstName(firstName);
            hibernateTemplate.update(customer);
            return "FirstName updated";
        }
        return "Customer not found";
    }

    public String updateLastName(int id, String lastName) {
        Customer customer = hibernateTemplate.get(Customer.class, id);
        if (customer != null) {
            customer.setLastName(lastName);
            hibernateTemplate.update(customer);
            return "LastName updated";
        }
        return "Customer not found";
    }

    public String updateEmailId(int id, String email) {
        Customer customer = hibernateTemplate.get(Customer.class, id);
        if (customer != null) {
            customer.setEmail(email);
            hibernateTemplate.update(customer);
            return "Email updated";
        }
        return "Customer not found";
    }

    public String updateMobileNumber(int id, String mobile) {
        Customer customer = hibernateTemplate.get(Customer.class, id);
        if (customer != null) {
            customer.setMobileNumber(mobile);
            hibernateTemplate.update(customer);
            return "Mobile updated";
        }
        return "Customer not found";
    }

    public String updateAge(int id, int age) {
        Customer customer = hibernateTemplate.get(Customer.class, id);
        if (customer != null) {
            customer.setAge(age);
            hibernateTemplate.update(customer);
            return "Age updated";
        }
        return "Customer not found";
    }

    // SELECT ONLY FIRST NAME
    public List<String> getCustomersFirstName() {
        return (List<String>) hibernateTemplate.find(
                "select c.firstName from Customer c");
    }
}
