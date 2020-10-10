package com.anz.wholesale.service;

import java.util.List;
import com.anz.wholesale.repository.Transaction;

public interface TransactionService {
	
	Transaction getTransactionDetails(Long txnId);
	List<Transaction> findByAccountNumber(Long accountNumber);
}
