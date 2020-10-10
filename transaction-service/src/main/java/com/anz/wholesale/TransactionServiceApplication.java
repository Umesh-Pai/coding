package com.anz.wholesale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionServiceApplication {
	
	private static Logger LOG = LoggerFactory 
		      .getLogger(TransactionServiceApplication.class);

	public static void main(String[] args) {
		LOG.info("Start TransactionServiceApplication");
		SpringApplication.run(TransactionServiceApplication.class, args);
	}

}
