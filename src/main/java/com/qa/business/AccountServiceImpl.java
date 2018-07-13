package com.qa.business;

import com.qa.persistence.domains.Account;
import com.qa.persistence.repository.AccountServiceRepo;
import com.qa.util.JSONUtil;

public class AccountServiceImpl implements IAccountService {
	
	private AccountServiceRepo repo;
	private Checker check;
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String findAccount(long id) {
		return repo.findAccount(id);
	}

	@Override
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		
		if (check.checkAccount(acc.getAccountNumber()) == false) {
			return "{\"message\": \"This account is blocked.\"}";
		}
		
		return repo.createAccount(account);
	}

	@Override
	public String updateAccount(Account account, String firstname, String lastname, String accountnumber) {
		return repo.updateAccount(account, firstname, lastname, accountnumber);
	}

	@Override
	public String deleteAccount(long id) {
		return repo.deleteAccount(id);
	}

}
