package com.cg.repo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.entity.Authour;
import com.cg.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class AuthourRepositoryImpl implements AuthourRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Authour addAuthour(Authour a) {
		em.persist(a);
		return a;
	}

	@Override
	public List<Authour> allAuthours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Authour searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Authour> searchByAuthourName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByAuthour(int authourId) {
		// TODO Auto-generated method stub
		return null;
	}

}
