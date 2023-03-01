package com.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Product;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
    void deleteProductById(Long id);
    Optional<Product> findProductById(Long id);
}
