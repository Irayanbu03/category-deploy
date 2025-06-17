package com.example.category_service.model;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Product> products;
	
	public Category() {
		
	}
	public Category(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Product> getProduct() {
//		return products;
//	}
//
//	public void setProduct(List<Product> products) {
//		this.products = products;
//	}

}

