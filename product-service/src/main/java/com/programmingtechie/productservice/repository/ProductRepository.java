package com.programming.techie.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
package com.programming.techie.productservice.model.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}