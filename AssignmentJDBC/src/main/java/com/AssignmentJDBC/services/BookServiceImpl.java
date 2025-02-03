package com.AssignmentJDBC.services;

import com.AssignmentJDBC.dao.Book;
import com.AssignmentJDBC.dao.BookDao;
import com.AssignmentJDBC.dao.BookDaoImpl;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {

    }

    @Override
    public Book getBook(int id) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
      return  bookDao.getAllBooks();

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(int id) {

    }
}
