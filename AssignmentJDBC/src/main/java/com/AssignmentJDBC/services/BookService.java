package com.AssignmentJDBC.services;

import com.AssignmentJDBC.dao.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public Book getBook(int id);
    public List<Book> getAllBooks();
    public void updateBook(Book book);
    public void deleteBook(int id);
}
