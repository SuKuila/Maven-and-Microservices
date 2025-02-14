package com.cg.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) {
	ApplicationContext apc=new ClassPathXmlApplicationContext("beans.xml");
	HelloWorldBean bean=(HelloWorldBean) apc.getBean("helloBean");
	System.out.println(bean.sayHello("sk"));
	PersonBean p=(PersonBean) apc.getBean("person");
	p.display();
}
}
