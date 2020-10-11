package com.anz.wholesale.service;

import java.util.List;

import com.anz.wholesale.repository.Account;
import com.anz.wholesale.repository.Transaction;

public interface AccountService {
	
	Account getAccountDetails(Long accountNumber);
	List<Account> getUserAccounts(String userId);
	List<Transaction> findByAccountNumber(Long accountNumber);
}
