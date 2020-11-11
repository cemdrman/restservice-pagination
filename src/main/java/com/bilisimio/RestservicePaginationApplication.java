package com.bilisimio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bilisimio.model.Product;
import com.bilisimio.model.repository.ProductRespository;

@SpringBootApplication
public class RestservicePaginationApplication {

	@Autowired
	private ProductRespository respository;

	public static void main(String[] args) {
		SpringApplication.run(RestservicePaginationApplication.class, args);
	}

	@PostConstruct
	private void insertProducts() {
		List<Product> productList = new ArrayList<>();

		for (int i = 1; i <= 30; i++) {
			String productName = "Product".concat("_" + i);
			productList
					.add(new Product(new Long(i), productName, "https://bilisim.io/".concat(productName), getAmount()));
		}
		respository.saveAll(productList);
	}

	private BigDecimal getAmount() {
		double amount = ThreadLocalRandom.current().nextDouble(55, 500);
		return BigDecimal.valueOf(amount);
	}

}
