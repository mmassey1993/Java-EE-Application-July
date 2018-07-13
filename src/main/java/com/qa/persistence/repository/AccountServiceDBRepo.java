package com.qa.persistence.repository;

import java.util.List;

import com.qa.persistence.domains.Account;

public interface AccountServiceDBRepo {

	public String getAllAccounts();
	
	public String findAccount(long id);
	
	public String createAccount(String account);
	
	public String updateAccount(Account account, String firstname, String lastname, String accountnumber);
	
	public String deleteAccount(long id);

}
