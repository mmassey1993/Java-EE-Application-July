package com.qa.business;

public class Checker {
	
	public boolean checkAccount(String accountnumber) {
		if (accountnumber.equals("999999")) {
			return false;
		}
		else return true;
	}

}
