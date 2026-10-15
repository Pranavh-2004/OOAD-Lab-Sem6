import java.util.HashMap;
import java.util.Map;

class BookType {
    // Intrinsic attributes
    String type;
    String distributor;

    // Constructor for intrinsic attributes
    public BookType(String type, String distributor) {
        this.type = type;
        this.distributor = distributor;
    }

   }

class Book {
    // Extrinsic attributes
    private String name;
    private double price;
    
    // Reference to intrinsic attributes
    BookType bookType;

    // Constructor for Book which takes a BookType object and extrinsic attributes
    public Book(BookType bookType, String name, double price) {
        this.bookType = bookType;
        this.name = name;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Type: " + bookType.type); // Accessing intrinsic attribute directly
        System.out.println("Distributor: " + bookType.distributor); // Accessing intrinsic attribute directly
    }
}


class BookFactory {
    private static final Map<String, BookType> bookTypeMap = new HashMap<>();

    public static BookType getBookType(String type, String distributor) {
        String key = type + distributor; // Unique key for each combination of intrinsic attributes
        if (!bookTypeMap.containsKey(key)) {
            bookTypeMap.put(key, new BookType(type, distributor));
            System.out.println("Creating new BookType object: " + key);
        }
        return bookTypeMap.get(key);
    }

    public static Book getBook(String type, String distributor, String name, double price) {
        BookType bookType = getBookType(type, distributor);
        return new Book(bookType, name, price);
    }
}

public class flyweight_bookdemo {
    public static void main(String[] args) {
        // Get books from the factory
        Book book1 = BookFactory.getBook("Fiction", "Penguin Random House", "The Great Gatsby", 10.99);
        book1.displayDetails();

        Book book2 = BookFactory.getBook("Fiction", "Penguin Random House", "Corner House", 8.99);
        book2.displayDetails();

        Book book3 = BookFactory.getBook("Non-Fiction", "HarperCollins", "Sapiens", 15.50);
        book3.displayDetails();

        // Verify that the same instance is used for the same intrinsic properties
        System.out.println(book1 == book2); // Should print false since they have different names and prices but share intrinsic properties.
 System.out.println(book1.bookType == book2.bookType); 
 System.out.println(book1.bookType); 
 System.out.println(book2.bookType); 
    }
}
