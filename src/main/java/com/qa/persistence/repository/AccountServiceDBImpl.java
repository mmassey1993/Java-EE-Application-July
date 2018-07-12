package com.qa.persistence.repository;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


import com.qa.persistence.domains.Account;
import com.qa.util.JSONUtil;
@Default
@Transactional(TxType.SUPPORTS)
public class AccountServiceDBImpl implements AccountServiceDBRepo{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	private JSONUtil util;
	
	public String getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.lastName DESC", Account.class);
		Collection<Account> accounts = query.getResultList();
		return util.getJSONForObject(accounts);
	}
	
	public Account findAccount(long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(TxType.REQUIRED)
	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		em.persist(aAccount);
		return "{\"message\": \"account successfully added\"}";
	}
	
	@Transactional(TxType.REQUIRED)
	public String updateAccount(Account account, String firstname, String lastname, String accountnumber) {
		account.setFirstName(firstname);
		account.setLastName(lastname);
		account.setAccountNumber(accountnumber);
		em.refresh(account);
		return "{\"message\": \"account successfully updated\"}";
	}
	
	@Transactional(TxType.REQUIRED)
	public String deleteAccount(long id){
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			em.remove(accountInDB);
		}
		return "{\"message\": \"account successfully deleted\"}";
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
