package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account_SB")
public class Account {
	
	@Id
	private int accNo;
	private String accType;
	private double accBalance;
	
	public Account() {}
	
	public Account(int accNo, String accType, double accBalance) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.accBalance = accBalance;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType + ", accBalance=" + accBalance + "]";
	}
	

}
