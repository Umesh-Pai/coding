package com.anz.wholesale.dto;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TransactionDTO {
	
	public TransactionDTO() {}
	
	public TransactionDTO(Long transactionId, Long accountNumber) {
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
	}

	@JsonIgnore
	private Long transactionId;
	private Long accountNumber;
	private String accountName;
	private Date valueDate;
	private String currency;
	private BigDecimal transactionAmount;
	private String transactionType;
	private String transactionNarrative;
	@JsonIgnore
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Date getValueDate() {
		return valueDate;
	}
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionNarrative() {
		return transactionNarrative;
	}
	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", accountName="
				+ accountName + ", valueDate=" + valueDate + ", currency=" + currency + ", transactionAmount="
				+ transactionAmount + ", transactionType=" + transactionType + ", transactionNarrative="
				+ transactionNarrative + "]";
	}
	
}
