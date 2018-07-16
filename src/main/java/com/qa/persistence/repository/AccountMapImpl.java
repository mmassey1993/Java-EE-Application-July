package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.constants.Constants;
import com.qa.persistence.domains.Account;
import com.qa.util.JSONUtil;


@ApplicationScoped
@Alternative
public class AccountMapImpl implements AccountRepo {

	private static final Long INITIAL_COUNT = 1L;
	Map<Long, Account> accountMap;
	private long id;
	
	@Inject
	private JSONUtil util;
	
	public AccountMapImpl() {
		this.accountMap = new HashMap<Long, Account>();
		id = INITIAL_COUNT;
		initAccountMap();
	}
	
	@Override
	public String getAllAccounts(){
		
		return util.getJSONForObject(accountMap.values());
	}
	
	@Override
	public String createAccount(String account) {
		id++;
		Account aAccount = util.getObjectForJSON(account, Account.class);
		accountMap.put(id, aAccount);
		return account;
	}
	
	@Override
	public String updateAccount(long id, String account) {
		return util.getJSONForObject(accountMap.values());
	}
	
	@Override
	public String deleteAccount(long id){
		if (accountMap.containsKey(id)) {
			accountMap.remove(id);
			return Constants.ACCOUNT_DELETED;
		}
		else return Constants.ACCOUNT_NOT_DELETED;
	}	
	
	public void initAccountMap() {
		Account account = new Account("Joe", "Bloggs", "012345");
		accountMap.put(1L, account);
	}
	
}
