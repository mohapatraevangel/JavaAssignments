package service;

import repository.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public void deleteBook(int id);
    public boolean updateBook(int id, Book book);
    public List<Book> getBookById(int id);}
