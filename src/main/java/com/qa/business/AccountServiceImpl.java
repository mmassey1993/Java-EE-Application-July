package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.domains.Account;
import com.qa.persistence.repository.AccountServiceRepo;
import com.qa.util.JSONUtil;

public class AccountServiceImpl implements IAccountService {
	
	
	private Checker check;
	
	@Inject
	private AccountServiceRepo repo;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
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
	public String updateAccount(long id, String account) {
		return repo.updateAccount(id, account);
	}

	@Override
	public String deleteAccount(long id) {
		return repo.deleteAccount(id);
	}

}
