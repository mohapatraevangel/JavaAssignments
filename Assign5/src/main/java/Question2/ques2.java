package Question2;

public class ques2 {
        private String title;
        private String author;

        // Constructor
        public ques2(String title, String author) {
            this.title = title;
            this.author = author;
        }

        // Getters
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        // Overriding equals method to compare Book objects by title and author
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ques2 book = (ques2) obj;
            return title.equals(book.title) && author.equals(book.author);
        }

        // Overriding hashCode to ensure consistent hashing when comparing books
        @Override
        public int hashCode() {
            return 31 * title.hashCode() + author.hashCode();
        }

        // Override toString to represent the book in a readable format
        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author;
        }
    }
