package com.cg.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
private int empId;
private String enpName;
@Embedded
private Address address;

public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEnpName() {
	return enpName;
}
public void setEnpName(String enpName) {
	this.enpName = enpName;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}



}
