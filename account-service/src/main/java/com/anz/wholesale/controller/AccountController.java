package com.anz.wholesale.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anz.wholesale.repository.Account;
import com.anz.wholesale.service.AccountService;

@RestController
public class AccountController {
	
	private static Logger LOG = LoggerFactory 
		      .getLogger(AccountController.class);
	
	@Autowired
	private AccountService service;
	
	@GetMapping("/wholesale/accounts/{accountNumber}")
	public Account getAccountDetails (@PathVariable Long accountNumber){
		
		LOG.info("Start getAccountDetails");
		Account account = service.getAccountDetails(accountNumber);
		return account;
	}
	
	@GetMapping("/wholesale/users/{userId}/accounts")
	public List<Account> getUserAccounts (@PathVariable String userId){
		
		LOG.info("Start getUserAccounts....");
		List<Account> accounts = service.getUserAccounts(userId);
		return accounts;
	}
	
}
