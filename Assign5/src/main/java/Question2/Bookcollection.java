package Question2;
import java.util.Arrays;

public class Bookcollection {
        private String ownerName;
        private ques2[] books;

        // Constructor to initialize owner and book array
        public Bookcollection(String ownerName, ques2[] books) {
            this.ownerName = ownerName;
            this.books = books;
        }

        // Method to check if the collection contains a specific book
        public boolean hasBook(ques2 b) {
            for (ques2 book : books) {
                if (book.equals(b)) {
                    return true;
                }
            }
            return false;
        }

        // Method to sort books by title and author (lexicographically)
        public void sort() {
            Arrays.sort(books, (b1, b2) -> {
                int titleComparison = b1.getTitle().compareTo(b2.getTitle());
                if (titleComparison == 0) {
                    return b1.getAuthor().compareTo(b2.getAuthor());
                }
                return titleComparison;
            });
        }

        // Override toString to output the book collection in a nice format
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Owner: ").append(ownerName).append("\nBooks:\n");
            for (ques2 book : books) {
                sb.append(book.toString()).append("\n");
            }
            return sb.toString();
        }
    }

