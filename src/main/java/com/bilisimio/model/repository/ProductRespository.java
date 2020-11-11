package com.bilisimio.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bilisimio.model.Product;

@Repository
public interface ProductRespository extends PagingAndSortingRepository<Product, Long> {

	Page<Product> findAll(Pageable pageable);

}
