package com.anz.wholesale.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.anz.wholesale.dto.AccountDTO;
import com.anz.wholesale.dto.TransactionDTO;
import com.anz.wholesale.repository.Account;
import com.anz.wholesale.repository.AccountRepository;
import com.anz.wholesale.repository.Transaction;
import com.anz.wholesale.repository.TransactionRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountServiceImplTests {
	
	@Mock
	private AccountRepository accountRepository;
	
	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private AccountService service = new AccountServiceImpl();
	
	@Test
	public void whenUserIdProvided_thenReturnUserAccounts() {
        String userId = "user001";
                        
        Account account = new Account(400001L, 10001110L, userId);
        List<Account> accountList = new ArrayList<Account>();
        accountList.add(account);
        System.out.println("accountList::" + accountList);

        when(accountRepository.findByUserId(userId)).thenReturn(accountList);
        System.out.println("before::");
        List<AccountDTO> accounts = service.getUserAccounts(userId);
        System.out.println("accounts::" + accounts);
        assertThat(accounts).isNotEmpty();
	}
	
	@Test
	public void whenUserIdIsNull_thenReturnEmptyList() {
		String userId = "user002";
		
        List<Account> accountList = new ArrayList<Account>();
        when(accountRepository.findByUserId(userId)).thenReturn(accountList);
		
        List<AccountDTO> accounts = service.getUserAccounts(userId);
        System.out.println("accounts***::" + accounts);
        assertThat(accounts).isEmpty();
	}
	
	@Test
	public void whenAccountNumberProvided_thenReturnTransactions() {
		Long accountNumber = 10001660L;
		
        Transaction transaction = new Transaction (10006L, accountNumber);
        List<Transaction> transactionList = new ArrayList<Transaction>();
        transactionList.add(transaction);
        when(transactionRepository.findByAccountNumber(accountNumber)).thenReturn(transactionList);
        
        Account account = new Account(500001L, 10002220L, "user003");
        when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(account);
		
		List<TransactionDTO> transactions = service.findByAccountNumber(accountNumber);
        System.out.println("transactions::" + transactions);
        assertThat(transactions).isNotEmpty();
	}
	
	@Test
	public void whenAccountNumberIsNull_thenReturnEmptyList() {
		Long accountNumber = 10001770L;
		
		List<Transaction> transactionList = new ArrayList<Transaction>();
        when(transactionRepository.findByAccountNumber(accountNumber)).thenReturn(transactionList);
        
        Account account = new Account();
        when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(account);
		
		List<TransactionDTO> transactions = service.findByAccountNumber(accountNumber);
        System.out.println("transactions***::" + transactions);
        assertThat(transactions).isEmpty();
	}
	
}
