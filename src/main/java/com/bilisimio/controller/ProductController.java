package com.bilisimio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bilisimio.model.Product;
import com.bilisimio.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products")
	public ResponseEntity<Page<Product>> fetchProducts(@RequestParam("page") int page, @RequestParam("size") int size) {
		return new ResponseEntity<Page<Product>>(productService.getAllProducts(page, size), HttpStatus.OK);
	}

}
