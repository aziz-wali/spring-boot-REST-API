package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Product;
import com.shop.repo.ProductRepo;

import tech.getarrays.shop.exception.UserNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService {
	 @Autowired
    private ProductRepo productRepo;

   
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        product.setProductCode(UUID.randomUUID().toString());
        return productRepo.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public Product findProductById(Long id) {
        return productRepo.findProductById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteProduct(Long id){
    	productRepo.deleteProductById(id);
    }
}
