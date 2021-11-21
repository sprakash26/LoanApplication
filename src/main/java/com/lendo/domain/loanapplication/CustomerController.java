package com.lendo.domain.loanapplication;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;


//@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerRepository repository;
	@Autowired
	ApplicationManager applicationManager;
	// Single item
			@JsonView(View.UserView.JobView.class)
		 @GetMapping("/api/jobs/{id}")
			 Customer  one(@PathVariable String id) {
			    return repository.findById(id)
			      .orElseThrow(() -> new CustomerNotFoundException(id));
			       
		 }
			
			// Single item
				/*	@JsonView(View.UserView.JobView.class)
					 @GetMapping("/api/jobs/status")
					List<Customer> all() {
						    return repository.findByStatusContaining(status)
						      .orElseThrow(() -> new CustomerNotFoundException(status));
						       
					 }*/
	  
	  @PostMapping(value="/api/applications",
			  consumes = {MediaType.APPLICATION_JSON_VALUE},
			  produces = {MediaType.APPLICATION_JSON_VALUE})
	  @ResponseStatus(HttpStatus.CREATED)
	public  ResponseEntity<?> newCustomer(@Valid @RequestBody Customer newCustomer) {
		  log.info("Customer Object  {}",newCustomer);
		if(newCustomer.getId() == null || newCustomer.getId().equals("") || !repository.findById(newCustomer.getId()).isPresent()) {
			
		  String id = (newCustomer.getId() == null) || newCustomer.getId().equals("") ? UUID.randomUUID().toString(): newCustomer.getId().toString();
		  newCustomer.setId(id);
		  	System.out.println("inside post method controller ");
			System.out.println("before service call: "+Calendar.getInstance().getTime());
			CompletableFuture<String> completableFuture1 = applicationManager.getId();
			CompletableFuture<String> completableFuture2 = applicationManager.getId();
			CompletableFuture<String> completableFuture3 = applicationManager.getId();
			CompletableFuture<String> completableFuture4 = applicationManager.getId();
			
			CompletableFuture<Void> completableFutureCombined = CompletableFuture.allOf(completableFuture1,completableFuture2,completableFuture3,completableFuture4);
			completableFutureCombined.join();
			System.out.println("after service call: "+Calendar.getInstance().getTime());
		 newCustomer.setStatus(Status.PENDING.toString());
		 Customer newCustomers = repository.save(newCustomer);
		 return ResponseEntity.ok(newCustomers);
		  }
		  else {
				  return  ResponseEntity.badRequest().body("{\"error\":\"Duplicate ID\" }");						
				  
			  }
			  
		  }

}
