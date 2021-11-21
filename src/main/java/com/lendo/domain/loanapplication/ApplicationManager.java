package com.lendo.domain.loanapplication;



import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ApplicationManager {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
	  @Async
	  public CompletableFuture<String> getId() {
		  System.out.println("get create application service before Thread sleep: "+Calendar.getInstance().getTime());
		  try {
			  Thread.sleep(5000);
		  } catch (InterruptedException e) {
				e.printStackTrace();
	  }
		  System.out.println("get create application service after Thread sleep: "+Calendar.getInstance().getTime());
		  CompletableFuture<String> completableFuture = new CompletableFuture<>();
		  	completableFuture.complete("customer");
			return completableFuture;
	  }			
}
