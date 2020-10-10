package com.anz.wholesale.repository;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Account {
	
	public Account() {}
	
	@Id
	@Column(name="Account_Number")
	private Long accountNumber;
	
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
	//@Temporal(TemporalType.DATE)
	private Date balanceDate;

	public Long getAccountNumber() {
		return accountNumber;
	}

	/*public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}*/

	public String getUserId() {
		return userId;
	}

	/*public void setUserId(String userId) {
		this.userId = userId;
	}*/

	public String getAccountName() {
		return accountName;
	}

	/*public void setAccountName(String accountName) {
		this.accountName = accountName;
	}*/

	public String getAccountType() {
		return accountType;
	}

	/*public void setAccountType(String accountType) {
		this.accountType = accountType;
	}*/

	public String getCurrency() {
		return currency;
	}

	/*public void setCurrency(String currency) {
		this.currency = currency;
	}*/

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	/*public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}*/
	
	public Date getBalanceDate() {
		return balanceDate;
	}

	/*public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}*/
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", userId=" + userId + ", accountName=" + accountName
				+ ", accountType=" + accountType + ", currency=" + currency + ", availableBalance=" + availableBalance
				+ "]";
	}

}
