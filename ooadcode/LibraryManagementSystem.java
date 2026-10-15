class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
}

interface Readable {
    void read();
}

interface Printable {
    void print();
}

class BookPrinter implements Printable {
    private Book book;

    public BookPrinter(Book book) {
        this.book = book;
    }

    @Override
    public void print() {
        System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
    }
}

interface DiscountPolicy {
    double applyDiscount(double price);
}

class PercentageDiscount implements DiscountPolicy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * percentage / 100);
    }
}

class FlatDiscount implements DiscountPolicy {
    private double amount;

    public FlatDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - amount;
    }
}

interface BookRepository {
    void save(Book book);
    Book find(String title);
}

class InMemoryBookRepository implements BookRepository {
    private java.util.Map<String, Book> storage = new java.util.HashMap<>();

    @Override
    public void save(Book book) {
        storage.put(book.getTitle(), book);
    }

    @Override
    public Book find(String title) {
        return storage.get(title);
    }
}

class LibraryService {
    private BookRepository repository;
    private DiscountPolicy discountPolicy;

    public LibraryService(BookRepository repository, DiscountPolicy discountPolicy) {
        this.repository = repository;
        this.discountPolicy = discountPolicy;
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public void sellBook(String title) {
        Book book = repository.find(title);
        if (book != null) {
            double finalPrice = discountPolicy.applyDiscount(book.getPrice());
            System.out.println("Sold '" + book.getTitle() + "' for $" + finalPrice);
        } else {
            System.out.println("Book not found!");
        }
    }
}

// --- Main Program ---
public class LibraryManagementSystem {
    public static void main(String[] args) {
        BookRepository repo = new InMemoryBookRepository();
        DiscountPolicy discount = new PercentageDiscount(10); 
        LibraryService service = new LibraryService(repo, discount);

        Book book1 = new Book("Clean Code", "Robert C. Martin", 500);
        Book book2 = new Book("Effective Java", "Joshua Bloch", 600);

        service.addBook(book1);
        service.addBook(book2);

        BookPrinter printer = new BookPrinter(book1);
        printer.print();

        service.sellBook("Clean Code");
        service.sellBook("Effective Java");
    }
}