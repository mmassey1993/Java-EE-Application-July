package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.IAccountService;

@Path("/account")
public class AccountController {

	@Inject
	private IAccountService accountservice;
	
	@GET
	@Path("/json")
	public String getAllAccounts() {
		return accountservice.getAllAccounts();
	}
	
	@POST
	@Path("/json/{account}")
	public String createAccount(@PathParam("account") String account) {
		return accountservice.createAccount(account);
	}
	
	@PUT
	@Path("/json/{id}")
	public String updateAccount(@PathParam("id") long id, String account) {
		return accountservice.updateAccount(id, account);
	}
	
	@DELETE
	@Path("/json/{id}")
	public String deleteAccount(@PathParam("id") long id) {
		return accountservice.deleteAccount(id);
	}
	
	
	
	
}
