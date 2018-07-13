package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.qa.persistence.domains.Account;
import com.qa.util.JSONUtil;



@Alternative
public class AccountServiceMapImpl implements AccountServiceRepo {

	HashMap<Long, Account> accountMap = new HashMap<Long, Account>();
	List<Account> accountList;
	private Account account;
	private long id;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllAccounts(){
		Iterator<Entry<Long, Account>> it = accountMap.entrySet().iterator();
		while (it.hasNext()) {
			HashMap.Entry<Long, Account> account = (HashMap.Entry<Long, Account>) it.next();
			accountList.add((Account) account);
		}
		return util.getJSONForObject(accountList);
	}
	

	public String findAccount(long id) {
		if (accountMap.containsKey(id)) {
			account = accountMap.get(id);
		}
		return util.getJSONForObject(account);
	}
	
	@Override
	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		accountMap.put(id, aAccount);
		id++;
		return "Account has been created.";
	}
	
	@Override
	public String updateAccount(long id, String account) {
		return util.getJSONForObject(accountMap.values());
	}
	
	@Override
	public String deleteAccount(long id){
		if (accountMap.containsKey(id)) {
			accountMap.remove(id);
			return "Account has been removed.";
		}
		else return "Account has not been removed.";
	}	
	
}
