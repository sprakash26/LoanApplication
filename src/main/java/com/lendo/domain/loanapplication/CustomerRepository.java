package com.lendo.domain.loanapplication;
import java.util.List;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CassandraRepository <Customer, String> {

	List<Customer> findByStatusContaining(String status);
	//List<Customer> findExistingID(String id);	
} 


