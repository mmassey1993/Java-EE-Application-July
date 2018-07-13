package com.qa.persistence.repository;


import java.util.List;

import javax.enterprise.inject.Default;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


import com.qa.persistence.domains.Account;
import com.qa.util.JSONUtil;


@Transactional(TxType.SUPPORTS)
@Default
public class AccountServiceDBImpl implements AccountServiceRepo{
	
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	
	@Override
	public String getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.lastName DESC", Account.class);
		List<Account> accounts = query.getResultList();
		return util.getJSONForObject(accounts);
	}
	
	public Account findAccount(long id) {
		return em.find(Account.class, id);
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		em.persist(aAccount);
		return "{\"message\": \"account successfully added\"}";
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
	public String updateAccount(long id, String account) {
		Account updateAccount = util.getObjectForJSON(account, Account.class);
		Account accFromDB = findAccount(id);
		if (account != null) {
			accFromDB = updateAccount;
			em.merge(accFromDB);
		}
		
		return "{\"message\": \"account successfully updated\"}";
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
	public String deleteAccount(long id){
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			em.remove(accountInDB);
		}
		return "{\"message\": \"account successfully deleted\"}";
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
