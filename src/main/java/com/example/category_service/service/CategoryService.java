package com.example.category_service.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.category_service.dto.Product;
import com.example.category_service.model.Category;
import com.example.category_service.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	public Category getCategory(Long id) {
		return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not available"));
	}
	@KafkaListener(topics = "product", groupId = "my-group", containerFactory = "productListener")
	// Method
	public void consume(Product product) {
		// Print statement
		System.out.println("message = " + product);
}
}

