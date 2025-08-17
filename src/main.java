import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // Parent class Book
    public static class Book {
        protected String title;
        protected String author;
        protected String isbn;
        protected boolean available;

        public void setBookDetails(String title, String author, String isbn, boolean available) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.available = available;
        }

        public void displayBookDetails() {
            System.out.println("Title       : " + title);
            System.out.println("Author      : " + author);
            System.out.println("ISBN        : " + isbn);
            System.out.println("Availability: " + (available ? "Available" : "Borrowed"));
        }

        public boolean borrowBook() {
            if (available) {
                available = false;
                System.out.println("You have successfully borrowed \"" + title + "\".");
                return true;
            } else {
                System.out.println("Sorry, \"" + title + "\" is currently borrowed.");
                return false;
            }
        }

        public void returnBook() {
            available = true;
            System.out.println("You have returned \"" + title + "\". Thank you!");
        }
    }

    // Subclass: HardCopyBook
    public static class HardCopyBook extends Book {
        private int pageCount;
        private double weightKg;

        public void setHardCopyDetails(String title, String author, String isbn, boolean available, int pageCount, double weightKg) {
            setBookDetails(title, author, isbn, available);
            this.pageCount = pageCount;
            this.weightKg = weightKg;
        }

        @Override
        public void displayBookDetails() {
            super.displayBookDetails();
            System.out.println("Pages       : " + pageCount);
            System.out.println("Weight      : " + weightKg + " kg");
            System.out.println("------------------------------");
        }
    }

    // Subclass: EBook
    public static class EBook extends Book {
        private String format;
        private double fileSizeMB;

        public void setEBookDetails(String title, String author, String isbn, boolean available, String format, double fileSizeMB) {
            setBookDetails(title, author, isbn, available);
            this.format = format;
            this.fileSizeMB = fileSizeMB;
        }

        @Override
        public void displayBookDetails() {
            super.displayBookDetails();
            System.out.println("Format      : " + format);
            System.out.println("File Size   : " + fileSizeMB + " MB");
            System.out.println("------------------------------");
        }
    }

    // 🔹 Sort books in ascending order by title
    public static void sortBooksAscending(Book[] books) {
        Arrays.sort(books, Comparator.comparing(b -> b.title, String.CASE_INSENSITIVE_ORDER));
    }

    // Ma
