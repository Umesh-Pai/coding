package com.anz.wholesale.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
  private Date timestamp;
  private String message;
  private String details;
  private HttpStatus status;
  //private int value;

  public ExceptionResponse(Date timestamp, String message, String details, HttpStatus status) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
    this.status = status;
    //this.value = value;
  }
  
  /*public int getValue() {
	return value;
  }*/

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }
  
  public HttpStatus getStatus() {
	return status;
  }

}