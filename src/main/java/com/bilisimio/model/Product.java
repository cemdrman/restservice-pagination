package com.bilisimio.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
