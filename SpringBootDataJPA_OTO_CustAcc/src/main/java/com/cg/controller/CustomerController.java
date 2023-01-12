package com.cg.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@PostMapping("/new-cust")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer c){
		try {
			return new ResponseEntity<>(service.addCustomer(c), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all-customers")
	public ResponseEntity<List<Customer>> findAllCustomers(){
		try {
			return new ResponseEntity<>(service.getCustomers(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> customerById(@PathVariable("id") int id){
		try {
			return new ResponseEntity<>(service.getCustomerById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteCust/{id}")
	public ResponseEntity<Boolean> deleteCust(@PathVariable("id") int id) {
		try {
			boolean isDel = service.deleteCustomer(id);
			return new ResponseEntity<>(isDel, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateCust/{id}")
	public ResponseEntity<Customer> modifyEmployeeById(@PathVariable("id") int id, @RequestBody Customer c){
		try {
			Customer cust = service.modifyCustomer(id, c );
			return new ResponseEntity<>(cust, HttpStatus.OK);
		}catch(Exception e){
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping("customer-details/account/{accNo}")
	public ResponseEntity<Account> customerByAccNo(@PathVariable("accNo") int accNo){
		try {
			Account acc = service.getCustFromAccNo(accNo);
			System.out.println(acc);
			return new ResponseEntity<>(acc, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
}
