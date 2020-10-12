package com.anz.wholesale.dto;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountDTO extends RepresentationModel<AccountDTO> {
	
	public AccountDTO() {}
	
	public AccountDTO(Long accountId, Long accountNumber, String userId) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.userId = userId;
	}
	
	@JsonIgnore
	private Long accountId;
	private Long accountNumber;
	private String userId;
	private String accountName;
	private String accountType;	
	private String currency;	
	private BigDecimal availableBalance;
	private Date balanceDate;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}
	public Date getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}
	
	@Override
	public String toString() {
		return "AccountDTO [accountId=" + accountId + ", accountNumber=" + accountNumber + ", userId=" + userId
				+ ", accountName=" + accountName + ", accountType=" + accountType + ", currency=" + currency
				+ ", availableBalance=" + availableBalance + ", balanceDate=" + balanceDate + "]";
	}
	
}
