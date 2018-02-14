package com.sam.spring5webfluxrestapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sam.spring5webfluxrestapp.domain.Category;
import com.sam.spring5webfluxrestapp.repository.CategoryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CategoryController {
	
	private final CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	@GetMapping("/api/v1/categories")
	public Flux<Category> list(){
		return categoryRepository.findAll();
	}
	
	@GetMapping("/api/v1/categories/{id}")
	public Mono<Category> getById(@PathVariable String id){
		return categoryRepository.findById(id);
	}
	

}
