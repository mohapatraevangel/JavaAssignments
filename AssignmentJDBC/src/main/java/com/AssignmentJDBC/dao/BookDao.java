package com.AssignmentJDBC.dao;

import java.util.List;

public interface BookDao {
    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public void addBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(int id);

}
