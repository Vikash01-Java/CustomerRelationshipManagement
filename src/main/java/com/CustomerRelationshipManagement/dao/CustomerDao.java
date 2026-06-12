 package com.CustomerRelationshipManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.entity.Customer;

@Repository
public class CustomerDao {
	
	SessionFactory sf;

//<<<<<<< Updated upstream
	public CustomerDao(SessionFactory sf) {
		this.sf = sf;
	}
	//insert
	public String insertCustomer(Customer customer) {
		
		Session session =sf.openSession();
		// insert , update , delete  - u need of transaction
		Transaction tr =session.beginTransaction();
		session.persist(customer); //its saved data in db
	    tr.commit();   //now u have to close the transaction 
	    session.close();
	    
	    return "Customer insert Successfully";
	}
	public String insertMultipleCustomers(List<Customer> customers) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();  
		for(Customer customer:customers) {
		session.persist(customer); 
		}
	    tr.commit();  
	    session.close();
	    
	    return "Customers inserted Successfully";
	}
	//update 
	public String updateCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.merge(customer);      
		tr.commit();
		session.close(); 
		return "Customer updated Successfully";	
	}
		public String updateFirstName(Integer id,String firstName) {
		Session session =sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setFirstName(firstName);
		tr.commit();
		session.close();
		return "updated susscessfully";
	}
		public String updateLatName(Integer id , String lastName) {
		Session  session =sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setLastName(lastName);
		tr.commit();
		session.close();
		return "updated lastName susscessfully";
	}
		public String updateEmailId(Integer id , String emailId) {
		Session  session =sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setEmail(emailId);
		tr.commit();
		session.close();
		return "updated emailId susscessfully";		
	}
	public String updateMobileNumber(Integer id , String mobileNumber) {
		Session  session =sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setMobileNumber(mobileNumber);
		tr.commit();
		session.close();
		return "updated mobileNumber susscessfully";		
	}
	public String updateAge(Integer id , Integer age ) {
		Session  session =sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setAge(age);
		tr.commit(); 
		session.close();
		return "updated age susscessfully";
	}
	 
	//delete
	public String deleteCustomerById(Integer id) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction(); 
		 Customer customer = session.get(Customer.class, id);

	        if (customer != null) {
	            session.remove(customer);   // Hibernate 6 recommended
	            tr.commit();
	            session.close();
	            return "Customer deleted Successfully";
	        } else {
	            return "Customer not found";
	        }
	        
	
	}
	//get
	public List<Customer> getCustomersList() {
		Session session = sf.openSession();
	
		return session.createQuery("from Customer", Customer.class).list();
           
	}
	
		public Customer getCustomerById(int id) {
		Session session =sf.openSession();
		Customer customer = session.get(Customer.class, id);  
		return customer;
	
	}
	
	public List<Customer> getCustomersByFirstName(String firstName){
		Session session =sf.openSession();    
		Query<Customer> customers = session.createQuery("from Customer c  where c.firstName = :firstName",Customer.class) ;
		customers.setParameter("firstName", firstName);
		List<Customer> list = customers.list();
		session.close();
		return list;
		
	}
	
	public List<Customer> getCustomersByLastName(String lastName){
		Session session =sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c  where c.lastName = :lastName",Customer.class) ;
		customers.setParameter("lastName", lastName);
		List<Customer> list = customers.list();
		session.close();
		return list;
		
	}
	
	public List<Customer> getCustomersByLessThanAge(Integer age){
		Session session =sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c  where c.age<:age ",Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();
		session.close();
		return list;
	
	}
	
	public List<Customer> getCustomersByAge(Integer age){
		Session session =sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c  where c.age = :age ",Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();
		session.close();
		return list;
	}
	
	
	
	public List<String> getCustomersFirstName(){
		Session  session =sf.openSession();
		return session.createQuery("select c.firstName from Customer c").list();

	}
	
	
	
	
	
	}
//	
//	
//	
//	
//	
//	
//
//=======
//    private SessionFactory sf;
//
//   
//    public CustomerDao(SessionFactory sf) {
//		super();
//		this.sf = sf;
//	}
//
//	// INSERT
//    public String insertCustomer(Customer customer) {
//    	    Session session =sf.openSession();
//    	    Transaction ts=session.beginTransaction();
//    	         session.persist(customer);
//    	         ts.commit();
//    	         sf.close();
//        return "Customer inserted successfully";
//    }
//
//    // GET ALL
//    public List<Customer> getCustomersList() {
//    	 Session session =sf.openSession();
//        return session.createQuery("from Customer" ,Customer.class).list();
//    }
//
//    // GET BY ID
//    public Customer getCustomerById(int id) {
//    	Session session =sf.openSession();
//        Customer customer = session. get(Customer.class, id);
//		return customer;
//    }
//
//    // UPDATE
//    public String updateCustomer(Customer customer) {
//    	Session session =sf.openSession();
//    	Transaction ts=session.beginTransaction();
//    	session.merge(customer);
//    	ts.commit();
//    	sf.close();
//        return "Customer updated successfully";
//    }
//
//    // DELETE
//    public String deleteCustomerById(int id) {
//    	Session session =sf.openSession();
//    	Transaction ts=session.beginTransaction();
//        Customer customer = session.get(Customer.class, id);
//        if (customer != null) {
//        	session.remove(customer);
//            return "Customer deleted successfully";
//        }
//        ts.commit();
//        sf.close();
//        return "Customer not found";
//    }
//
//    // BULK INSERT
//    public String insertMultipleCustomers(List<Customer> customers) {
//    	Session session =sf.openSession();
//    	Transaction ts=session.beginTransaction();
//        for (Customer c : customers) {
//        	session.persist(c);
//        }
//        ts.commit();
//        sf.close();
//        return "Customers inserted successfully";
//    }
//
//    // QUERIES
//    
//    public List<Customer> getCustomersByFirstName(String firstName){
//		Session session =sf.openSession();    
//		Query<Customer> customers = session.createQuery("from Customer c  where c.firstName = :firstName",Customer.class) ;
//		customers.setParameter("firstName", firstName);
//		List<Customer> list = customers.list();
//		session.close();
//		return list;
//		
//	}
//
//    public List<Customer> getCustomersByLastName(String lastName){
//		Session session =sf.openSession();
//		Query<Customer> customers = session.createQuery("from Customer c  where c.lastName = :lastName",Customer.class) ;
//		customers.setParameter("lastName", lastName);
//		List<Customer> list = customers.list();
//		session.close();
//		return list;
//		
//	}
//    public List<Customer> getCustomersByLessThanAge(Integer age){
//		Session session =sf.openSession();
//		Query<Customer> customers = session.createQuery("from Customer c  where c.age<:age ",Customer.class);
//		customers.setParameter("age", age);
//		List<Customer> list = customers.list();
//		session.close();
//		return list;
//	
//	}
//
//    public List<Customer> getCustomersByAge(Integer age){
//		Session session =sf.openSession();
//		Query<Customer> customers = session.createQuery("from Customer c  where c.age = :age ",Customer.class);
//		customers.setParameter("age", age);
//		List<Customer> list = customers.list();
//		session.close();
//		return list;
//	}
//
//    // UPDATE FIELDS
//    public String updateFirstName(Integer id,String firstName) {
//		Session session =sf.openSession();
//		Transaction tr = session.beginTransaction();
//		Customer customer = session.get(Customer.class, id);
//		customer.setFirstName(firstName);
//		tr.commit();
//		session.close();
//		return "updated susscessfully";
//	}
//		public String updateLatName(Integer id , String lastName) {
//		Session  session =sf.openSession();
//		Transaction tr = session.beginTransaction();
//		Customer customer = session.get(Customer.class, id);
//		customer.setLastName(lastName);
//		tr.commit();
//		session.close();
//		return "updated lastName susscessfully";
//	}
//
//    public String updateEmailId(Integer id , String emailId) {
//		Session  session =sf.openSession();
//		Transaction tr = session.beginTransaction();
//		Customer customer = session.get(Customer.class, id);
//		customer.setEmail(emailId);
//		tr.commit();
//		session.close();
//		return "updated emailId susscessfully";		
//	}
//
//    public String updateMobileNumber(Integer id , String mobileNumber) {
//		Session  session =sf.openSession();
//		Transaction tr = session.beginTransaction();
//		Customer customer = session.get(Customer.class, id);
//		customer.setMobileNumber(mobileNumber);
//		tr.commit();
//		session.close();
//		return "updated mobileNumber susscessfully";		
//	}
//
//    public String updateAge(Integer id , Integer age ) {
//		Session  session =sf.openSession();
//		Transaction tr = session.beginTransaction();
//		Customer customer = session.get(Customer.class, id);
//		customer.setAge(age);
//		tr.commit(); 
//		session.close();
//		return "updated age susscessfully";
//	}
//
//    // SELECT ONLY FIRST NAME
//    public List<String> getCustomersFirstName(){
//		Session  session =sf.openSession();
//		return session.createQuery("select c.firstName from Customer c").list();
//
//	}
//
//}
////>>>>>>> Stashed changes
