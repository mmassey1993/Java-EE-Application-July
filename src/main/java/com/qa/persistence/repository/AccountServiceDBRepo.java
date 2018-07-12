package com.qa.persistence.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


import com.qa.persistence.domains.Account;

@Transactional(TxType.SUPPORTS)
public class AccountServiceDBRepo {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public List<Account> getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.lastName DESC", Account.class);
		return query.getResultList();
	}
	
	public Account findAccount(Long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(TxType.REQUIRED)
	public Account createAccount(Account account) {
		em.persist(account);
		return account;
	}
	
	@Transactional(TxType.REQUIRED)
	public Account updateAccount(Account account, String firstname, String lastname, String accountnumber) {
		account.setFirstName(firstname);
		account.setLastName(lastname);
		account.setAccountNumber(accountnumber);
		em.refresh(account);
		return account;
	}
	
	@Transactional(TxType.REQUIRED)
	public List<Account> deleteAccount(Long id){
		TypedQuery<Account> query = em.createQuery("DELETE a FROM Account a WHERE ACCOUNTID = a.id", Account.class);
		return query.getResultList();
	}
}
