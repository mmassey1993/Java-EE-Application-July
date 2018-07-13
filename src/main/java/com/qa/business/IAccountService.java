package com.qa.business;

import com.qa.persistence.domains.Account;

public interface IAccountService {
	
	public String getAllAccounts();
	
	public String findAccount(long id);
	
	public String createAccount(String account);
	
	public String updateAccount(Account account, String firstname, String lastname, String accountnumber);
	
	public String deleteAccount(long id);
}
