package com.AssignmentJDBC.dao;

import com.AssignmentJDBC.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private Connection connection;
    public BookDaoImpl() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public List<Book> getAllBooks() {
        //select * from Book
        List<Book> books = new ArrayList<Book>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from book1");
            ResultSet rs = ps.executeQuery();
            System.out.println("Here is the list of books");
            while (rs.next()) {
                books.add(new Book(rs.getString("isbn"),rs.getString("title"),
                        rs.getString("author"),rs.getDouble("price")));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getBookById(int id)
        {
            PreparedStatement ps =connection.prepareStatement("select * from book1 where id=?");
            ps.setInt(1,id);
        return null;
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(int id) {

    }
}
