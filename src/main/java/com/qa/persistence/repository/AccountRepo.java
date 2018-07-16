package com.qa.persistence.repository;

public interface AccountRepo {

	public String getAllAccounts();
	
	public String createAccount(String account);
	
	public String updateAccount(long id, String account);
	
	public String deleteAccount(long id);



}
