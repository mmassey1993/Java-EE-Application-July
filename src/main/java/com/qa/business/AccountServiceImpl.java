package com.qa.business;

import javax.inject.Inject;

import com.qa.constants.Constants;
import com.qa.persistence.domains.Account;
import com.qa.persistence.repository.AccountRepo;
import com.qa.util.JSONUtil;

public class AccountServiceImpl implements IAccountService {
	
	@Inject
	private Checker check;
	
	@Inject
	private AccountRepo repo;
	
	@Inject
	private JSONUtil util;
	
	private boolean isAccountBlocked(Account acc) {
		return check.checkAccount(acc.getAccountNumber());
	}

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		
		if (isAccountBlocked(acc) == true) {
			return Constants.ACCOUNT_BLOCKED;
		}else return repo.createAccount(account);
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
