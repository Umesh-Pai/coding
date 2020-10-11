package com.anz.wholesale.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anz.wholesale.exception.AccountNotFoundException;
import com.anz.wholesale.exception.InvalidRequestException;
import com.anz.wholesale.repository.Account;
import com.anz.wholesale.repository.Transaction;
import com.anz.wholesale.service.AccountService;

import org.springframework.hateoas.*;

@RestController
public class AccountController {
	
	private final static Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService service;
	
	@GetMapping("/wholesale/accounts/{accountNumber}")
	public Account getAccountDetails (@PathVariable Long accountNumber){
		
		/*LOG.debug("Start getAccountDetails....");
		LOG.info("Start getAccountDetails....");
		LOG.warn("Start getAccountDetails....");
		LOG.trace("Start getAccountDetails....");*/
		
		//accountNumber = null;
		if (accountNumber == null)
			throw new InvalidRequestException("Invalid Request");
		
		Account account = service.getAccountDetails(accountNumber);
		
		if (account == null) {
			//LOG.info("account not present::");
			throw new AccountNotFoundException("accountNumber-" + accountNumber + " not found");
		}
		
		//LOG.info("account in controller::" + account.toString());
		return account;
	}
	
	@GetMapping("/wholesale/users/{userId}/accounts")
	public List<Account> getUserAccounts (@PathVariable String userId){
		
		//LOG.info("Start getUserAccounts....");
		if (userId == null)
			throw new InvalidRequestException("Invalid Request");
		
		List<Account> accounts = service.getUserAccounts(userId);
				
		return accounts;
	}
	
	@GetMapping("/wholesale/accounts/{accountNumber}/transactions")
	public List<Transaction> getAccountTransactions (@PathVariable Long accountNumber){
		
		//LOG.info("Start getAccountTransactions....");
		
		if (accountNumber == null)
			throw new InvalidRequestException("Invalid Request");
		
		List<Transaction> txns = service.findByAccountNumber(accountNumber);
		return txns;
	}
	
}
