package com.productstore.service;

import com.productstore.entities.Product;
import com.productstore.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class ProductStoreApplication implements CommandLineRunner {

    private ProductRepo productRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProductStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> products = IntStream.rangeClosed(1,4000)
                .mapToObj(i->new Product("product"+i, BigDecimal.valueOf(new Random().nextDouble(5000))))
                .toList();

    }
}
