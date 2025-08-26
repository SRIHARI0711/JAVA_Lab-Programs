package Book_management;

import java.util.*;

public class BookManager {
    ArrayList<Book> blist = new ArrayList<>();
    HashMap<Integer, Book> hbook = new HashMap<>();
    ArrayList<Book> sortedList = new ArrayList<>();
    ArrayList<Book> costlyList = new ArrayList<>();

    public void addBooks(Book b) {
        blist.add(b);
    }

    public void displayBooks() {
        for (Book b : blist) {
            System.out.println(b);
        }
    }

    public void addHash() {
        int id = 1;
        for (Book b : blist) {
            hbook.put(id++, b);
        }
    }

    public void displayHash() {
        for (Map.Entry<Integer, Book> hm : hbook.entrySet()) {
            int k = hm.getKey();
            Book b = hm.getValue();
            System.out.println("ID: " + k + " " + b);
        }
    }

    public void sortBooks() {
        sortedList = new ArrayList<>(blist);
        sortedList.sort(Comparator.comparingDouble(book -> book.price));
        for (Book b : sortedList) {
            System.out.println(b);
        }
    }

    public void searchAuthor(String name) {
        boolean found = false;
        for (Book b : sortedList) {
            if (b.author.equalsIgnoreCase(name)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author: " + name);
        }
    }

    public void costlyBooks(float threshold) {
        costlyList.clear();
        for (Book b : sortedList) {
            if (b.price > threshold) {
                costlyList.add(b);
            }
        }

        if (costlyList.isEmpty()) {
            System.out.println("No books found with price greater than " + threshold);
        } else {
            System.out.println("Books with price greater than " + threshold + ":");
            for (Book b : costlyList) {
                System.out.println(b);
            }
        }
    }

    public static void main(String[] args) {
        BookManager bm = new BookManager();

        // Add books
        bm.addBooks(new Book("Java Programming", "John Doe", "Tech Press", 29.99f));
        bm.addBooks(new Book("Python Basics", "Jane Smith", "Code House", 19.99f));
        bm.addBooks(new Book("Data Structures", "Alice Johnson", "Learn Hub", 39.99f));
        bm.addBooks(new Book("Web Development", "Bob Brown", "Web World", 49.99f));
        bm.addBooks(new Book("Machine Learning", "Charlie White", "AI Press", 59.99f));

        // Display books
        System.out.println("Books in my ArrayList (blist):");
        bm.displayBooks();

        // Store in HashMap and display
        bm.addHash();
        System.out.println("\nBooks in my HashMap (hbook):");
        bm.displayHash();

        // Sort and display
        System.out.println("\nBooks sorted by price:");
        bm.sortBooks();

        Scanner sc = new Scanner(System.in);
        // Search by author
        System.out.print("\nEnter author name to search: ");
        String author = sc.nextLine();
        bm.searchAuthor(author);

        // Costly books
        System.out.print("\nEnter minimum price to list costly books: ");
        float price = sc.nextFloat();
        bm.costlyBooks(price);

        sc.close();
    }
}
