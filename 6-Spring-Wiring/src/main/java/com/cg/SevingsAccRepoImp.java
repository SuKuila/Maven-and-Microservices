package com.cg;

public class SevingsAccRepoImp implements AccountRepository {

	public SevingsAccRepoImp() {

		System.out.println("constructor savings");
	}

	public String credit(float amt) {
		// update the DB
		return "Hi your salary of " + amt + " credited in ur savings Account";
	}
}
