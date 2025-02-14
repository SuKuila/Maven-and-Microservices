package com.cg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//import com.cg.AccountRepository;
import com.cg.AccountService;
import com.cg.AccountServiceImp;
//import com.cg.SevingsAccRepoImp;
@ComponentScan(basePackages = "com.cg")
public class SpringConfig {
	@Bean("accservice")
	public AccountService getServie() {
		return new AccountServiceImp();
	}
//	@Bean
//	public AccountRepository getRepo() {
//		return new SevingsAccRepoImp();
//	}
}
