package com.anz.wholesale.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByAccountNumber(Long accountNumber);
	List<Account> findByUserId(String userId);
}
