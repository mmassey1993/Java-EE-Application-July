package com.qa.persistence.domains;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Account {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "ACCOUNTID")
	private long id;
	@Column (length = 30)
	private String firstName;
	@Column (length = 30)
	private String lastName;
	@Column
	@Size (min=6, max=6)
	private String accountNumber;
	@OneToMany
	@JoinTable(name = "Account_Transactions", joinColumns = @JoinColumn(name = "ACCOUNTID"), inverseJoinColumns = @JoinColumn(name = "TRANSACTIONID"))
	private List<Transactions> transactions; 
	
	public Account(String firstName, String lastName, String accountNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String toString() {
		return "First Name: " + getFirstName() + " Last Name: " + getLastName() + " Account Number: " + getAccountNumber();
	}
	
}
