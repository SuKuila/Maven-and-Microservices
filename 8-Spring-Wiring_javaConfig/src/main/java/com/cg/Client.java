package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.cg.config.SpringConfig;

public class Client {

	public static void main(String[] args) {
		ApplicationContext apc=new AnnotationConfigApplicationContext(SpringConfig.class);
		AccountService acs=(AccountService) apc.getBean("accservice");
		System.out.println(acs.creditService(50000));
		
	}

}
