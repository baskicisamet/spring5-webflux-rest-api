package com.sam.spring5webfluxrestapp.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.sam.spring5webfluxrestapp.domain.Vendor;

public interface VendorRepository extends ReactiveCrudRepository<Vendor, String> {
	
	

}
