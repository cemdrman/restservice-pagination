package com.bilisimio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bilisimio.model.Product;
import com.bilisimio.model.repository.ProductRespository;

@Service
public class ProductService {

	@Autowired
	private ProductRespository productRespository;

	public Page<Product> getAllProducts(String productName, int page, int size) {
		Pageable pageable = createPageable(page, size);
		if (StringUtils.isEmpty(productName)) {
			return productRespository.findAll(pageable);
		}
		return productRespository.findByNameContaining(productName, pageable);

	}

	private Pageable createPageable(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
		Pageable pageable1 = PageRequest.of(page, size);
		Pageable pageable2 = PageRequest.of(page, size, Direction.ASC, "id");
		return pageable;
	}

	public Product getProductByName(String productName) {
		return productRespository.findByNameIgnoreCase(productName);
	}

}
