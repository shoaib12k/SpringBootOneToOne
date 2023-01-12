package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.CustomerRepository;
import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.exception.NoSuchCustomerFoundException;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public Customer addCustomer(Customer customer) {

		return custRepo.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		
		return custRepo.findAll();

	}

	@Override
	public Customer getCustomerById(int custId) throws NoSuchCustomerFoundException {
		
		Optional<Customer> customer = custRepo.findById(custId);
		
		if(customer.isPresent()) {
			return customer.get();
		}else {
			throw new NoSuchCustomerFoundException("No Customer with this id");
		}
		
	}

	@Override
	@Transactional
	public Customer modifyCustomer(int custId, Customer cust) throws NoSuchCustomerFoundException {
		Customer findCust = getCustomerById(custId);
		
		findCust.setCustName(cust.getCustName());
		findCust.setCustId(cust.getCustId());
		findCust.setCustAcc(cust.getCustAcc());
		
		return custRepo.save(findCust);
	}

	@Override
	@Transactional
	public boolean deleteCustomer(int custId) throws NoSuchCustomerFoundException {
		
		Optional<Customer> emp = custRepo.findById(custId);
		if(emp.isPresent()) {
			custRepo.delete(emp.get());
			return true;
		}else {
			throw new NoSuchCustomerFoundException("Customer Not found");
		}
	}

	@Override
	public Account getCustFromAccNo(int accNo) {
		return custRepo.getCustByAccNo(accNo);
	}



}
