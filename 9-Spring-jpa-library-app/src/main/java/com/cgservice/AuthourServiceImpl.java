package com.cgservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.entity.Authour;
import com.cg.entity.Book;
import com.cg.repo.AuthourRepository;

import jakarta.transaction.Transactional;
@Component
public class AuthourServiceImpl  implements AuthourService{
	@Autowired
	private AuthourRepository authorRepo;
	@Override
	@Transactional
	public Authour addAuthourService(Authour a) {
		return authorRepo.addAuthour(a);
	}
	@Override
	public List<Authour> allAuthoursService() {
		return null;
	}

	@Override
	public Authour searchByIdService(int id) {
		return null;
	}

	@Override
	public List<Authour> searchByAuthourNameService(String name) {
		return null;
	}

	@Override
	public List<Book> findByAuthourService(int authourId) {
		return null;
	}

}
