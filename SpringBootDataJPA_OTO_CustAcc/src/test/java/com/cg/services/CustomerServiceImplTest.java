package com.cg.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.dao.CustomerRepository;
import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.exception.NoSuchCustomerFoundException;


@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

	@Mock
	private CustomerRepository custRepo;
	
	@InjectMocks
	private CustomerServiceImpl service;
	
	private Customer cust = null;
	private List<Customer> custList;
	
	@BeforeEach
	private void innitCustomer() {
		cust = new Customer();
		cust.setCustName("Sho");
		cust.setCustId(1);
		Account acc = new Account();
		acc.setAccBalance(550);
		acc.setAccNo(455);
		acc.setAccType("saving");
		
		cust.setCustAcc(acc);
		
		custList = new ArrayList<>();
		custList.add(cust);
	}
	
	
	@Test
	void testAddCustomer() {
		Mockito.when(service.addCustomer(cust)).thenReturn(cust);
		assertEquals(service.addCustomer(cust),cust);
		
	}

	@Test
	void testGetCustomers() {
		Mockito.when(service.getCustomers()).thenReturn(custList);
		
			assertEquals(custList,service.getCustomers());
		
	}

	@Test
	void testGetCustomerById() {
		


		try {
//			Mockito.when(custRepo.findById(5)).thenReturn(Optional.of(cust)).thenAnswer(i->service.getCustomerById(5));
			
			Mockito.when(custRepo.findById(5)).thenReturn(Optional.of(cust));
			
//			Mockito.when(service.getCustomerById(5)).thenReturn(cust).thenAnswer(i->service.getCustomerById(5));

			assertEquals(cust,service.getCustomerById(5));

		} catch (NoSuchCustomerFoundException e) {
			fail("failed");
		}
	}
//
	@Test
	void testModifyCustomer() {
		try {
//			custRepo.delete(cust);
//			Mockito.when(Optional.of(cust).isPresent()).thenReturn(true);
			
			cust.setCustName("shoaib");
			System.out.println("debug");

			Mockito.when(custRepo.findById(1)).thenReturn(Optional.of(cust))
				.thenAnswer(i->service.getCustomerById(1));
			System.out.println("debug1");

			
		
			assertEquals(cust,service.modifyCustomer(1, cust));
			System.out.println("debug2");

		} catch (NoSuchCustomerFoundException e) {
			e.printStackTrace();
			fail("fail");
		}
//		fail("fail");
	}
//
	@Test
	void testDeleteCustomer() {
		try {
			Mockito.when(custRepo.findById(5)).thenReturn(Optional.of(cust));

			assertTrue(service.deleteCustomer(5));

		} catch (NoSuchCustomerFoundException e) {
			e.printStackTrace();
			fail("fail");
		}
	}
//
//	@Test
//	void testGetCustFromAccNo() {
//		fail("Not yet implemented");
//	}

}
