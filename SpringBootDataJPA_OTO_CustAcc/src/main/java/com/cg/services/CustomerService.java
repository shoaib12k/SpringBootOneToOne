package com.cg.services;

import java.util.List;

import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.exception.NoSuchCustomerFoundException;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	List<Customer> getCustomers();
	Customer getCustomerById(int custId) throws NoSuchCustomerFoundException;
	
	Customer modifyCustomer(int custId, Customer cust) throws NoSuchCustomerFoundException;
	boolean deleteCustomer(int custId) throws NoSuchCustomerFoundException;
	
	
}
