package com.programming.techie.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.programming.techie.productservice.model.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}