package service;

import exceptions.BookNotFoundException;
import exceptions.DAOException;
import repository.Book;
import repository.BookDao;
import repository.BookDaoImp;

import java.util.List;
import java.util.logging.Logger;

public class BookServiceImpl implements BookService {
    private static final Logger logger = Logger.getLogger(String.valueOf(BookServiceImpl.class));
    private BookDao bookDao=new BookDaoImp();


    @Override
    public List<Book> getAllBooks() {
        try {

            return bookDao.getAllBooks();
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }
    }

    @Override
    public Book addBook(Book book) {
        try{
            return bookDao.addBook(book);
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }

    }

    @Override
    public void deleteBook(int id) {
        try{
            bookDao.deleteBook(id);
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }


    }

    @Override
    public boolean updateBook(int id, Book book) {
        try{
            bookDao.updateBook(id,book);
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }


        return updateBook(id, book);
    }

    @Override
    public List<Book> getBookById(int id) {
        try{
            return bookDao.getBookById(id);
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }

    }
}
