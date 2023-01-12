package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Customer_SB")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	private String custName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Account custAcc;

	public Customer() {}

	public Customer(int custId, String custName, Account custAcc) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAcc = custAcc;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Account getCustAcc() {
		return custAcc;
	}

	public void setCustAcc(Account custAcc) {
		this.custAcc = custAcc;
		this.custAcc.setAccId(custAcc.getAccId());
		this.custAcc.setAccBalance(custAcc.getAccBalance());
		this.custAcc.setAccType(custAcc.getAccType());
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAcc=" + custAcc + "]";
	}
	
	
}
