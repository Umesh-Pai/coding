package com.anz.wholesale.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anz.wholesale.repository.Transaction;
import com.anz.wholesale.service.TransactionService;

@RestController
public class TransactionController {
	
	private static Logger LOG = LoggerFactory 
		      .getLogger(TransactionController.class);
	
	@Autowired
	private TransactionService service;
	
	@GetMapping("/wholesale/transactions/{txnId}")
	public Transaction getTransactionDetails (@PathVariable Long txnId){
		
		LOG.info("Start getAccountDetails");
		Transaction txn = service.getTransactionDetails(txnId);
		return txn;
	}
	
	@GetMapping("/wholesale/accounts/{accountNumber}/transactions")
	public List<Transaction> getAccountTransactions (@PathVariable Long accountNumber){
		
		LOG.info("Start getAccountTransactions....");
		List<Transaction> txns = service.findByAccountNumber(accountNumber);
		return txns;
	}
	
}
