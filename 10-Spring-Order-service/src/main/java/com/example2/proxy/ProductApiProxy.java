package com.example2.proxy;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example2.Order;
//for without load balancer
//@FeignClient(name = "x",url ="http://localhost:8080" )
@FeignClient(name = "Product-service")
public interface ProductApiProxy {
	@GetMapping("/products/{id}")
	Order orderProduct( @PathVariable int id);
}