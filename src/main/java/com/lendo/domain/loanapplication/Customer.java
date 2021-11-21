package com.lendo.domain.loanapplication;
import java.util.Objects;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Table(value = "CUSTOMER")
@XmlRootElement
public class Customer {
		
	 // private @Id @GeneratedValue Long uuid;
	  @PrimaryKey
	  @JsonView(value = {View.UserView.ApplicationView.class,View.UserView.JobView.class})
	  @NotEmpty(message = "Application ID is mandatory")
	  private String id = null;
	  @JsonView(value = {View.UserView.ApplicationView.class})
	  @NotEmpty(message = "First Name is mandatory")
	  private String firstName;
	  @JsonView(value = {View.UserView.ApplicationView.class})
	  @NotEmpty(message = "Last Name is mandatory")
	  private String lastName;
	  @JsonView(value = {View.UserView.ApplicationView.class,View.UserView.JobView.class})
	  private String status;
	  private static final Logger log = LoggerFactory.getLogger(Customer.class);
	   
	public  Customer () {}

	public  Customer(String firstName, String lastName, String status) {
		 this.firstName = firstName;
	    this.lastName = lastName;
	    this.status = status;
	    log.info("Id Generated :: {}",this.id);
	  }

	  public String getId() {
	    return this.id;
	  }

	  public String getfirstName() {
	    return this.firstName;
	  }

	  public String getlastName() {
	    return this.lastName;
	  }

	  public void setId(String id) {
	    this.id = id;
	    log.info("Id Set :: {}",this.id);
	  }
	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public void setlastName(String lastName) {
	    this.lastName = lastName;
	  }

	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Customer))
	      return false;
	    Customer customer = (Customer) o;
	    return Objects.equals(this.id, customer.id) && Objects.equals(this.firstName, customer.firstName)
	        && Objects.equals(this.lastName, customer.lastName) && Objects.equals(this.status, customer.status);
	  } 

	 @Override
	  public int hashCode() {
	    return Objects.hash(this.id,this.firstName, this.lastName, this.status);
	  }

	  @Override
	  public String toString() {
	    return "Customer{" + "id=" + this.id + ",firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", status='" + this.status + '\'' +"}'";
	  }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	}

	
