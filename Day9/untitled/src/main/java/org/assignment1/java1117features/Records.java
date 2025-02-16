package org.assignment1.java1117features;
interface Printable {
    void print();
}
record Book(String title, String author) implements Printable {
    @Override
    public void print() {
        System.out.println("Book: " + title + " by " + author);
    }
}
public class D_Records {
    public static void main(String[] args) {

        Book book = new Book("Java Programming", "John Doe");


        book.print();
    }
}