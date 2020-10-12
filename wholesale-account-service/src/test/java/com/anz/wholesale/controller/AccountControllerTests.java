package com.anz.wholesale.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.anz.wholesale.dto.AccountDTO;
import com.anz.wholesale.dto.TransactionDTO;
import com.anz.wholesale.exception.InvalidRequestException;
import com.anz.wholesale.repository.Account;
import com.anz.wholesale.repository.Transaction;
import com.anz.wholesale.service.AccountService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountControllerTests {
	
	@Mock
	private AccountService service;
	
	@InjectMocks
	private AccountController controller = new AccountController();
	
	@Test
	public void whenUserIdProvided_thenReturnUserAccounts() {
        String userId = "user001";
        
        AccountDTO account = new AccountDTO(300001L, 10001990L, userId);
        List<AccountDTO> accountList = new ArrayList<AccountDTO>();
        accountList.add(account);
        when(service.getUserAccounts(userId)).thenReturn(accountList);
        
        CollectionModel<AccountDTO> accounts = controller.getUserAccounts(userId);
        System.out.println("accounts::" + accounts);
        assertThat(accounts).isNotNull();
	}
	
	@Test
	public void whenUserIdIsNull_thenThrowException() {
		String userId = null;
		Exception exception = assertThrows(InvalidRequestException.class, () -> {
			controller.getUserAccounts(userId);
	    });
	 
	    String actualMessage = exception.getMessage();
	    System.out.println("actualMessage::" + actualMessage);
	    assertTrue(actualMessage.contains("Invalid Request"));
	}
	
	@Test
	public void whenUserIdProvided_thenReturnSelfLink() {
        String userId = "user001";
        
        AccountDTO account = new AccountDTO(300001L, 10001990L, userId);
        List<AccountDTO> accountList = new ArrayList<AccountDTO>();
        accountList.add(account);
        when(service.getUserAccounts(userId)).thenReturn(accountList);
        
        CollectionModel<AccountDTO> accounts = controller.getUserAccounts(userId);
        System.out.println("accounts::" + accounts);
        assertThat(accounts).toString().contains("self");
	}
	
	@Test
	public void whenAccountNumberProvided_thenReturnTransactions() {
        Long accountNumber = 10001590L;
        
        TransactionDTO transaction = new TransactionDTO (10002L, accountNumber);
        List<TransactionDTO> transactionList = new ArrayList<TransactionDTO>();
        transactionList.add(transaction);
        when(service.findByAccountNumber(accountNumber)).thenReturn(transactionList);
        
        CollectionModel<TransactionDTO> transactions = controller.getAccountTransactions(accountNumber);
        System.out.println("transactions::" + transactions);
        assertThat(transactions).isNotNull();
	}
	
	@Test
	public void whenAccountNumberIsNull_thenThrowException() {
		Long accountNumber = null;
		Exception exception = assertThrows(InvalidRequestException.class, () -> {
			controller.getAccountTransactions(accountNumber);
	    });
	 
	    String actualMessage = exception.getMessage();
	    System.out.println("actualMessage::" + actualMessage);
	    assertTrue(actualMessage.contains("Invalid Request"));
	}
	
	@Test
	public void whenAccountNumberProvided_thenReturnSelfLink() {
		Long accountNumber = 10001590L;
		
		TransactionDTO transaction = new TransactionDTO (10002L, accountNumber);
        List<TransactionDTO> transactionList = new ArrayList<TransactionDTO>();
        transactionList.add(transaction);
        when(service.findByAccountNumber(accountNumber)).thenReturn(transactionList);
		
        CollectionModel<TransactionDTO> transactions = controller.getAccountTransactions(accountNumber);
        System.out.println("transactions::" + transactions);
        assertThat(transactions).toString().contains("self");
	}
}
