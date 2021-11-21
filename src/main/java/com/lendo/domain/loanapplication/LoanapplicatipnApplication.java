package com.lendo.domain.loanapplication;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
@ComponentScan(basePackages = {"com.lendo.domain.loanapplication"})
public class LoanapplicatipnApplication {

	public static void main(String[] args) {
	    System.out.println("Hello World");
		SpringApplication.run(LoanapplicatipnApplication.class, args);
	}
}
