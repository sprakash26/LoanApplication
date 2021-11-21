package com.lendo.domain.loanapplication;

public class CustomerNotFoundException extends RuntimeException {

	CustomerNotFoundException(String id) {
		    super(" Application ID not available" + id);
		  }

}
