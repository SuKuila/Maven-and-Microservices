package com.cgservice;

import java.util.List;

import com.cg.entity.Authour;
import com.cg.entity.Book;

public interface AuthourService {
	public Authour addAuthourService( Authour a);
	public List<Authour> allAuthoursService( );
	
	public Authour searchByIdService( int id);
	public List<Authour> searchByAuthourNameService(String name );
	public List<Book> findByAuthourService( int authourId);
}
