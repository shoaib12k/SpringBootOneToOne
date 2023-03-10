package com.cg.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Account;
import com.cg.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("Select c from Customer c Join c.custAcc a where a.accNo = :accNo")
	public Account getCustByAccNo(@Param("accNo") int accNo);
	
}
