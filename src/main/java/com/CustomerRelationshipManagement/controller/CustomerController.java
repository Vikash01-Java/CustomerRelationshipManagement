package com.CustomerRelationshipManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // ------------------ INSERT SINGLE ------------------
    @PostMapping("/insert")
    public String insertCustomer(@RequestBody Customer customer) {
        return service.insertCustomer(customer);
    }

    // ------------------ INSERT MULTIPLE ------------------
    @PostMapping("/bulk")
    public String insertMultipleCustomers(@RequestBody List<Customer> customers) {
        return service.insertMultipleCustomer(customers);
    }

    // ------------------ GET ALL ------------------
    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomersList();
    }

    // ------------------ GET BY ID ------------------
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    // ------------------ UPDATE FULL ------------------
    @PutMapping
    public String updateCustomer(@RequestBody Customer customer) {
        return service.customerUpdate(customer);
    }

    // ------------------ DELETE ------------------
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.customerDeleteById(id);
    }

    // ------------------ SEARCH APIs ------------------

    @GetMapping("/byfirstname/{firstName}")
    public List<Customer> getCustomerByFirstName(@PathVariable String firstName) {
        return service.getCustomerByFirstName(firstName);
    }

    @GetMapping("/bylastname/{lastName}")
    public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
        return service.getCustomerByLastName(lastName);
    }

    @GetMapping("/byage/{age}")
    public List<Customer> getCustomerByAge(@PathVariable int age) {
        return service.getCustomerByAge(age);
    }

    @GetMapping("/bylessthanage/{age}")
    public List<Customer> getCustomerByLessThanAge(@PathVariable int age) {
        return service.getCustomerByAgeLessThan(age);
    }

    // ------------------ PARTIAL UPDATE ------------------

    @PutMapping("/fname/{id}")
    public String updateFirstName(@PathVariable int id,
                                 @RequestBody Map<String, String> request) {
        String firstName = request.get("firstName");
        return service.updateFirstName(id, firstName);
    }

    @PutMapping("/lname/{id}")
    public String updateLastName(@PathVariable int id,
                                @RequestBody Map<String, String> request) {
        String lastName = request.get("lastName");
        return service.updateLastName(id, lastName);
    }

    @PutMapping("/email/{id}")
    public String updateEmail(@PathVariable int id,
                             @RequestBody Map<String, String> request) {
        String emailId = request.get("emailId");
        return service.updateEmailId(id, emailId);
    }

    @PutMapping("/mobile/{id}")
    public String updateMobile(@PathVariable int id,
                              @RequestBody Map<String, String> request) {
        String mobileNumber = request.get("mobileNumber");
        return service.updateMobileNumber(id, mobileNumber);
    }

    @PutMapping("/age/{id}")
    public String updateAge(@PathVariable int id,
                           @RequestBody Map<String, Integer> request) {
        Integer age = request.get("age");
        return service.updateAge(id, age);
    }

    // ------------------ GET ONLY FIRST NAMES ------------------
    @GetMapping("/firstNames")
    public List<String> getCustomerFirstNames() {
        return service.getCustomerFirstName();
    }
}
