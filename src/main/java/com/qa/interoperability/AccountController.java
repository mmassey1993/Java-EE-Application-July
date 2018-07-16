package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.IAccountService;

@Path("/account")
@Produces({"application/json"})
public class AccountController {

	@Inject
	private IAccountService accountservice;
	
	@Path("/json")
	@GET
	public String getAllAccounts() {
		return accountservice.getAllAccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String createAccount(String account) {
		return accountservice.createAccount(account);
	}
	
	@Path("/json/{id}")
	@PUT
	public String updateAccount(@PathParam("id") long id, String account) {
		return accountservice.updateAccount(id, account);
	}
	
	@Path("/json/{id}")
	@DELETE
	public String deleteAccount(@PathParam("id") long id) {
		return accountservice.deleteAccount(id);
	}
	
	
	
	
}
