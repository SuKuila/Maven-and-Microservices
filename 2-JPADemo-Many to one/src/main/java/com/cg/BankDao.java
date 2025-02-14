package com.cg;

import java.util.List;

import com.cg.entity.Bank;
import com.cg.entity.BankCustomer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class BankDao {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpaPU");
public static void main(String[] args) {
	System.out.println("test table created");
	//addNewBank();
	//addnewCustomer("1234569");
	readAllCustomerGreaterBalance(100);
	searchCustomerbyIFSC("1234569");
}
static void addNewBank() {
	Bank bank=new Bank();
	EntityManager em=emf.createEntityManager();
	bank.setIfscCode("1234569");
	bank.setBankName("AXIS");
	bank.setBranch("EPIP");
	em.getTransaction().begin();
	em.persist(bank);
	em.getTransaction().commit();
	System.out.println("Added");
	em.close();
}
static void addnewCustomer(String ifscCode) {
	EntityManager em=emf.createEntityManager();
	Bank bank=em.find(Bank.class, ifscCode);
	if(bank!=null) {
		BankCustomer c=new BankCustomer();
		em.getTransaction().begin();
		c.setAccNo(12346);
		c.setCustName("Ramesh");
		c.setBankBalance(1000);
		c.setBank(bank);
		em.persist(c);
		em.getTransaction().commit();
		System.out.println(" Customer Added");
	}
	else {
		System.out.println("Invalid IFSC");
	}
	
}
static void readAllCustomerGreaterBalance(float balanceAmt) {
	EntityManager em=emf.createEntityManager();
	String jpql="select b from BankCustomer b where b.bankBalance>:amt";
	TypedQuery<BankCustomer> q=em.createQuery(jpql, BankCustomer.class);
	q.setParameter("amt", balanceAmt);
	List<BankCustomer> list=q.getResultList();
	list.forEach(c->System.out.println(c.getAccNo()+" "+c.getCustName()+" "+c.getBankBalance()));
}
private static void searchCustomerbyIFSC(String ifsc) {
	EntityManager em=emf.createEntityManager();
	String jpql="select c from BankCustomer c where c.bank.ifscCode=:bankIfsc";
	TypedQuery<BankCustomer> q=em.createQuery(jpql,BankCustomer.class);
	q.setParameter("bankIfsc", ifsc);
	List<BankCustomer> cList=q.getResultList();
	System.out.println("Result ");
	cList.forEach(c->System.out.println(c.getAccNo()+" "+c.getCustName()+" "+c.getBankBalance()));
}
}   
