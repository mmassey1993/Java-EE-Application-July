package com.qa.persistence.domains;

import javax.persistence.*;


@Entity
public class Transactions {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "TRANSACTIONID")
	private long transactionId;
	@Column (length = 30)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "Account", referencedColumnName = "ACCOUNTID")
	private Account account;
	
	public Transactions(int transactionId, String name) {
		this.transactionId = transactionId;
		this.name = name;
	}
	
	public long getId() {
		return transactionId;
	}
	public void setId(long id) {
		this.transactionId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
