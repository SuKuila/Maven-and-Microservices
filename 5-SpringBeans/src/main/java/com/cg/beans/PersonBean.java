package com.cg.beans;

public class PersonBean {
private String name;
private String address;
public PersonBean(String name, String address) {
	
	this.name = name;
	this.address = address;
}
public void display() {
	System.out.println(name+" is from "+address);
}
}
