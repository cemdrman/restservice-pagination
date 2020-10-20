package com.bilisimio.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	private Long id;
	@Column
	private String name;
	@Column
	private String imageUrl;
	@Column
	private BigDecimal amount;

}
