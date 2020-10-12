package com.anz.wholesale.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anz.wholesale.dto.AccountDTO;
import com.anz.wholesale.dto.TransactionDTO;
import com.anz.wholesale.exception.InvalidRequestException;
import com.anz.wholesale.repository.Account;
import com.anz.wholesale.repository.Transaction;
import com.anz.wholesale.service.AccountService;

@RestController
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class AccountController {
		
	@Autowired
	private AccountService service;
	
	@GetMapping(value = "/wholesale/users/{userId}/accounts", produces = { "application/hal+json" })
	public CollectionModel<AccountDTO> getUserAccounts (@PathVariable String userId){
		
		if (userId == null)
			throw new InvalidRequestException("Invalid Request");
		
		List<AccountDTO> accounts = service.getUserAccounts(userId);
		for (AccountDTO accountDTO : accounts) {
	        Long accountNumber = accountDTO.getAccountNumber();
	        Link txnLink = linkTo(methodOn(AccountController.class).getAccountTransactions(accountNumber)).withRel("get transactions");
	        accountDTO.add(txnLink);
	    }
		
        Link selfLink = linkTo(methodOn(AccountController.class).getUserAccounts(userId)).withSelfRel();
        return CollectionModel.of(accounts).add(selfLink);
	}
	
	@GetMapping(value = "/wholesale/accounts/{accountNumber}/transactions", produces = { "application/hal+json" })
	public CollectionModel<TransactionDTO> getAccountTransactions (@PathVariable Long accountNumber){
				
		if (accountNumber == null)
			throw new InvalidRequestException("Invalid Request");
		
		List<TransactionDTO> txns = service.findByAccountNumber(accountNumber);
		String userId = null;
		if (txns.size() > 0) {
			userId = txns.get(0).getUserId();
		}
				
        Link selfLink = linkTo(methodOn(AccountController.class).getAccountTransactions(accountNumber)).withSelfRel();
        Link accountsLink = linkTo(methodOn(AccountController.class).getUserAccounts(userId)).withRel("account list");
	    
	    return CollectionModel.of(txns).add(selfLink).add(accountsLink);
	}
	
}
