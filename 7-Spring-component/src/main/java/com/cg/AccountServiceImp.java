package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("accservice")
public class AccountServiceImp implements AccountService {
	@Autowired
	private AccountRepository accRepo;
	public AccountServiceImp() {
		System.out.println("constructor acc service");
	}
//	@Autowired
//	public void setAccRepo(AccountRepository accRepo) {
//		System.out.println("setter");
//		this.accRepo = accRepo;
//	}
	public String creditService(float amt) {
		//calling repository
		return accRepo.credit(amt);
	}

}
