package com.sam.spring5webfluxrestapp.controller;

import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	Flux<Category> list(){
		return categoryRepository.findAll();
	}
	
	@GetMapping("/api/v1/categories/{id}")
	Mono<Category> getById(@PathVariable String id){
		return categoryRepository.findById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/v1/categories")
	Mono<Void> create(@RequestBody Publisher<Category> categoryStream){//param can be mono or flux
		return categoryRepository.saveAll(categoryStream).then();
	}
	
	@PutMapping("/api/v1/categories/{id}")
    Mono<Category> update(@PathVariable String id, @RequestBody Category category) {
        category.setId(id);
        return categoryRepository.save(category);
    }
	
	

}
