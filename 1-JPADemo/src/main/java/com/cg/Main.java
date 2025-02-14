package com.cg;


import java.util.List;
import java.util.function.Consumer;

import com.cg.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

	public static void main(String[] args) {
		System.out.println("Hello");

		//addCustomer();
		//searchById(101);
		allCustomers();
	}

	 static void allCustomers() {
		EntityManager em=emf.createEntityManager();
		String jpql="select c from Customer c";
		
		TypedQuery<Customer> q=em.createQuery(jpql, Customer.class);
		List<Customer> clist= q.getResultList();
		
		Consumer<Customer> printObject=list->System.out.println(list.getCustId()+" "+list.getCustName()+" "+list.getAddress()+" "+list.getPhoneNo());
		
		clist.forEach(printObject);
		
	}

	static void searchById(int cid) {
		EntityManager em = emf.createEntityManager();
		Customer c = em.find(Customer.class, cid);
		if (c != null) {
			System.out.println(c.getCustName() );
		} else {
			System.out.println("Customer not found");
		}
	}

	static void addCustomer() {
		Customer c1 = new Customer();
		c1.setCustId(105);
		c1.setCustName("Kamlesh");
		c1.setAddress("Vijayawada");
		c1.setPhoneNo(345678219);

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c1);
		em.getTransaction().commit();
		System.out.println("Added :)");
	}
}
