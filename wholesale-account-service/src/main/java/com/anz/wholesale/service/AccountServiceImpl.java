package com.anz.wholesale.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.wholesale.dto.AccountDTO;
import com.anz.wholesale.dto.TransactionDTO;
import com.anz.wholesale.repository.Account;
import com.anz.wholesale.repository.AccountRepository;
import com.anz.wholesale.repository.Transaction;
import com.anz.wholesale.repository.TransactionRepository;


@Service
public class AccountServiceImpl implements AccountService {
		
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<AccountDTO> getUserAccounts(String userId) {
		List<Account> accountList = accountRepository.findByUserId(userId);		
		AccountDTO accountDTO = null;
		List<AccountDTO> accountDTOList = new ArrayList<AccountDTO>();
		
		for (Account account : accountList) {
			accountDTO = convertToAccountDto(account);
			accountDTOList.add(accountDTO);
		}
		return accountDTOList;
	}
	
	public List<TransactionDTO> findByAccountNumber(Long accountNumber) {
		
		List<Transaction> transactionList = transactionRepository.findByAccountNumber(accountNumber);		
		Account account = accountRepository.findByAccountNumber(accountNumber);
		TransactionDTO txnDTO = null;
		List<TransactionDTO> txnDTOList = new ArrayList<TransactionDTO>();
		
		for (Transaction txn : transactionList) {
			txnDTO = convertToTransactionDto(txn, account.getAccountName(), account.getCurrency(), account.getUserId());
			txnDTOList.add(txnDTO);
		}

		return txnDTOList;
	}
	
	private TransactionDTO convertToTransactionDto(Transaction txn, String accountName, String currency, String userId) {
		TransactionDTO txnDTO = new TransactionDTO();
		txnDTO.setAccountNumber(txn.getAccountNumber());
		txnDTO.setValueDate(txn.getValueDate());
		txnDTO.setTransactionAmount(txn.getTransactionAmount());
		txnDTO.setTransactionType(txn.getTransactionType());
		txnDTO.setTransactionNarrative(txn.getTransactionNarrative());
		txnDTO.setAccountName(accountName);
		txnDTO.setCurrency(currency);
		txnDTO.setUserId(userId);
        return txnDTO;
    }
	
	private AccountDTO convertToAccountDto(Account account) {		
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber(account.getAccountNumber());
		accountDTO.setAccountName(account.getAccountName());
		accountDTO.setUserId(account.getUserId());
		accountDTO.setAccountType(account.getAccountType());
		accountDTO.setCurrency(account.getCurrency());
		accountDTO.setAvailableBalance(account.getAvailableBalance());
		accountDTO.setBalanceDate(account.getBalanceDate());		
        return accountDTO;
    }
	
}
