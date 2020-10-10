package com.anz.wholesale.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.anz.wholesale.repository.Account;
import com.anz.wholesale.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repository;

	public Account getAccountDetails (Long accountNumber) {
		
		Optional<Account> account = repository.findById(accountNumber);
		return account.get();
	}
	
	public List<Account> getUserAccounts(String userId) {
		
		return repository.findByUserId(userId);
		
	}

}
