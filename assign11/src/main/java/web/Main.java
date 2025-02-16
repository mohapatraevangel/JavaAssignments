package web;
/*We required  to create Book store application for well know publisher BPB publisher. Application  consist of  all the CRUD operations such as adding a book, editing a book, deleting a book, finding an specfic book and listing out all the books. Initially client is planning to use JDBC but in near future they will go for an suitable ORM tool such as hibernate.

        Instructions:
        1. You need to keep design flexible so that in future we can change technologies in persistance layer without disturbing other layers.
2. Explore 3 tier application design ie web layer, service layer and persistance layer from SO
3. Refer SO what is the need of Exception wrapper and exception rethrowing for persistance layer


Step 1: Creating hard coded book store application

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private double price;

    //getter setter , ctr
}

public interface BookDao {
    public List<Book> getAllBooks()throws DaoException;
    public Book addBook(Book book) throws DaoException;
    public void deleteBook(int id) throws DaoException;
    public void updateBook(int id, Book book) throws DaoException;
    public Book getBookById(int id) throws DaoException;
}


public class BookDaoImp implements BookDao {
    // write code
}

Create book store CRUD application using JDBC
Test using some sample records of you favourite books
*/

import exceptions.BookNotFoundException;
import repository.Book;
import service.BookServiceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));
    public static void main(String[] args) {
       // System.out.println("________All Books_______");
        logger.info("Book store application");
        BookServiceImpl bsi=new BookServiceImpl();
        bsi.addBook(new Book("1234","The Alchemist","Paulo Coelho",100.0));
        bsi.deleteBook(2);
        bsi.updateBook(1,new Book("23er4543","1234","The Alchemist",100.0));
            bsi.getAllBooks().forEach(System.out::println);
        logger.info(" Book by ID");
        //System.out.println("\n\n Book by ID");
            bsi.getBookById(1).forEach(System.out::println);
        }


        }




