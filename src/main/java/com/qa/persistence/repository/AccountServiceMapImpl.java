package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domains.Account;
import com.qa.util.JSONUtil;



@Alternative
@Transactional (TxType.SUPPORTS)
public class AccountServiceMapImpl implements AccountServiceRepo {

	
	
	HashMap<Long, Account> accountMap = new HashMap<Long, Account>();
	List<Account> accountList;
	private Account account;
	@Inject
	private JSONUtil util;
	private long id;
	
	
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
	
	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		accountMap.put(id, aAccount);
		id++;
		return "Account has been created.";
	}
	
	public String updateAccount(Account account, String firstname, String lastname, String accountnumber) {
		account.setFirstName(firstname);
		account.setLastName(lastname);
		account.setAccountNumber(accountnumber);
		return "Account has been updated.";
	}
	
	public String deleteAccount(long id){
		if (accountMap.containsKey(id)) {
			accountMap.remove(id);
			return "Account has been removed.";
		}
		else return "Account has not been removed.";
	}
	
	
}
