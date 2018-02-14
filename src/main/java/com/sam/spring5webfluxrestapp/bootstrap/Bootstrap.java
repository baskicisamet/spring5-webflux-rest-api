package com.sam.spring5webfluxrestapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sam.spring5webfluxrestapp.domain.Category;
import com.sam.spring5webfluxrestapp.domain.Vendor;
import com.sam.spring5webfluxrestapp.repository.CategoryRepository;
import com.sam.spring5webfluxrestapp.repository.VendorRepository;

@Component
public class Bootstrap implements CommandLineRunner{

	
	private final CategoryRepository categoryRepository;
	private final VendorRepository vendorRepository;
	
	
	
	
	public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.vendorRepository = vendorRepository;
	}




	@Override
	public void run(String... args) throws Exception {
		
		  if(categoryRepository.count().block() == 0){
	            //load data
	            System.out.println("#### LOADING DATA ON BOOTSTRAP #####");

	            categoryRepository.save(Category.builder()
	                        .description("Fruits").build()).block();

	            categoryRepository.save(Category.builder()
	                    .description("Nuts").build()).block();

	            categoryRepository.save(Category.builder()
	                    .description("Breads").build()).block();

	            categoryRepository.save(Category.builder()
	                    .description("Meats").build()).block();

	            categoryRepository.save(Category.builder()
	                    .description("Eggs").build()).block();

	            System.out.println("Loaded Categories: " + categoryRepository.count().block());

	            vendorRepository.save(Vendor.builder()
	                        .firstName("Joe")
	                        .lastName("Buck").build()).block();

	            vendorRepository.save(Vendor.builder()
	                    .firstName("Micheal")
	                    .lastName("Weston").build()).block();

	            vendorRepository.save(Vendor.builder()
	                    .firstName("Jessie")
	                    .lastName("Waters").build()).block();

	            vendorRepository.save(Vendor.builder()
	                    .firstName("Bill")
	                    .lastName("Nershi").build()).block();

	            vendorRepository.save(Vendor.builder()
	                    .firstName("Jimmy")
	                    .lastName("Buffett").build()).block();

	            System.out.println("Loaded Vendors: " + vendorRepository.count().block());
		  }
	}
	
	
}
