package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account_SB")
public class Account {
	
	@Id
	private int accId;
	private String accType;
	private double accBalance;
	
	public Account() {}
	
	public Account(int accId, String accType, double accBalance) {
		super();
		this.accId = accId;
		this.accType = accType;
		this.accBalance = accBalance;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
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
		return "Account [accId=" + accId + ", accType=" + accType + ", accBalance=" + accBalance + "]";
	}

}
