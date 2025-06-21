import java.util.Arrays;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void displayBook() {
        System.out.println("Book ID: " + bookId + ", Title: \"" + title + "\", Author: " + author);
    }
}

public class LibraryManager {
    
    static Book[] books = {
        new Book(101, "A Brief History of Time", "Stephen Hawking"),
        new Book(102, "The Alchemist", "Paulo Coelho"),
        new Book(103, "Clean Code", "Robert C. Martin"),
        new Book(104, "Design Patterns", "Erich Gamma"),
        new Book(105, "Java: The Complete Reference", "Herbert Schildt")
    };

    
    static void linearSearch(String title) {
        System.out.println("\n Linear Search for: " + title);
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println(" Book found:");
                book.displayBook();
                return;
            }
        }
        System.out.println(" Book not found.");
    }

    
    static void binarySearch(String title) {
        System.out.println("\n Binary Search for: " + title);

        
        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));

        int left = 0, right = sortedBooks.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = title.compareToIgnoreCase(sortedBooks[mid].title);
            if (cmp == 0) {
                System.out.println(" Book found:");
                sortedBooks[mid].displayBook();
                return;
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(" Book not found.");
    }

    
    static void showAllBooks() {
        System.out.println("\n Book List:");
        for (Book book : books) {
            book.displayBook();
        }
    }

    public static void main(String[] args) {
        showAllBooks();

        
        linearSearch("Clean Code");
        linearSearch("Invisible Man");

        
        binarySearch("The Alchemist");
        binarySearch("Unknown Book");
    }
}
