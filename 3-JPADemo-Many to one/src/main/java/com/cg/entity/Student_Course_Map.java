package com.cg.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student_Course_Map {
@GeneratedValue
@Id
private int id;
@ManyToOne
private Course c;
@ManyToOne
private Student s;
private LocalDate startDate;
private LocalDate endDate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Course getC() {
	return c;
}
public void setC(Course c) {
	this.c = c;
}
public Student getS() {
	return s;
}
public void setS(Student s) {
	this.s = s;
}
public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}
public LocalDate getEndDate() {
	return endDate;
}
public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}


}
