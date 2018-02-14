package com.sam.spring5webfluxrestapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sam.spring5webfluxrestapp.domain.Vendor;
import com.sam.spring5webfluxrestapp.repository.VendorRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class VendorController {

    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @GetMapping("/api/v1/vendors")
    Flux<Vendor> list(){
        return vendorRepository.findAll();
    }

    @GetMapping("api/v1/vendors/{id}")
    Mono<Vendor> getById(@PathVariable String id){
        return vendorRepository.findById(id);
    }
}
