package com.cg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cg.entity.Course;
import com.cg.entity.Student;
import com.cg.entity.Student_Course_Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CourseDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

	public static void main(String[] args) {
		System.out.println("Tables created");
		//addNewCourse();
		//addNewStudent();
	}

	static void addNewCourse() {
		EntityManager em = emf.createEntityManager();
		Course c1 = new Course();
		c1.setCid(101);
		c1.setCname("Java");
		Course c2 = new Course();
		c2.setCid(102);
		c2.setCname("Python");
		Course c3 = new Course();
		c3.setCid(103);
		c3.setCname("C++");
		Course c4 = new Course();
		c4.setCid(104);
		c4.setCname(".net");
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.getTransaction().commit();
		em.close();
		System.out.println("Courses Added");
	}

	static void addNewStudent() {
		EntityManager em = emf.createEntityManager();
		Student s1 = new Student();
		s1.setStudId(10001);
		s1.setStudName("A");
		s1.setEmail("a@");
		Student s2 = new Student();
		s2.setStudId(10002);
		s2.setStudName("B");
		s2.setEmail("b@");
		Student s3 = new Student();
		s3.setStudId(10003);
		s3.setStudName("C");
		s3.setEmail("c@");
		Student s4 = new Student();
		s4.setStudId(10004);
		s4.setStudName("D");
		s4.setEmail("d@");
		em.getTransaction().begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		em.getTransaction().commit();
		em.close();
		System.out.println("Students added");

	}
	static void enrollStudent(int studentId,int courseId) {
		EntityManager em=emf.createEntityManager();
		Student s=em.find(Student.class, studentId);
		Course c=em.find(Course.class, courseId);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-mm-yyyy");
		LocalDate sDate=LocalDate.parse("01-02-2025",dtf);
		LocalDate eDate=LocalDate.parse("03-03-2025",dtf);
		
		if (s!=null && c!=null) {
			Student_Course_Map cm=new Student_Course_Map();
			cm.setS(s);
			cm.setC(c);
			cm.setStartDate(sDate);
			cm.setEndDate(eDate);
			em.getTransaction().begin();
			em.persist(cm);
			em.getTransaction().commit();
			
		}
		else {
			System.out.println("invalid");
		}
		em.close();
	}
}
