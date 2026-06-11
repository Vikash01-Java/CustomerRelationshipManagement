package com.CustomerRelationshipManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/insert")
    public String insertCustomer(@RequestBody Customer customer) {
        return customerService.insertCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomersList() {
        return customerService.getCustomersList();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping
    public String updateCustomer(@RequestBody Customer customer) {
        return customerService.customerUpdate(customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return customerService.customerDeleteById(id);
    }

    @PostMapping
    public String insertMultiple(@RequestBody List<Customer> customers) {
        return customerService.insertMultiplyCustomer(customers);
    }

    @GetMapping("/byfirstname/{name}")
    public List<Customer> getByFirstName(@PathVariable String name) {
        return customerService.getCustomerByFirstName(name);
    }

    @PutMapping("/fname/{id}")
    public String updateFirstName(@PathVariable int id, @RequestBody Map<String, String> req) {
        return customerService.updateFirstName(id, req.get("firstName"));
    }
}
