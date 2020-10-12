package com.anz.wholesale.repository;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Transaction {
	
	public Transaction() {}
	
	public Transaction(Long transactionId, Long accountNumber) {
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
	}
	
	@Id
	@Column(name="Transaction_ID")
	private Long transactionId;
	
	@Column(name="Account_Number")
	private Long accountNumber;
	
	@Column(name="Value_Date")
	@Type(type="date")
	private Date valueDate;
	
	@Column(name="Transaction_Amount")
	private BigDecimal transactionAmount;
	
	@Column(name="Transaction_Type")
	private String transactionType;
	
	@Column(name="Transaction_Narrative")
	private String transactionNarrative;

	public Long getTransactionId() {
		return transactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", valueDate="
				+ valueDate + ", transactionAmount=" + transactionAmount + ", transactionType=" + transactionType
				+ ", transactionNarrative=" + transactionNarrative + "]";
	}
}
