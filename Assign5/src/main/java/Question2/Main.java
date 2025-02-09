package Question2;

import java.awt.print.Book;

public class Main {
        public static void main(String[] args) {
            // Create some books
            Book book1 = new Book("Java in Depth", "Rahul");
            Book book2 = new Book("Learning Java", "Jeet");
            Book book3 = new Book("Java in Depth", "Mohit"); // Duplicate
            Book book4 = new Book("Advanced Java", "Kunal");

            // Create a BookCollection
            Book[] books = {book1, book2, book3, book4};
            Bookcollection myBooks = new Bookcollection("Rahul", books);

            // Check if a specific book is in the collection
            Book searchBook = new Book("Java in Depth", "Rahul");
            if (myBooks.hasBook(searchBook)) {
                System.out.println("You own the book: " + searchBook.getTitle());
            } else {
                System.out.println("You do not own the book: " + searchBook.getTitle());
            }

            // Sort the collection
            myBooks.sort();

            // Output the sorted BookCollection
            System.out.println("\nSorted BookCollection:\n");
            System.out.println(myBooks);
        }
    }
