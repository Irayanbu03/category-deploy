package com.example.category_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.category_service.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	Category getCategoryById(Long id);
}

