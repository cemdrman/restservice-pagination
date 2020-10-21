package com.bilisimio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilisimio.model.Product;
import com.bilisimio.model.repository.ProductRespository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRespository productRespository;
	
	public List<Product> getAllProducts() {
		return (List<Product>) productRespository.findAll();
	}

}
