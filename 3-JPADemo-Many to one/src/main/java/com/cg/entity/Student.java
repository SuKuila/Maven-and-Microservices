package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {
	@Id
private int studId;
private String studName;
private String email;
public int getStudId() {
	return studId;
}
public void setStudId(int studId) {
	this.studId = studId;
}
public String getStudName() {
	return studName;
}
public void setStudName(String studName) {
	this.studName = studName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
