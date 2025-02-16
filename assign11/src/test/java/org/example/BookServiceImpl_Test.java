package org.example;


import exceptions.BookNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.Book;
import repository.BookDao;
import service.BookServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceImpl_Test {
    @Mock
    private BookDao bookRepo;

    @InjectMocks
    private BookServiceImpl bookServiceImplementation;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("978-3-16-148410-0", "JAVA", "Author1",  119.99);
    }

    @AfterEach
    void reset() {
        book = null;
    }

    @Tag("dev")
    @Test
    void getAllBooks() {
        List<Book> books = Collections.singletonList(book);
        Mockito.when(bookRepo.getAllBooks()).thenReturn(books);

        List<Book> result = bookServiceImplementation.getAllBooks();
        assertEquals(1, result.size());
    }

    @Tag("dev")
    @Test
    void addBook() {
        Book book = new Book("978-3-16-148410-0", "Python", "Author2",  119.99);
        Mockito.when(bookRepo.addBook(book)).thenReturn(book);

        Book result = bookServiceImplementation.addBook(book);
        assertNotNull(result);
        assertEquals(result, book);
    }




    @Tag("dev")
    @Test
    void updateBookSuccess() throws BookNotFoundException {
        int bookId = 1;


        boolean result = bookServiceImplementation.updateBook(bookId, book);
        assertTrue(result);
    }

    @Tag("dev")
    @Test
    void updateBookFailure() throws BookNotFoundException {
        int bookId = 1;


        assertThrows(BookNotFoundException.class, () -> bookServiceImplementation.updateBook(bookId, book));
    }

    @Tag("dev")
    @Test
    void getBookByIdSuccess() throws BookNotFoundException {
        int bookId = 1;
        Mockito.when(bookRepo.getBookById(bookId)).thenReturn((List<Book>) book);

        Book result = (Book) bookServiceImplementation.getBookById(bookId);
        assertNotNull(result);
        assertEquals("The Great Adventure", result.getTitle());
    }

    @Tag("dev")
    @Test
    void getBookByIdFailure() throws BookNotFoundException {
        int bookId = 1;
        Mockito.when(bookRepo.getBookById(bookId)).thenThrow(new BookNotFoundException("Book Not found"));

        assertThrows(BookNotFoundException.class, () -> bookServiceImplementation.getBookById(bookId));
    }
}