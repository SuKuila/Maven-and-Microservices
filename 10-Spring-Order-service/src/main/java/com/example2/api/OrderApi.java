package com.example2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example2.Order;
import com.example2.proxy.ProductApiProxy;

@RestController

@RequestMapping("/orders")

public class OrderApi {
	@Autowired
	private RestTemplate template;

	@PostMapping("/{id}/{q}")
	public Order orderProduct(@PathVariable int id, @PathVariable("q") int quantity) {
//without load balancing
//String url="http://localhost:8080/products/"+id;

//RestTemplate template=new RestTemplate();
//with load balancing with restTemplate
		String url = "http://Product-service/products/" + id;
		Order order = template.getForObject(url, Order.class);

		order.setQuantity(quantity);

		order.setPrice(order.getPrice() * quantity);

		return order;

	}

	@Autowired
	private ProductApiProxy proxy;

	@PostMapping("/feign/{id}/{q}")
	public Order orderProductFeign(@PathVariable int id, @PathVariable("q") int quantity) {
		Order order = proxy.orderProduct(id);
		order.setQuantity(quantity);
		order.setPrice(order.getPrice() * quantity);
		return order;
	}

}