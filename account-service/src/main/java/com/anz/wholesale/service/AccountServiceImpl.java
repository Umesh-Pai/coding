package com.anz.wholesale.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.anz.wholesale.controller.AccountController;
import com.anz.wholesale.repository.Account;
import com.anz.wholesale.repository.Transaction;
import com.anz.wholesale.repository.AccountRepository;
import com.anz.wholesale.repository.TransactionRepository;


@Service
public class AccountServiceImpl implements AccountService {
	
	private static Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	public Account getAccountDetails (Long accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}
	
	public List<Account> getUserAccounts(String userId) {
		return accountRepository.findByUserId(userId);
	}
	
	public List<Transaction> findByAccountNumber(Long accountNumber) {
		return transactionRepository.findByAccountNumber(accountNumber);
	}
	
}
