package com.anz.wholesale.service;

import java.util.List;

import com.anz.wholesale.dto.AccountDTO;
import com.anz.wholesale.dto.TransactionDTO;

public interface AccountService {
	
	List<AccountDTO> getUserAccounts(String userId);
	List<TransactionDTO> findByAccountNumber(Long accountNumber);
}
