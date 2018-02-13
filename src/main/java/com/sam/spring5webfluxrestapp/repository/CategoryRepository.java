package com.sam.spring5webfluxrestapp.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sam.spring5webfluxrestapp.domain.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category,String>  {

}
