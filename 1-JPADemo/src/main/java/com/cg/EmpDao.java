package com.cg;

import java.util.List;
import java.util.function.Consumer;

import com.cg.entity.Address;

import com.cg.entity.Employee;
//import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmpDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

	public static void main(String[] args) {
		System.out.println("Embeddable Demo");
		//addNewEmployee();
		printEmployee();
		
		//updateEmployee(101,"Samrui");
		deleteEmployee(103);
	}
	static void updateEmployee(int eid, String ename) {
		EntityManager em=emf.createEntityManager();
		
		
		Employee e=em.find(Employee.class, eid);
		if(e!=null) {
			e.setEnpName(ename);
			em.getTransaction().begin();
			em.getTransaction().commit();
			System.out.println(e.getEnpName());
		}
		em.close();
	}
	static void deleteEmployee(int eid) {
		EntityManager em=emf.createEntityManager();
		Employee e=em.find(Employee.class, eid);
		if (e!=null) {
			System.out.print(e.getEnpName());
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			System.out.println(" is removed");
		}
		em.close();
	}
	static void addNewEmployee() {
		Address a1=new Address();
		Employee e1=new Employee();
		EntityManager em=emf.createEntityManager();
		
		e1.setEmpId(103);
		e1.setEnpName("Kamlesh");
		a1.setDoorNo("103");
		a1.setPlaceName("Bengaluru");
		a1.setPinCode(560037);
		e1.setAddress(a1);
		
		em.getTransaction().begin();
		em.persist(e1);
		em.getTransaction().commit();
		em.close();
		System.out.println("Employee Added");
	}
	static void printEmployee() {
		
		EntityManager em=emf.createEntityManager();
		
		String jpql="select e from Employee e";
		TypedQuery<Employee> q=em.createQuery(jpql, Employee.class);
		List<Employee> empList= q.getResultList();
		
		Consumer<Employee> printEmp=emp->System.out.println(emp.getEmpId()+" "+emp.getEnpName()+" "+emp.getAddress().getDoorNo()+" "+emp.getAddress().getPlaceName()+" "+emp.getAddress().getPinCode());
		
		empList.forEach(printEmp);
		em.close();
	}
}
