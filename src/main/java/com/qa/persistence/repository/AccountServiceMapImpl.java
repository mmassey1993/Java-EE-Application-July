package com.qa.persistence.repository;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domains.Account;


@Alternative
public class AccountServiceMapImpl implements AccountServiceDBRepo {

	public String getAllAccounts(){
	
	}
	
	public Account findAccount(long id) {
		
	}
	
	public String createAccount(String account) {
		
	}
	
	public String updateAccount(Account account, String firstname, String lastname, String accountnumber) {
		
	}
	
	public String deleteAccount(long id){
		
	}
	
	
}
