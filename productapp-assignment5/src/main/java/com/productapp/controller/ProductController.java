package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.status(200).body(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.status(200).body(productService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.status(200).body(productService.save(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable String id) {
        return ResponseEntity.status(200).body(productService.update(id, product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.status(200).body("Product deleted successfully");
    }
}