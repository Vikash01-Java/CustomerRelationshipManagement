package com.CustomerRelationshipManagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.entity. Customer;

@Repository
public class CustomerDao {

    private JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper
    class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("first_name"));
            c.setLastName(rs.getString("last_name"));
            c.setEmail(rs.getString("email"));
            c.setMobileNumber(rs.getString("mobile_number"));
            c.setAge(rs.getInt("age"));
            return c;
        }
    }

    // INSERT
    public String insertCustomer(Customer customer) {
        String sql = "INSERT INTO customer (first_name, last_name, email, mobile_number, age) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getMobileNumber(),
                customer.getAge());
        return "Customer inserted successfully";
    }

    // GET ALL
    public List<Customer> getCustomersList() {
        String sql = "SELECT * FROM customer";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    // GET BY ID
    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), id);
    }

    // UPDATE
    public String updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET first_name=?, last_name=?, email=?, mobile_number=?, age=? WHERE id=?";
        jdbcTemplate.update(sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getMobileNumber(),
                customer.getAge(),
                customer.getId());
        return "Customer updated successfully";
    }

    // DELETE
    public String deleteCustomerById(int id) {
        String sql = "DELETE FROM customer WHERE id=?";
        jdbcTemplate.update(sql, id);
        return "Customer deleted successfully";
    }

    // BULK INSERT
    public String insertMultipleCustomers(List<Customer> customers) {
        String sql = "INSERT INTO customer (first_name, last_name, email, mobile_number, age) VALUES (?, ?, ?, ?, ?)";
        for (Customer c : customers) {
            jdbcTemplate.update(sql,
                    c.getFirstName(),
                    c.getLastName(),
                    c.getEmail(),
                    c.getMobileNumber(),
                    c.getAge());
        }
        return "Customers inserted successfully";
    }

    // SEARCH
    public List<Customer> getCustomersByFirstName(String firstName) {
        String sql = "SELECT * FROM customer WHERE first_name = ?";
        return jdbcTemplate.query(sql, new CustomerRowMapper(), firstName);
    }

    public List<Customer> getCustomersByLastName(String lastName) {
        String sql = "SELECT * FROM customer WHERE last_name = ?";
        return jdbcTemplate.query(sql, new CustomerRowMapper(), lastName);
    }

    public List<Customer> getCustomersByLessThanAge(int age) {
        String sql = "SELECT * FROM customer WHERE age < ?";
        return jdbcTemplate.query(sql, new CustomerRowMapper(), age);
    }

    public List<Customer> getCustomersByAge(int age) {
        String sql = "SELECT * FROM customer WHERE age = ?";
        return jdbcTemplate.query(sql, new CustomerRowMapper(), age);
    }

    // UPDATE FIELDS
    public String updateFirstName(int id, String firstName) {
        String sql = "UPDATE customer SET first_name=? WHERE id=?";
        jdbcTemplate.update(sql, firstName, id);
        return "FirstName updated";
    }

    public String updateLastName(int id, String lastName) {
        String sql = "UPDATE customer SET last_name=? WHERE id=?";
        jdbcTemplate.update(sql, lastName, id);
        return "LastName updated";
    }

    public String updateEmailId(int id, String emailId) {
        String sql = "UPDATE customer SET email=? WHERE id=?";
        jdbcTemplate.update(sql, emailId, id);
        return "Email updated";
    }

    public String updateMobileNumber(int id, String mobileNumber) {
        String sql = "UPDATE customer SET mobile_number=? WHERE id=?";
        jdbcTemplate.update(sql, mobileNumber, id);
        return "Mobile updated";
    }

    public String updateAge(int id, int age) {
        String sql = "UPDATE customer SET age=? WHERE id=?";
        jdbcTemplate.update(sql, age, id);
        return "Age updated";
    }

    // GET ONLY FIRST NAMES
    public List<String> getCustomersFirstName() {
        String sql = "SELECT first_name FROM customer";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
