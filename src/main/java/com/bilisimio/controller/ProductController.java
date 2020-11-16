package com.bilisimio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bilisimio.model.Product;
import com.bilisimio.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products")
	public ResponseEntity<Page<Product>> fetchProducts(
			@RequestParam(required = false, name = "productName") String productName,
			@RequestParam(defaultValue = "0", name = "page") int page,
			@RequestParam(defaultValue = "5", name = "size") int size) {
		return new ResponseEntity<>(productService.getAllProducts(productName, page, size), HttpStatus.OK);
	}

	@GetMapping(value = "/products/{productName}")
	public ResponseEntity<Product> fetchProducts(
			@PathVariable(required = true, name = "productName") String productName) {
		return new ResponseEntity<>(productService.getProductByName(productName), HttpStatus.OK);
	}

}
