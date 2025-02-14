package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.model.Product;

@Service
public class ProductService {
	@Autowired

	private Environment env;

	List<Product> products=new ArrayList<>();

	public List<Product> allProducts(){

	String port=env.getProperty("local.server.port");

	products.add(new Product(101,"Dosa",120,port));

	products.add(new Product(102,"Briyani",200,port));

	products.add(new Product(103,"Noodles",100,port));

	products.add(new Product(104,"Chocolate Cake",400,port));

	products.add(new Product(105,"KFCChicken",500,port));

	return products;

	}
}
