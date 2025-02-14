package com.cg.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Authour;
import com.cg.entity.Book;
import com.cgservice.AuthourService;

@RestController
@RequestMapping("/authours")
public class AuthourApi {
	@Autowired
	private AuthourService aservice;
	@PostMapping
	public Authour addAuthour(@RequestBody Authour a){
		return aservice.addAuthourService(a);
	}
	public List<Authour> allAuthours( ){
		return null;
	}
	
	public Authour searchById( int id){
		return null;
	}
	public List<Authour> searchByAuthourName(String name ){
		return null;
	}
	public List<Book> findByAuthour( int authourId){
		 return null;

	}
}
