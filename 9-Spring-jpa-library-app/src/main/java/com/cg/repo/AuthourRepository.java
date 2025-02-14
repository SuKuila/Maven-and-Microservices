package com.cg.repo;

import java.util.List;

import com.cg.entity.Authour;
import com.cg.entity.Book;

public interface AuthourRepository {
	public Authour addAuthour( Authour a);
	public List<Authour> allAuthours( );
	
	public Authour searchById( int id);
	public List<Authour> searchByAuthourName(String name );
	public List<Book> findByAuthour( int authourId);
}
