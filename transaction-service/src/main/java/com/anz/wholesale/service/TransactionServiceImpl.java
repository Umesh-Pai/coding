package com.anz.wholesale.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.anz.wholesale.repository.Transaction;
import com.anz.wholesale.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository repository;

	public Transaction getTransactionDetails (Long txnId) {
		
		Optional<Transaction> txn = repository.findById(txnId);
		return txn.get();
	}
	
	public List<Transaction> findByAccountNumber(Long accountNumber) {
		
		return repository.findByAccountNumber(accountNumber);
	}

}
