package com.anz.wholesale.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.anz.wholesale.exception.AccountNotFoundException;

@ControllerAdvice
@RestController
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
	  
	  System.out.println("in handleAllExceptions");
	  
	  ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
			  request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR);
      return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(AccountNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleAccountNotFoundExceptions(AccountNotFoundException ex, WebRequest request) {
	  
	  System.out.println("in handleAccountNotFoundException");
	  ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
			  request.getDescription(false), HttpStatus.NOT_FOUND);
	  return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(InvalidRequestException.class)
  public final ResponseEntity<ExceptionResponse> handleInvalidRequestExceptions(InvalidRequestException ex, WebRequest request) {
	  
	  System.out.println("in handleInvalidRequestExceptions"+ request.getDescription(false));
	  ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
        request.getDescription(false), HttpStatus.BAD_REQUEST);
	  return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
  
/*  @ExceptionHandler(ResourceNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleResourceNotFoundExceptions(ResourceNotFoundException ex, WebRequest request) {
	  
	  System.out.println("in handleResourceNotFoundExceptions"+ request.getDescription(false));
	  ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
        request.getDescription(false), HttpStatus.BAD_REQUEST);
	  return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }*/
}