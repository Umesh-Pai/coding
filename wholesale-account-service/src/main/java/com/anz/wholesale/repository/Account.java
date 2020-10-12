package com.anz.wholesale.repository;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Type;

@Entity
public class Account{
	
	public Account() {}
	
	public Account(Long accountId, Long accountNumber, String userId) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.userId = userId;
	}
	
	@JsonIgnore
	@Id
	@Column(name="Account_Id")
	private Long accountId;

	@Column(name="Account_Number")
	private Long accountNumber;
	
	@JsonIgnore
	@Column(name="User_ID")
	private String userId;
	
	@Column(name="Account_Name")
	private String accountName;
	
	@Column(name="Account_Type")
	private String accountType;
	
	@Column(name="Currency")
	private String currency;
	
	@Column(name="Available_Balance")
	private BigDecimal availableBalance;
	
	
	@Column(name="Balance_Date")
	@Type(type="date")
	private Date balanceDate;
	
	public Long getAccountId() {
		return accountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public String getUserId() {
		return userId;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getCurrency() {
		return currency;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}
	
	public Date getBalanceDate() {
		return balanceDate;
	}
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", userId=" + userId + ", accountName=" + accountName
				+ ", accountType=" + accountType + ", currency=" + currency + ", availableBalance=" + availableBalance
				+ "]";
	}

}
