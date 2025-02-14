package com.cg.beans;

public class HelloWorldBean {
private String msg;
public HelloWorldBean() {
	System.out.println("Constructor");
}
public void setMsg(String msg) {
	System.out.println("setter");
	this.msg=msg;
}
public String sayHello(String name) {
	return "Hi "+name+" "+msg;
}
}
