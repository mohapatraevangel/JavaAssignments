package com.AssignmentJDBC.web;

import com.AssignmentJDBC.services.BookServiceImpl;

public class Main {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.getAllBooks().forEach(System.out::println);

    }
}
