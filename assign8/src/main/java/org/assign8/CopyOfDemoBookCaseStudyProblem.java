package org.assign8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CopyOfDemoBookCaseStudyProblem {
    public static void main(String[] args) {

        List<Book> allBooks = loadAllBooks();

        // 1. Find books with more then 400 pages
        List<Book>booksMoreThen400Pages=allBooks.stream()
                .filter(b-> b.getPages()>400).toList();
        booksMoreThen400Pages.forEach(System.out::println);

        // 2. Find all books that are java books and more then 400 pages
        List<Book> javaBooksMoreThen400Pages=allBooks.stream().
                filter(b->b.getSubject().equals(Subject.JAVA))
                .filter(b->b.getPages()>400).toList();

        javaBooksMoreThen400Pages.forEach(System.out::println);

        // 3. We need the top three longest books
        List<Book>  topThreeLongestBooks=allBooks.stream()
                .sorted(Comparator.comparing(Book::getPages).reversed())
                .limit(3).toList();

        // 4. We need from the fourth to the last longest books
        List<Book>  fourthToLastLongestBooks=allBooks.stream()
                .sorted(Comparator.comparing(Book::getPages).reversed())
                .skip(3).collect(Collectors.toList());

        // 5. We need to get all the publishing years
        List<Integer>  publishingYears=allBooks.stream()
                .map(Book::getYear).collect(Collectors.toList());

        // 6. We need all the authors names who have written a book
        List<String>  authorsNames=allBooks.stream()
                .map(Book::getAuthors).flatMap(Collection::stream)
                .map(Author::getName).collect(Collectors.toList());



        // We need all the origin countries of the authors
//        List<String>  originCountries= allBooks.stream()
//                .map(Book::getAuthors).flatMap(Collection::stream)
//                .map(Author::getOriginCountry).flatMap(Collection::stream)
//                .collect(Collectors.toList());

        // We want the most recent published book.
        Optional<Book> maxYearBook = allBooks.stream()
                .max(Comparator.comparingInt(Book::getYear));

        System.out.println("---------------");
        String message = maxYearBook.map(b -> b.getTitle()).orElse("book not found");


        // We want to know if all the books are written by more than one author
        boolean allMatch = allBooks.stream()
                .allMatch(b->b.getAuthors().size()>1);
        System.out.println(allMatch);

        // We want one of the books written by more than one author. (findAny)
        Optional<Book> findAny = allBooks.stream()
                .filter(b->b.getAuthors().size()>1)
                .findAny();
        findAny.ifPresent(System.out::println);

        // We want the total number of pages published.
        IntSummaryStatistics summaryStatistics = allBooks.stream()
                .collect(Collectors.summarizingInt(Book::getPages));


        // We want to know how many pages the longest book has.



        // We want the average number of pages of the books

        // We want all the titles of the books
        List<String> allTitles = allBooks.stream()
                .map(Book::getTitle).toList();


        // We want the book with the higher number of authors?



        // We want a Map of book per year.

        //Select * from emp group by having;
        Map<Integer, List<Book>>mapBooks=allBooks
                .stream()
                .collect(groupingBy(Book::getYear));

        mapBooks.forEach((k,v)-> System.out.println(k+": "+v));

        // We want to count how many books are published per year.
        List <Integer>countBooksPerYear = allBooks.stream()
                .map(Book::getYear).toList();



    }

    private static List<Book> loadAllBooks() {
        List<Book> books = new ArrayList<Book>();
        List<Author> authors1 = Arrays
                .asList(new Author("raj", "gupta",
                                "in", Arrays.asList("in","usa","aus")),
                        new Author("ekta", "gupta", "in",
                                Arrays.asList("in","usa")));

        List<Author> authors2 = Arrays.asList
                (new Author("raj", "gupta", "in",Arrays.asList("in","usa","aus"))
                );

        List<Author> authors3 = Arrays
                .asList(new Author("gunika", "gupta",
                                "us",Arrays.asList("in","usa","china")),
                        new Author("keshav", "gupta", "us"
                                ,Arrays.asList("in","china")));


        books.add(new Book("java", authors1, 400, Subject.JAVA, 2000, "1213"));
        books.add(new Book("python", authors2, 479, Subject.JAVA, 2007, "1218"));
        books.add(new Book("Mgt", authors3, 600, Subject.DOT_NET, 2000, "1293"));




        return books;
    }

}
