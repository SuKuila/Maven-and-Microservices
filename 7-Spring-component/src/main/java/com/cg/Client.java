package com.cg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext apc=new ClassPathXmlApplicationContext("beans.xml");
		AccountService acs=(AccountService) apc.getBean("accservice");
		System.out.println(acs.creditService(50000));
		
	}

}
