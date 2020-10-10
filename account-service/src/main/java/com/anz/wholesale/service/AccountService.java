package com.anz.wholesale.service;

import java.util.List;

import com.anz.wholesale.repository.Account;

public interface AccountService {
	
	Account getAccountDetails(Long accountNumber);
	List<Account> getUserAccounts(String userId);
}
