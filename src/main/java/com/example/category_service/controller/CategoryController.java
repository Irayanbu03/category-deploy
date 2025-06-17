package com.example.category_service.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.category_service.model.Category;
import com.example.category_service.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		Category newCategory = categoryService.saveCategory(category);
		return new ResponseEntity<Category>(newCategory,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable Long id){
		Category newCategory = categoryService.getCategory(id);
		return new ResponseEntity<Category>(newCategory,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllCategories(){
		List<Category> listOfAllCategories = categoryService.getAllCategories();
		return new ResponseEntity<List<Category>>(listOfAllCategories,HttpStatus.OK);
	}
}

