package service;

import entities.Book;
import repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class Bookapp01Application implements CommandLineRunner {

    @Autowired
    private BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(Bookapp01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        bookRepo.save(new Book("123", "Rich dad poor dad", "LifeSkill", "RK", BigDecimal.valueOf(200.00)));
        bookRepo.save(new Book("456", "The Alchemist", "LifeSkill", "foo", BigDecimal.valueOf(300.00)));
    }
}