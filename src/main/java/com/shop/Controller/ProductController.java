package com.shop.Controller;

import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.Product;
import com.shop.service.ProductService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
 


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService employeeService) {
        this.productService = employeeService;
    }

    
    @GetMapping("/hello")
    public String hello() {
    	System.out.println("");
      return "Hello World!";
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts () {
        List<Product> products = productService.findAllProducts();
        System.out.println();
        products.forEach(s->{System.out.print(s.getName());});
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/single/{id}")
    public ResponseEntity<Product> getProductById (@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestParam("product") String product,@RequestParam("file") MultipartFile image) throws  JsonParseException , JsonMappingException , Exception {
    	
    	Product product1= new ObjectMapper().readValue(product,Product.class);
    	product1.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
    	productService.addProduct(product1);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
    	Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
    	productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
