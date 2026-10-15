import java.util.List;

// View - console
public class LibrarySystem {

    public static void main(String[] args) {
        LibraryController controller = new LibraryController();

        controller.addNewBook("Clean Coding", "Robert Martin");
        controller.addNewBook("Harry Potter", "Rose Taylor");

        controller.registerUser("john", 1);

        controller.borrowBook("Harry Potter");
        List<Book> books = controller.getAvailableBooks();
        for (Book book : books) {
            System.out.println(book);
        }

        controller.returnBook("Harry Potter");
        books = controller.getAvailableBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}